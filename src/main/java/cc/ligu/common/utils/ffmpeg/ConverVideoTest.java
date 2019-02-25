package cc.ligu.common.utils.ffmpeg;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by alpha on 18-1-30.
 */
public class ConverVideoTest {
    public void run() {
        try {
            // 转换并截图
            String filePath = "C:\\Users\\shenyy\\Desktop\\运维项目0.wmv";
            ConvertVideoUtils cv = new ConvertVideoUtils(filePath,"C:\\Users\\shenyy\\Desktop\\","C:\\Users\\shenyy\\Desktop\\");
            String targetExtension = ".mp4";
            boolean isDelSourseFile = true;
            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile);
            System.out.println(beginConver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Date getStartOfOneDayByMonth(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month -1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    //获取n个月前(从该月第一天算起)
    public static Calendar getMonthsBefore(int month){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -month);    //得到前一个月
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    //获取n年前，从该年第一天算起
    public static Date getYearsBefore(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -year);  //得到前n年
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static void main(String args[]) {


        System.out.println(getYearsBefore(1).getTime());
        System.out.println(getYearsBefore(0).getTime());
        System.out.println(getMonthsBefore(0).getTime());
        System.out.println(getMonthsBefore(2).getTime());
        //过去（0月） 0
        //过去三个月    3
        //过去12个月   12

        ConverVideoTest c = new ConverVideoTest();
        c.run();
    }
}