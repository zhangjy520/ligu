package cc.ligu.common.utils.util;

import cc.ligu.common.utils.helper.ConfigHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ���������ļ�
 * @author Administrator
 *
 */
public class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);  
 
    /**
     * ���������ļ� 
     */
    public static Properties loadProps(String fileName) {  
        Properties properties = null;  
        InputStream inputStream = null;  
        try {  
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);  
            if (inputStream == null) {  
                throw new FileNotFoundException(fileName + " file is not found!");  
            }  
            properties = new Properties();  
            properties.load(inputStream);  
        } catch (IOException e) {  
            LOGGER.error("load properties file failure", e);  
        } finally {  
            if (inputStream != null) {  
                try {  
                    inputStream.close();  
                } catch (IOException e) {  
                    LOGGER.error("close input stream failure", e);  
                }  
            }  
        }  
        return properties;  
    }  

    /**
     * ��ȡ�ַ������ԣ�Ĭ��Ϊ���ַ�����
     */
    public static String getString(Properties props, String key) {  
        return getString(props, key, "");  
    }  

    /**
     * ��ȡ�ַ������ԣ���ָ��Ĭ��ֵ�� 
     */
    public static String getString(Properties props, String key, String  
            defaultValue) {  
        String value = defaultValue;  
        if (props.containsKey(key)) {  
            value = props.getProperty(key);  
        }  
        return value;  
    }  

    /**
     * ��ȡ��ֵ�������ԣ�Ĭ��Ϊ0�� 
     */
    public static int getInt(Properties props, String key) {  
        return getInt(props, key, 0);  
    }  
    
    /**
     * ��ȡ��ֵ�������ԣ���ָ��Ĭ��ֵ��
     */
    public static int getInt(Properties props, String key, int defaultValue) {  
        int value = defaultValue;  
        if (props.containsKey(key)) {  
            value = CastUtil.castInt(props.getProperty(key));  
        }  
        return value;  
    }  

    /**
     * ��ȡ���������ԣ�Ĭ��ֵΪfalse�� 
     */
    public static boolean getBoolean(Properties props, String key) {  
        return getBoolean(props, key, false);  
    }  

    /**
     * ��ȡ���������ԣ���ָ��Ĭ��ֵ�� 
     */
    public static boolean getBoolean(Properties props, String key, Boolean defaultValue) {  
        boolean value = defaultValue;  
        if (props.containsKey(key)) {  
            value = CastUtil.castBoolean(props.getProperty(key));  
        }  
        return value;  
    }

    public static void main(String[] args) {
       String aa = ConfigHelper.getValueByKey("file.path");
        System.out.println(aa);
    }
}