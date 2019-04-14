package cc.ligu.common.utils;

import cc.ligu.common.utils.VFSUtil;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class FileUtils {
	public static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	public static BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	public static final String VFS_ROOT_PATH = VFSUtil.getVFSRootPath();
	public static final String SOURCE_ATTACH = "/source/attach/";
	public static final String UE_ATTACH = "/source/attach/ueUpload";
	public static final String UE_REMOTE_ATTACH = "/source/attach/ueRemote";
	public static final String H5_ATTACH = "/source/attach/H5/";

	public static String readStreamAsString(InputStream ins) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
		StringBuilder builder = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			builder.append(line + "\n");
			line = reader.readLine();
		}
		reader.close();
		return builder.toString();

	}

	public static void writeLines(List<String> lines, String fileName) throws IOException {
		PrintWriter writer = new PrintWriter(new FileWriter(fileName));
		for (String line : lines) {
			writer.print(line + "\r\n");
		}
		writer.close();
	}


	public static String getFileExtention(String fname) {
		int idx = fname.lastIndexOf(".");
		if (idx >= 0) {
			return fname.substring(idx);
		} else {
			return "";
		}
	}

	public static boolean isExists(String filePath) {
		if (StringUtils.isEmpty(filePath)) {
			return false;
		}
		File file = new File(filePath);
		return file.exists();
	}


	public static boolean writeFileToDisk(String path, String fileName) {

		return true;
	}

	/*
    * 全路径拿后边的文件名
    * C:\Users\Administrator\Desktop\gukeer.exe  -----> gukeer.exe
    * */
	public static String showFileName(String fullPath) {
		String[] arr = fullPath.split("/");
		if (arr.length > 1) {
			String fileName = arr[arr.length - 1];
			String resName = fileName.substring(13,fileName.length());
			return resName;
		}
		return fullPath;
	}

	/**
	 * 将图片转换成二进制
	 *
	 * @return
	 */
	public static String getImageBinary(String path) {
		String[] arr = path.split("\\.");
		String geShi ="png";
		if (arr.length>1){
			geShi = arr[arr.length-1];
		}
		File f = new File(path);
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, geShi, baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
			byte[] bytes = baos.toByteArray();

			String res = encoder.encodeBuffer(bytes).trim();
			String resView = res.replace("\r\n","");
			return "data:image/png;base64,"+resView;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将二进制转换为图片
	 *
	 * @param base64String
	 */
	public static void base64StringToImage(String base64String) {
		try {
			byte[] bytes1 = decoder.decodeBuffer(base64String);

			ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
			BufferedImage bi1 = ImageIO.read(bais);
			File w2 = new File("e://QQ.jpg");// 可以是jpg,png,gif格式
			ImageIO.write(bi1, "jpg", w2);// 不管输出什么格式图片，此处不需改动
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String aa= getImageBinary("e:/404.png");
		String aaa = aa.replace("\r\n","");
		System.out.println("data:image/png;base64,"+aaa);
	}
}
