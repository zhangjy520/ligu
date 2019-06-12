package cc.ligu.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;


import java.util.*;

public class Test {
    public void test(String t){
        System.out.println(t+"秒后调用了test:");
    }

    public void test1(String t, ArrayList<String> tes){
        System.out.println(t+"秒后调用了test1:list的第一个参数是"+tes.get(0));
    }

    public static List<Map> list = new ArrayList<>();
    public static void generateJson(){
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 2000; j++) {
            int startIndex = j*8;
            for (int i = 0; i < 8; i++) {
                if (i==0){
                    String aa ="{id:"+(i+startIndex)+",pId:"+0+",name:\"test"+i+"\", open:true},";
                    sb.append(aa);
                }else{
                    String aa ="{id:"+(i+startIndex)+",pId:"+(i+startIndex-1)+",name:\"test"+i+"\", open:true},";
                    sb.append(aa);
                }
            }
        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        generateJson();

        System.out.println(list);

        String aad = "{分管领导:'hjjhjjj',主任:'hjj',管理员:'jjj'}";
        JSONObject res = JSONObject.fromObject(aad);
//        JSONObject res1 = JSONObject.fromObject("{分管领导:'hjjhjjj',主任:'hjj',管理员:'jjj}");
        System.out.println(res.toString());
    }
    static Map<Object,Map<Object,Map<Object,Map<Object,List<Map<String,String>>>>>> m = new HashMap();
}
