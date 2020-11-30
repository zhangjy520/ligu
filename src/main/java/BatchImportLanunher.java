import com.google.gson.Gson;

import com.monitorjbl.xlsx.StreamingReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyzhang29
 * @since 2020/11/25 13:48
 */
public class BatchImportLanunher {
    private static final String APP_ID = "4";
    private static final String APP_SECRET = "ASEWECSADCSDAFq";
    private static final String FILE_PATH = "C:\\Users\\jyzhang29\\Desktop\\导入模板.xlsx";
    private static final String URL = "http://localhost:9999/v2/user/batchAddUser";
    private static final int BATCH_SIZE = 100;

    public static void main(String[] args) throws Exception {
        List<UserBean> res = readList();
        List<List> userBeanList = splitList(res, BATCH_SIZE);
        userBeanList.forEach(userBeans -> {
            RestRequest<List<UserBean>> requestParam = new RestRequest<>();
            requestParam.setCommonParam(genCommonParam(APP_ID, APP_SECRET));
            requestParam.setBody(userBeans);
            String result = HttpRequestUtil.sendPost(URL, new Gson().toJson(requestParam));
            System.out.println(result);
        });

    }

    /**
     * 读取本地文件
     */
    public static List<UserBean> readList() throws FileNotFoundException {
        FileInputStream in = new FileInputStream(FILE_PATH);
        Workbook wk = StreamingReader.builder().rowCacheSize(100)  //缓存到内存中的行数，默认是10
            .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
            .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件

        List<UserBean> userBeanList = new ArrayList<>();
        Sheet sheet = wk.getSheetAt(0);
        //遍历所有的行
        for (Row row : sheet) {
            if (row.getRowNum() == 0)
                continue;
            //遍历所有的列
            UserBean userBean = new UserBean();
            for (Cell cell : row) {
                if (cell.getColumnIndex() == 0) {
                    userBean.setUserId(specialStrDeal(cell.getStringCellValue()));
                } else if (cell.getColumnIndex() == 1) {
                    userBean.setName(specialStrDeal(cell.getStringCellValue()));
                } else if (cell.getColumnIndex() == 2) {
                    userBean.setFaceUrl(specialStrDeal(cell.getStringCellValue()));
                } else if (cell.getColumnIndex() == 3) {
                    userBean.setSchoolId(specialStrDeal(cell.getStringCellValue()));
                }
            }
            if (!userBeanList.contains(userBean)) {
                userBeanList.add(userBean);
            }
        }
        return userBeanList;
    }

    public static String specialStrDeal(String str) {
        if (null == str) {
            return str;
        }
        return str.trim();
    }

    /**
     * 切分list
     *
     * @param sourceList
     * @param groupSize  每组定长
     * @return
     */
    public static List<List> splitList(List sourceList, int groupSize) {
        int length = sourceList.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize;
        List<List> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i + 1) * groupSize < length ? (i + 1) * groupSize : length;
            newList.add(sourceList.subList(fromIndex, toIndex));
        }
        return newList;
    }

    private static CommonParam genCommonParam(String appId, String appSecret) {
        CommonParam param = new CommonParam();
        param.setAppId(appId);
        param.setTimestamp(System.currentTimeMillis());
        param.setNonce("121212121212121212");
        param.setSign(SHA1Util.sign(appSecret + param.getNonce() + param.getTimestamp()));
        return param;
    }
}


