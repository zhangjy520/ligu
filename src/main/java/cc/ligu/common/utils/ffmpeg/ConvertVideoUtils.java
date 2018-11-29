package cc.ligu.common.utils.ffmpeg;

/**
 * Created by alpha on 18-1-30.
 */

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ConvertVideoUtils {

    private Date dt;
    private long beginTime;
    private String sourceVideoPath;//待转换源视频路径
    private String fileRealname; // 文件名 不包括扩展名
    private String filename; // 包括扩展名
    private String imageRealPath; // 截图的存放目录
    private String targetfolder; // 转换后视频的目录


    public ConvertVideoUtils() {
    }

    public ConvertVideoUtils(String path, String targetfolder, String imageRealPath) {
        this.sourceVideoPath = path;
        this.targetfolder = targetfolder;
        this.imageRealPath = imageRealPath;
    }

    public String getPATH() {
        return sourceVideoPath;
    }

    public void setPATH(String path) {
        sourceVideoPath = path;
    }

    /**
     * @param targetExtension targetExtension 目标视频扩展名 .xxx
     * @param isDelSourseFile 转换完成后是否删除源文件
     * @return
     */
    public boolean beginConver(String targetExtension, boolean isDelSourseFile) {
        File fi = new File(sourceVideoPath);
        filename = fi.getName();
        fileRealname = filename.substring(0, filename.lastIndexOf(".")).toLowerCase();
        System.out.println("----接收到文件(" + sourceVideoPath + ")需要转换-------------------------- ");
        if (!checkfile(sourceVideoPath)) {
            System.out.println(sourceVideoPath + "文件不存在" + " ");
            return false;
        }
        dt = new Date();
        beginTime = dt.getTime();
        System.out.println("----开始转文件(" + sourceVideoPath + ")-------------------------- ");
        if (process(targetExtension, isDelSourseFile)) {
            Date dt2 = new Date();
            System.out.println("转换成功 ");
            long endTime = dt2.getTime();
            long timeDiff = (endTime - beginTime);
            System.out.println("转换视频格式共用了:" + timeDiff / 1000 + " s");
            if (processImg(targetfolder + fileRealname + targetExtension)) {
                System.out.println("screenshot success-截图成功了！ ");
            } else {
                System.out.println("screenshot fail-截图失败了！ ");
            }
            if (isDelSourseFile) {
                deleteFile(sourceVideoPath);
            }
            sourceVideoPath = null;
            return true;
        } else {
            sourceVideoPath = null;
            return false;
        }
    }

    /**
     * 对视频进行截图
     *
     * @param sourceVideoPath 需要被截图的视频路径（包含文件名和扩展名）
     * @return
     */
    public boolean processImg(String sourceVideoPath) {
        if (!checkfile(sourceVideoPath)) {
            System.out.println(sourceVideoPath + " is not file");
            return false;
        }
        File fi = new File(sourceVideoPath);
        filename = fi.getName();
        fileRealname = filename.substring(0, filename.lastIndexOf(".")).toLowerCase();
        List<String> commend = new java.util.ArrayList<String>();
        //第一帧： 00:00:01
        //time ffmpeg -ss 00:00:01 -i test1.flv -f image2 -y test1.jpg
        commend.add(Contants.ffmpegPath);
        commend.add("-i");
        commend.add(sourceVideoPath);
        commend.add("-y");
        commend.add("-f");
        commend.add("image2");
        commend.add("-ss");
        commend.add("38");
        commend.add("-t");
        commend.add("0.001");
        commend.add("-s");
        commend.add("320x240");
        commend.add("-ss");
        commend.add("00:00:01");
        commend.add("-i");
        commend.add(sourceVideoPath);
        commend.add("-f");
        commend.add("image2");
        commend.add("-y");
        commend.add(imageRealPath + fileRealname + ".jpg");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            String cmd = commend.toString();
            System.out.println(cmd);
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            p.destroy();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 实际转换视频格式的方法
     *
     * @param targetExtension 目标视频扩展名
     * @param isDelSourseFile 转换完成后是否删除源文件
     * @return
     */
    private boolean process(String targetExtension, boolean isDelSourseFile) {
        int type = checkContentType();
        boolean status = false;
        if (type == 0) {
            //如果type为0用ffmpeg直接转换
            status = processVideoFormat(sourceVideoPath, targetExtension, isDelSourseFile);
        } else if (type == 1) {
            //如果type为1，将其他文件先转换为avi，然后在用ffmpeg转换为指定格式
            String avifilepath = processAVI(type);
            if (avifilepath == null) {
                // avi文件没有得到
                return false;
            } else {
                System.out.println("开始转换:");
                status = processVideoFormat(avifilepath, targetExtension, isDelSourseFile);
            }
        }
        return status;
    }

    /**
     * 检查文件类型
     *
     * @return
     */
    private int checkContentType() {
        String type = sourceVideoPath.substring(sourceVideoPath.lastIndexOf(".") + 1, sourceVideoPath.length()).toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }

    /**
     * 检查文件是否存在
     *
     * @param path
     * @return
     */
    private boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
     *
     * @param type
     * @return
     */
    private String processAVI(int type) {
        List<String> commend = new java.util.ArrayList<String>();
        commend.add(Contants.mencoderPath);
        commend.add(sourceVideoPath);
        commend.add("-oac");
        commend.add("mp3lame");
        commend.add("-lameopts");
        commend.add("preset=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(targetfolder + fileRealname + ".avi");
        // 命令类型：mencoder 1.rmvb -oac mp3lame -lameopts preset=64 -ovc xvid
        // -xvidencopts bitrate=600 -of avi -o rmvb.avi
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            return targetfolder + fileRealname + ".avi";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 转换为指定格式
     * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     *
     * @param oldfilepath
     * @param targetExtension 目标格式扩展名 .xxx
     * @param isDelSourseFile 转换完成后是否删除源文件
     * @return
     */
    private boolean processVideoFormat(String oldfilepath, String targetExtension, boolean isDelSourseFile) {
        if (!checkfile(sourceVideoPath)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }
        //ffmpeg -i FILE_NAME.flv -ar 22050 NEW_FILE_NAME.mp4
        //ffmpeg -i infile -ab 128 -acodec libmp3lame -ac 1 -ar 22050 -r 29.97 -qscale 6 -y outfile
        //ffmpeg  -i  uploadfile/video/test.wmv -c:v libx264 -strict -2 uploadfile/mp4/test.mp4
        //ffmpeg  -i 4.avi  -vcodec copy  abc.mp4
        List<String> commend = new java.util.ArrayList<>();
        commend.add(Contants.ffmpegPath);
        commend.add("-i");
        commend.add(oldfilepath);
        commend.add("-c:v");
        commend.add("libx264");
        commend.add("-strict");
        commend.add("-2");
        commend.add(targetfolder + fileRealname + targetExtension);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            String cmd = commend.toString();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            p.destroy();
            //转换完成后删除源文件
            if (isDelSourseFile) {
                deleteFile(sourceVideoPath);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     *
     * @param oldfilepath
     * @return
     */
    private boolean processFLV(String oldfilepath) {
        if (!checkfile(sourceVideoPath)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }
        List<String> commend = new java.util.ArrayList<>();
        commend.add(Contants.ffmpegPath);
        commend.add("-i");
        commend.add(oldfilepath);
        commend.add("-ab");
        commend.add("64");
        commend.add("-acodec");
        commend.add("mp3");
        commend.add("-ac");
        commend.add("2");
        commend.add("-ar");
        commend.add("22050");
        commend.add("-b");
        commend.add("230");
        commend.add("-r");
        commend.add("24");
        commend.add("-y");
        commend.add(targetfolder + fileRealname + ".flv");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            String cmd = commend.toString();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            p.destroy();
            deleteFile(oldfilepath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int doWaitFor(Process p) {
        InputStream in = null;
        InputStream err = null;
        int exitValue = -1; // returned to caller when p is finished
        try {
            in = p.getInputStream();
            err = p.getErrorStream();
            boolean finished = false; // Set to true when p is finished

            while (!finished) {
                try {
                    while (in.available() > 0) {
                        Character c = new Character((char) in.read());
                    }
                    while (err.available() > 0) {
                        Character c = new Character((char) err.read());
                    }

                    exitValue = p.exitValue();
                    finished = true;

                } catch (IllegalThreadStateException e) {
                    Thread.currentThread().sleep(500);
                }
            }
        } catch (Exception e) {
            System.err.println("doWaitFor();: unexpected exception - " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (err != null) {
                try {
                    err.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return exitValue;
    }

    public void deleteFile(String path) {
        if (StringUtils.isNotBlank(path)) {
            try {
                new File(path).delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

