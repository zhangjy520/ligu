package cc.ligu.common.utils.ffmpeg;

/**
 * Created by alpha on 18-1-30.
 */
public class ConverVideoTest {
    public void run() {
        try {
            // 转换并截图
            String filePath = "F:\\actviti资料\\4.发布流程定义.mp4";
            ConvertVideoUtils cv = new ConvertVideoUtils(filePath,"F:\\actviti资料\\","F:\\actviti资料\\");
            String targetExtension = ".mp4";
            boolean isDelSourseFile = true;
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