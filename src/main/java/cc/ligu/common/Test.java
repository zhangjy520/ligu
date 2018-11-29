package cc.ligu.common;

import java.util.ArrayList;

public class Test {
    public void test(String t){
        System.out.println(t+"秒后调用了test:");
    }

    public void test1(String t, ArrayList<String> tes){
        System.out.println(t+"秒后调用了test1:list的第一个参数是"+tes.get(0));
    }
}
