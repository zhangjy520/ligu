package cc.ligu.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public void test(String t){
        System.out.println(t+"秒后调用了test:");
    }

    public void test1(String t, ArrayList<String> tes){
        System.out.println(t+"秒后调用了test1:list的第一个参数是"+tes.get(0));
    }

    public static void main(String[] args) {
        String aad = "{分管领导:'hjjhjjj',主任:'hjj',管理员:'jjj'}";
        JSONObject res = JSONObject.fromObject(aad);
//        JSONObject res1 = JSONObject.fromObject("{分管领导:'hjjhjjj',主任:'hjj',管理员:'jjj}");
        System.out.println(res.toString());
    }
    static Map<Object,Map<Object,Map<Object,Map<Object,List<Map<String,String>>>>>> m = new HashMap();
}
