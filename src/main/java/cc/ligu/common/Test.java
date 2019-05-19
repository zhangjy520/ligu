package cc.ligu.common;

import com.google.gson.Gson;

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
        List<Map> aa = new ArrayList<>();

        Map a1 = new HashMap();
        a1.put("area","东城区东城");
        a1.put("project_year","2015-2020");
        a1.put("company_unit","湖南省通信建设有限公司");
        a1.put("profession","全业务");
        a1.put("project_name","2222.3期无线微站工程");
        a1.put("projectId","1");
        //----------------------------------------
        Map a2 = new HashMap();
        a2.put("area","东城区东城");
        a2.put("project_year","2015-2020");
        a2.put("company_unit","湖南省通信建设有限公司");
        a2.put("profession","全业务");
        a2.put("project_name","TDD6.3期无线微站工程");
        a2.put("projectId","2");
        //----------------------------------------
        Map a3 = new HashMap();
        a3.put("area","东城区东城");
        a3.put("project_year","2017-2018");
        a3.put("company_unit","武汉贝斯特通信集团股份有限公司");
        a3.put("profession","新建管道");
        a3.put("project_name","99992018年4G网络电信普遍服务建设");
        a3.put("projectId","3");
        //----------------------------------------
        Map a4 = new HashMap();
        a4.put("area","东城区东城");
        a4.put("project_year","2017-2018");
        a4.put("company_unit","武汉贝斯特通信集团股份有限公司");
        a4.put("profession","无线微站");
        a4.put("project_name","自治州2018年4G网络电信普遍服务建设");
        a4.put("projectId","4");
        //----------------------------------------
        Map a5 = new HashMap();
        a5.put("area","西城区西城");
        a5.put("project_year","2018-2019");
        a5.put("company_unit","中国通信建设第二工程局有限公司");
        a5.put("profession","传输线路");
        a5.put("project_name","2018年电信普遍服务工程12");
        a5.put("projectId","5");
        //----------------------------------------
        Map a6 = new HashMap();
        a6.put("area","西城区西城");
        a6.put("project_year","2018-2019");
        a6.put("company_unit","中国通信建设第二工程局有限公司");
        a6.put("profession","无线微站");
        a6.put("project_name","8888年电信普遍服务工程12");
        a6.put("projectId","6");
        //----------------------------------------
        Map a7 = new HashMap();
        a7.put("area","西城区西城");
        a7.put("project_year","2018-2020");
        a7.put("company_unit","南京嘉环科技有限公司");
        a7.put("profession","全业务");
        a7.put("project_name","1111年城域骨干传送网管道工程12");
        a7.put("projectId","7");
        //----------------------------------------
        Map a8 = new HashMap();
        a8.put("area","西城区西城");
        a8.put("project_year","2018-2020");
        a8.put("company_unit","南京嘉环科技有限公司");
        a8.put("profession","新建管道");
        a8.put("project_name","2018年城域骨干传送网管道工程12");
        a8.put("projectId","8");
        //----------------------------------------
        aa.add(a1);
        aa.add(a2);
        aa.add(a3);
        aa.add(a4);
        aa.add(a5);
        aa.add(a6);
        aa.add(a7);
        aa.add(a8);
        System.out.println();

    }
    static Map<Object,Map<Object,Map<Object,Map<Object,List<Map<String,String>>>>>> m = new HashMap();
}
