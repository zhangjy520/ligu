package cc.ligu.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * 导出Excel文件（导出“XLSX”格式，支持大数据量导出   @see org.apache.poi.ss.SpreadsheetVersion）
 */
public class ExportExcel {
    public static void main(String[] args) {
        String aa = "[\n" +
                "{\n" +
                "\"parent\": \"596952\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47613\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"扩展属性1\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47613\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47613,\n" +
                "\"OID\": 597067,\n" +
                "\"DISPLAYFIELDVALUE\": \"扩展属性1—A\",\n" +
                "\"NAME\": \"扩展属性1\",\n" +
                "\"PARENTPATH\": \"596952\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 597067,\n" +
                "\"parentOri\": \"596952\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596952,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952\",\n" +
                "\"hasChildren\": true,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"NONE-86012\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 2,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47432,\n" +
                "\"OID\": 596949,\n" +
                "\"DISPLAYFIELDVALUE\": \"NONE-86012—A\",\n" +
                "\"NAME\": \"NONE-86012\",\n" +
                "\"PARENTPATH\": \"596952\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596949,\n" +
                "\"parentOri\": \"596952\",\n" +
                "\"LEAF\": false,\n" +
                "\"PARENTOID\": 596952,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47431\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"HYA35-B0109_A\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47431\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 2,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47431,\n" +
                "\"OID\": 597063,\n" +
                "\"DISPLAYFIELDVALUE\": \"HYA35-B0109_A—A\",\n" +
                "\"NAME\": \"HYA35-B0109_A\",\n" +
                "\"PARENTPATH\": \"596952_47432\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 597063,\n" +
                "\"parentOri\": \"596949\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596949,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432\",\n" +
                "\"hasChildren\": true,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47437\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"3-574666\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47437\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47437,\n" +
                "\"OID\": 596973,\n" +
                "\"DISPLAYFIELDVALUE\": \"3-574666—A\",\n" +
                "\"NAME\": \"3-574666\",\n" +
                "\"PARENTPATH\": \"596952_47432\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596973,\n" +
                "\"parentOri\": \"596949\",\n" +
                "\"LEAF\": false,\n" +
                "\"PARENTOID\": 596949,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432\",\n" +
                "\"hasChildren\": true,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47430\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"1-572177\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47430\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47430,\n" +
                "\"OID\": 596971,\n" +
                "\"DISPLAYFIELDVALUE\": \"1-572177—A\",\n" +
                "\"NAME\": \"1-572177\",\n" +
                "\"PARENTPATH\": \"596952_47432\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596971,\n" +
                "\"parentOri\": \"596949\",\n" +
                "\"LEAF\": false,\n" +
                "\"PARENTOID\": 596949,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47437\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47437_47456\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"444\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47437_47456\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47456,\n" +
                "\"OID\": 596410,\n" +
                "\"DISPLAYFIELDVALUE\": \"444—A\",\n" +
                "\"NAME\": \"444\",\n" +
                "\"PARENTPATH\": \"596952_47432_47437\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596410,\n" +
                "\"parentOri\": \"596973\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596973,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47437\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47437_47457\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"NONE-84135\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47437_47457\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 2,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47457,\n" +
                "\"OID\": 596582,\n" +
                "\"DISPLAYFIELDVALUE\": \"NONE-84135—A\",\n" +
                "\"NAME\": \"NONE-84135\",\n" +
                "\"PARENTPATH\": \"596952_47432_47437\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596582,\n" +
                "\"parentOri\": \"596973\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596973,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47437\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47437_47460\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"ccc\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47437_47460\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 2,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47460,\n" +
                "\"OID\": 596969,\n" +
                "\"DISPLAYFIELDVALUE\": \"ccc—A\",\n" +
                "\"NAME\": \"ccc\",\n" +
                "\"PARENTPATH\": \"596952_47432_47437\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596969,\n" +
                "\"parentOri\": \"596973\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596973,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47437\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47437_47459\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"bbb\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47437_47459\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47459,\n" +
                "\"OID\": 596495,\n" +
                "\"DISPLAYFIELDVALUE\": \"bbb—A\",\n" +
                "\"NAME\": \"bbb\",\n" +
                "\"PARENTPATH\": \"596952_47432_47437\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596495,\n" +
                "\"parentOri\": \"596973\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596973,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47437\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47437_47458\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"aaaa\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47437_47458\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47458,\n" +
                "\"OID\": 596494,\n" +
                "\"DISPLAYFIELDVALUE\": \"aaaa—A\",\n" +
                "\"NAME\": \"aaaa\",\n" +
                "\"PARENTPATH\": \"596952_47432_47437\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 596494,\n" +
                "\"parentOri\": \"596973\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596973,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47430\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47430_47450\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"2-573780\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47430_47450\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 0,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47450,\n" +
                "\"OID\": 34615,\n" +
                "\"DISPLAYFIELDVALUE\": \"2-573780—A\",\n" +
                "\"NAME\": \"2-573780\",\n" +
                "\"PARENTPATH\": \"596952_47432_47430\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 34615,\n" +
                "\"parentOri\": \"596971\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596971,\n" +
                "\"VIRTUAL\": false\n" +
                "},\n" +
                "{\n" +
                "\"parent\": \"596952_47432_47430\",\n" +
                "\"hasChildren\": false,\n" +
                "\"VIEWNAME\": \"设计\",\n" +
                "\"OTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"SELFPATH\": \"596952_47432_47430_47449\",\n" +
                "\"ISCHECKED\": false,\n" +
                "\"AMOUNT\": 1,\n" +
                "\"DESCRIPTION\": null,\n" +
                "\"PARTNUMBER\": \"HYA35-B0110_A\",\n" +
                "\"LINEVALUE\": 0,\n" +
                "\"REFERENCE\": \"Default\",\n" +
                "\"id\": \"596952_47432_47430_47449\",\n" +
                "\"ICON\": \"image/零部件.png\",\n" +
                "\"CSS\": 2,\n" +
                "\"LIFECYCLENAME\": \"开启的\",\n" +
                "\"BOTYPE\": \"ty.zddw.part.CTyPart\",\n" +
                "\"LINKOID\": 47449,\n" +
                "\"OID\": 595857,\n" +
                "\"DISPLAYFIELDVALUE\": \"HYA35-B0110_A—A\",\n" +
                "\"NAME\": \"HYA35-B0110_A\",\n" +
                "\"PARENTPATH\": \"596952_47432_47430\",\n" +
                "\"hasExpanded\": false,\n" +
                "\"BOID\": 595857,\n" +
                "\"parentOri\": \"596971\",\n" +
                "\"LEAF\": true,\n" +
                "\"PARENTOID\": 596971,\n" +
                "\"VIRTUAL\": false\n" +
                "}\n" +
                "]";
        JSONArray array = JSONArray.parseArray(aa);
        exportExcel("aa",array,"dd");
    }
    public static void exportExcel(String name, JSONArray ja, String tbName){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(name);
        XSSFRow row = sheet.createRow(0);
        int index = 0;
        if(tbName.equals("")){
            tbName = "excel";
        }
        File file = new File("C:\\"+tbName);
        if(!file.exists()){
            file.mkdir();
        }
        JSONObject first = ja.getJSONObject(0);
        Iterator<String> iterator = first.keySet().iterator(); // 得到第一项的key集合
        while (iterator.hasNext()) { // 遍历key集合
            String key = (String) iterator.next(); // 得到key
            String value = first.getString(key);
            XSSFCell cell = row.createCell(index);
            cell.setCellValue(key);
            index++;
        }
        for (int i = 0; i < ja.size(); i++) {
            row = sheet.createRow(i+1);
            JSONObject jaa = ja.getJSONObject(i);
            Iterator<String> iterator1 = jaa.keySet().iterator();
            int index1 = 0;
            while (iterator1.hasNext()) { // 遍历key集合
                String key1 = (String) iterator1.next(); // 得到key
                String value = jaa.getString(key1);
                System.out.println(value);
                XSSFCell cell = row.createCell(index1);
                cell.setCellValue(value);
                index1++;
            }
        }
        try {
            String tmpPath = "C:\\"+tbName+"\\" + name + ".xlsx";
            OutputStream outputStream = new FileOutputStream(tmpPath);
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
