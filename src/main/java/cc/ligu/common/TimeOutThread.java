package cc.ligu.common;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhangjianyu
 * @Description 定时类
 * @return
 **/
public class TimeOutThread {
    private Class callBackClass;
    private String method;
    private Object[] params;

    private boolean isCancel;
    private long delay;//延迟
    final ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(5);

    TimeOutThread() {
    }

    TimeOutThread(long delay) {
        this.delay = delay;
    }

    public TimeOutThread(long delay, Class callBackClass, String method, Object... params) {
        this.callBackClass = callBackClass;
        this.method = method;
        this.params = params;
        this.delay = delay;
    }

    public boolean isCanceled() {
        return isCancel;
    }

    public void setCanceled(boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Class getCallBackClass() {
        return callBackClass;
    }

    public TimeOutThread setCallBackClass(Class callBackClass) {
        this.callBackClass = callBackClass;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TimeOutThread setMethod(String method) {
        this.method = method;
        return this;
    }

    public Object[] getParams() {
        return params;
    }

    public TimeOutThread setParams(Object[] params) {
        this.params = params;
        return this;
    }

    public long getDelay() {
        return delay;
    }

    public TimeOutThread setDelay(long delay) {
        this.delay = delay;
        return this;
    }

    public void startThread() {
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                methodInvoke(callBackClass, method, params);
                scheduled.shutdown();//到时间就结束，不作多次报警
            }
        }, delay, 50, TimeUnit.SECONDS);//TimeUnit.MILLISECONDS执行的时间间隔数值单位
    }

    public void stopThread() {
        scheduled.shutdown();
    }

    public void test(String test, String test1) {
        System.out.println("反射调用成功了" + test + "sssss" + test1);
    }

    /**
     * @return
     * @Author zhangjianyu
     * @Description 主要用于时间超时，方法调用
     * @Param className 类字节
     * @Param methodName 方法名字
     * @Param args 方法参数
     * @Demo methodInvoke(TimeOutThread.class, " test ", " 2 ", " 3 ");
     **/
    public static void methodInvoke(Class<?> className, String methodName, Object... args) {
        try {
            HashMap m = new HashMap(1111);
            Class[] param = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                param[i] = args[i].getClass();
            }
            Method method = className.getMethod(methodName, param);
            method.invoke(className.newInstance(), args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //2秒后调用Test.test(2);
        TimeOutThread timeOutThread = new TimeOutThread(2, Test.class, "isBlank", "2aaaaa");
        timeOutThread.startThread();

        List<String> pa = new ArrayList<>();
        pa.add("测试啊啊啊啊");
        TimeOutThread timeOutThread1 = new TimeOutThread(5, Test.class, "isBlank",pa);
        timeOutThread1.startThread();
    }


}

