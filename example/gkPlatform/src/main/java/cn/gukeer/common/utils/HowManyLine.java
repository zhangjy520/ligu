package cn.gukeer.common.utils;

import com.sun.org.apache.xerces.internal.dom.DeferredTextImpl;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;


/*
*   添加所有文件方法addFiles，是否是目录判断方法 isDirectory ,读取行数方法readLinePerFile
*
*
* */
public class HowManyLine {
    static List<File> list = new ArrayList<File>();
    int linenumber = 0;

    FileReader fr = null;
    BufferedReader br = null;

    /**
     * @param path，fileSuffixList path:需要统计的路径
     *                            fileSuffixList:需要统计的文件后缀List
     */
    public void counter(String path, List<String> fileSuffixList, String target) {
        long begin = System.currentTimeMillis();
        System.out.println("\n开始读取" + path + "下的文件,若文件较多，耗时可能较长，请您耐心等待。。。。\n");
        File file = new File(path);
        File files[] = null;
        files = file.listFiles();
        addFile(files);//将目录下所有文件加入到list中
        isDirectory(files);//所有文件列表进行遍历判断，若是文件夹，继续将该文件夹下的所有文件加入到list中，递归判断
        Map map = readLinePerFile(fileSuffixList, target);
        Set keys = map.keySet();
        for (Object key : keys) {
            System.out.println(key + "共：" + map.get(key) + "行");
        }
        long end = System.currentTimeMillis();
        System.out.println("\n读取完毕，共统计" + list.size() + "个文件，耗时" + (end - begin) + "毫秒");
    }

    // 判断是否是目录 ，递归判断
    public void isDirectory(File[] files) {
        for (File s : files) {
            if (s.isDirectory()) {
                File file[] = s.listFiles();
                addFile(file);
                isDirectory(file);
                continue;
            }
        }
    }

    //将文件列表添加到list中
    public void addFile(File file[]) {
        for (int index = 0; index < file.length; index++) {
            list.add(file[index]);
        }
    }

    //读取非空白行
    public Map readLinePerFile(List<String> fileSuffixList, String target) {
        Map map = new TreeMap();
        try {
            for (String suffix : fileSuffixList) {
                int suffixNum = 0;
                for (File s : list) {
                    int yuan = linenumber;
                    if (s.isDirectory()) {
                        continue;
                    }

                    if (!suffix.equals(".*")) {
                        if (s.getName().lastIndexOf(suffix) <= 0) {
                            continue;
                        }
                    }

                    fr = new FileReader(s);
                    br = new BufferedReader(fr);
                    String i = "";
                    int lineNum = 0;
                    while ((i = br.readLine()) != null) {
                        lineNum++;
                        if (!isBlankLine(i)) {
                            if (StringUtils.isNotEmpty(target))
                                if (i.contains(target))
                                    System.out.println(s.getName() + "的第" + lineNum + "行有你需要搜索的字符串");

                            linenumber++;
                            suffixNum++;

                        }
                    }
                    /*System.out.print(s.getName());
                    System.out.println("\t\t有" + (linenumber - yuan) + "行");*/
                }
                map.put(suffix, suffixNum);
            }
            map.put("total", linenumber);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                }
            }
        }
        return map;
    }

    //是否是空行,是空行返回true
    public boolean isBlankLine(String i) {
        if (i.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //全文索引
    public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException {

        System.out.println("A_Carra.xml".indexOf(".xml"));
        System.out.println("A_Carra.xml".indexOf("A_"));
        System.out.println("Carra.xml".indexOf("A_"));

        HowManyLine lineCounter = new HowManyLine();
        List<String> fileSuffixList = new ArrayList<String>();
//        fileSuffixList.add(".*");
        fileSuffixList.add(".class");
//        jad -o -r -s java -d res E:\git_hub_source\bin\org\mybatis\generator\ant\*.class
        lineCounter.counter("D:\\javaProjects\\smartRing\\src\\main\\java\\cc\\gukeer\\smartRing\\persistence\\mapping", fileSuffixList, "example.A");

        List<File> newList = new ArrayList<>();
        for (File file : list) {
            if (file.getName().indexOf(".xml") >= 0 && file.getName().indexOf("A_") >= 0) {

                newList.add(file);
                System.out.println(file.getName()+"方法如下："+nodeCounter(file));
                System.out.println();
                System.out.println();
            } else {

                continue;
            }
        }

        System.out.println();
    }

    public static List<String> nodeCounter(File filePath) throws ParserConfigurationException, IOException, SAXException {
        InputSource newFile = new InputSource(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

        DocumentBuilderFactory factory = DocumentBuilderFactory
                .newInstance();
        factory.setExpandEntityReferences(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document newDocument = builder.parse(newFile);

        Element newRootElement = newDocument.getDocumentElement();
        NodeList newMethods = newRootElement.getChildNodes();
        List<String> methods = new ArrayList<String>();
        for (int i = 0; i < newMethods.getLength(); i++) {
            Node node = newMethods.item(i);
            try {
                if (node instanceof DeferredTextImpl) {
                    continue;
                }
                Element ele = (Element) node;
                methods.add(ele.getAttribute("id"));
            } catch (Exception e) {
                //#text节点转换会异常
                continue;
            }
        }
        return methods;
    }
}