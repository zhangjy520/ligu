package cc.ligu.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.PictureData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class ReadPicturesFromExcel {

    public static void main(String[] args) throws InvalidFormatException,
            Exception {

        InputStream inp = new FileInputStream(
                "C:\\Users\\shenyy\\Desktop\\壁纸\\444\\111.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(inp);

        List<HSSFPictureData> pictures = workbook.getAllPictures();
        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);

        int i = 0;
        for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
            HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();

            if (shape instanceof HSSFPicture) {
                HSSFPicture pic = (HSSFPicture) shape;
                int row = anchor.getRow1();
                System.out.println(i + "--->" + anchor.getRow1() + ":"
                        + anchor.getCol1());
                int pictureIndex = pic.getPictureIndex() - 1;
                HSSFPictureData picData = pictures.get(pictureIndex);

                System.out.println(i + "--->" + pictureIndex);
                savePic(sheet, row, picData);
            }
            i++;
        }
    }

    private static void savePic(HSSFSheet sheet, int i, PictureData pic) throws Exception {

        HSSFRow s = sheet.getRow(i);
        HSSFCell d = s.getCell(0);
        String name = d.getStringCellValue();

        String ext = pic.suggestFileExtension();

        byte[] data = pic.getData();

        FileOutputStream out = new FileOutputStream(
                "C:\\Users\\shenyy\\Desktop\\壁纸\\头像\\" + name + ".jpg");
        out.write(data);
        out.close();
    }

}