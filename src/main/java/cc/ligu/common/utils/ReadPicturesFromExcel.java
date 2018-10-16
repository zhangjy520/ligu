package cc.gukeer.common;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class ReadPicturesFromExcel {

    public static void main(String[] args) throws InvalidFormatException,
            Exception {

        InputStream inp = new FileInputStream(
                "C:\\Users\\shenyy\\Desktop\\壁纸\\Fw_ 合作单位施工人员档案（武汉贝斯特）18.10.11\\合作单位施工人员档案（中通一局）18.10.9.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inp);

        List<XSSFPictureData> pictures = workbook.getAllPictures();
        XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

        int i = 0;
        for (XSSFShape shape : sheet.getDrawingPatriarch().getShapes()) {
            XSSFClientAnchor anchor = (XSSFClientAnchor) shape.getAnchor();

            if (shape instanceof XSSFPicture) {
                XSSFPicture pic = (XSSFPicture) shape;
                int row = anchor.getRow1();
                System.out.println(i + "--->" + anchor.getRow1() + ":"
                        + anchor.getCol1());
                int pictureIndex = i;//pic.getPictureIndex() - 1;
                XSSFPictureData picData = pictures.get(pictureIndex);

                System.out.println(i + "--->" + pictureIndex);
                savePic(sheet, row, picData);
            }
            i++;
        }
    }

    private static void savePic(XSSFSheet sheet, int i, PictureData pic) throws Exception {

        XSSFRow s = sheet.getRow(i);
        XSSFCell d = s.getCell(5);
        String name = d.getStringCellValue();

        String ext = pic.suggestFileExtension();

        byte[] data = pic.getData();
        if (ext.equals("jpeg")) {
            FileOutputStream out = new FileOutputStream(
                    "C:\\Users\\shenyy\\Desktop\\壁纸\\头像\\" + name + ".jpg");
            out.write(data);
            out.close();
        }
        if (ext.equals("dib")) {
            FileOutputStream out = new FileOutputStream(
                    "C:\\Users\\shenyy\\Desktop\\壁纸\\头像\\" + name + ".bmp");
            out.write(data);
            out.close();
        }
        if (ext.equals("png")) {
            FileOutputStream out = new FileOutputStream(
                    "C:\\Users\\shenyy\\Desktop\\壁纸\\头像\\" + name + ".png");
            out.write(data);
            out.close();
        }
    }

}