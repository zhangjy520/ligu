package cc.ligu.common.utils;

import com.github.pagehelper.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * 文件管理帮助类，处理应用之外的文件，如照片、邮件附件等不依赖于应用存在而存在的文件。 注意：里面的文件路径除了特殊说明外都是基于VFS根路径的
 * 
 * @author guowei
 */
public abstract class VFSUtil {
	private static Log log = LogFactory.getLog(VFSUtil.class);

	/** VFS 根路径(最后没有/号) */
	private static String VFS_ROOT_PATH;
	static {
		try {
			readVFSRootPath();// 给VFS_ROOT_PATH赋初始值
		} catch (Exception e) {
			log.error("读取配置文件出错！", e);
		}

	}

	/**
	 * 读取VFS路径配置文件
	 */
	private static void readVFSRootPath() {
		String key = null;
		if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
			key = "vfsroot.windows";
		} else {
			key = "vfsroot.linux";
		}
		try {
			Properties p = new Properties();
			InputStream inStream = new ClassPathResource("/db.properties").getInputStream();
			p.load(inStream);
			VFS_ROOT_PATH = p.getProperty(key);
		} catch (Exception e1) {
			VFS_ROOT_PATH = "";
			log.error("[vfsroot路径读取]配置文件模式出错！", e1);
		}

		if (StringUtil.isEmpty(VFS_ROOT_PATH)) {
			if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
				VFS_ROOT_PATH = "C:/gukeer/vfsroot/";
			} else {
				VFS_ROOT_PATH = "/opt/gukeer/vfsroot/";
			}
		}
	}

	/**
	 * 获取当前的VfsRootPath
	 * 
	 * @return
	 */
	public static String getVFSRootPath() {
		return VFS_ROOT_PATH;
	}

	/**
	 * @param filePath
	 *            基于VFS根路径的文件路径
	 * @return
	 */
	public static String getVFSPath(String filePath) {
		return normalize(getVFSRootPath() + "/" + filePath);
	}

	/**
	 * 根据文件路径查找某个文件，如果文件不存在的话则创建这个文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static File getVFSFile(String filePath) {
		File file = new File(getVFSPath(filePath));
		if (!file.exists()) {
			file = recursiveMakeDiectory(filePath, getVFSRootPath());
		}
		return file;
	}

	/**
	 * 根据文件路径查找某个文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static File getFile(String filePath) {
		return new File(getVFSPath(filePath));
	}

	/**
	 * 允许创建多级目录，目录名之间用/隔开，暂不支持创建失败回滚的功能
	 * 
	 * @param fileName
	 *            要创建的目录名
	 * @return 已创建的最底层的目录
	 */
	private static File recursiveMakeDiectory(String fileName, String root) {
		root = normalize(root);
		StringTokenizer directories = new StringTokenizer(normalize(fileName), "/");
		File parent = new File(root);
		while (directories.hasMoreTokens()) {
			String name = directories.nextToken();
			parent = new File(parent, name);

			if (log.isInfoEnabled()) {
				log.info("will create the directory [" + parent.getAbsolutePath() + "]");
			}
			if (!parent.exists()) {
				if (log.isInfoEnabled()) {
					log.info("creating the directory [" + parent.getAbsolutePath() + "]");
				}

				if (!parent.mkdir()) {
					String msg = "fail to created the directory [" + parent.getAbsolutePath() + "]";
					if (log.isInfoEnabled()) {
						log.info(msg);
					}
					throw new FileOperationException(msg);
				}
			}
		}
		return parent;
	}

	private static String normalize(String original) {
		if (log.isDebugEnabled()) {
			log.debug("normalize前[" + original + "]");
		}

		original = original.replace('\\', '/');
		original = eliminateRedundantSlassh(original);

		/**
		 * in Linux(Unix like) system, must add prefix "/", unckecked, and in
		 * WindowNT, if there is no ":", shoulb add one.
		 */
		if (original.indexOf(':') == -1) {
			if (!original.startsWith("/")) {
				original = "/" + original;
			}
		} else {
			if (original.startsWith("/")) {
				original = original.substring(1);
			}
		}

		if (original.endsWith("/")) {
			original = original.substring(0, original.length() - 1);
		}

		if (log.isDebugEnabled()) {
			log.debug("normalize后[" + original + "]");
		}

		return original;
	}

	/**
	 * 从路径名称中排除多余的 "/", 如果路径中有"\", 结果我没有测试过; 通常调用这个方法之前 一定要把 "\" 转成 "/"
	 *
	 * @return 返回排除了多余的"/"的路径
	 */
	private static String eliminateRedundantSlassh(String path) {
		if (log.isDebugEnabled()) {
			log.debug("要排除多余的'/'之前[" + path + "]");
		}

		boolean isSlash = false;
		StringBuffer result = new StringBuffer(path.length());

		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);

			if (c != '/' || !isSlash) {
				result.append(c);
			}

			isSlash = (c == '/');
		}

		if (log.isDebugEnabled()) {
			log.debug("要排除多余的'/'之前[" + path + "]");
		}

		return result.toString();
	}

	public static InputStream getInputStream(File file, boolean fileStream) {
		/**
		 * @author guiyf Apr,04,05 18:33
		 *         当前情况下不需要区分，不存在还是不可访问，而且试读一次文件流没有必要(可能占用大量内存)。
		 */
		if (fileStream == true) {// 使用文件流
			FileInputStream fin = null;
			try {
				fin = new FileInputStream(file);

			} catch (FileNotFoundException e) {
				if (log.isDebugEnabled()) {
					log.debug(e);
				}
				String msg = "找不到指定的文件[" + file.getName() + "]。";
				if (log.isDebugEnabled()) {
					log.debug(msg);
				}
				throw new FileOperationException(msg, e);
			}
			return fin;
		} else { // 使用内存流
			InputStream in = null;
			if (file != null && file.canRead() && file.isFile()) {
				try {
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					FileInputStream stream = new FileInputStream(file);
					BufferedInputStream bin = new BufferedInputStream(stream);
					int len = 0;
					byte[] b = new byte[1024];
					while ((len = bin.read(b)) != -1) {
						buffer.write(b, 0, len);
					}

					stream.close();
					in = new ByteArrayInputStream(buffer.toByteArray());
				} catch (Exception e) {
					String msg = "不能读取文件[" + file.getName() + "]";
					if (log.isErrorEnabled()) {
						log.error(msg, e);
					}
					throw new FileOperationException(msg, e);
				}
			} else {
				String msg = "不是文件或文件不可读[" + file.getName() + "]";
				if (log.isDebugEnabled()) {
					log.debug(msg);
				}
				throw new FileOperationException("不是文件或文件不可读");
			}
			return in;
		}
	}

	public static void saveFile(MultipartFile thefile, String path) {
		try {
			thefile.transferTo(VFSUtil.getVFSFile(path));
		} catch (Exception e) {
			throw new FileOperationException("保存文件出错", e);
		}
	}

	public static String saveFile(InputStream is, String path) {

		OutputStream out = null;
		try {
			String filedirpath = path.substring(0, path.lastIndexOf("/"));
			String filename = path.substring(path.lastIndexOf("/") + 1);
			File destFile = VFSUtil.getVFSFile(filedirpath);
			File file = new File(destFile.getAbsolutePath() + "/" + filename);

			out = new FileOutputStream(file);

			/*
			 * byte[] b = new byte[1024]; while (is.read(b) != -1) {
			 * out.write(b); }
			 */
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = is.read(buf)) != -1) {
				out.write(buf, 0, len);
			}

			return file.getAbsolutePath();
		} catch (Exception e) {
			throw new FileOperationException("保存文件出错", e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw new FileOperationException("保存文件出错", e);
			}
			try {
				out.close();
			} catch (IOException e) {
				throw new FileOperationException("保存文件出错", e);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(VFSUtil.VFS_ROOT_PATH);
	}
}
