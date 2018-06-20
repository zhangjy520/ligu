package cc.ligu.common.utils.ffmpeg;

/**
 * Created by alpha on 18-1-30.
 */
public class ConverVideoTest {
    public void run() {
        try {
            // 转换并截图
            String filePath = "/home/alpha/Videos/1.avi";
            ConverVideoUtils cv = new ConverVideoUtils(filePath,"","");
            String targetExtension = ".mp4";
            boolean isDelSourseFile = false;
            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile);
            System.out.println(beginConver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ConverVideoTest c = new ConverVideoTest();
        c.run();
    }
}