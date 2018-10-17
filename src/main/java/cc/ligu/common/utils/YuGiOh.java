package cc.ligu.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;

public class YuGiOh
{
    public static final String SEPARATOR = System.getProperty ("file.separator");
    public static final String LINE = System.getProperty ("line.separator");
    /**
     * 转换之后保存的路径
     */
    private static final String SAVE = "convertSuffix";

    /**
     * 递归读取文件夹中的特定后缀的文件
     *
     * @param path
     *            String 读取的文件夹路径
     * @param suffix
     *            String 后缀名，|分隔
     * @param newSuffix
     *            String 新的后缀名
     */
    public static void convertSuffix ( String path, final String suffix, final String newSuffix )
    {
        File p = new File (path);
        String name = p.getName (), regex = "(?i)([^\\.]*)\\.(" + suffix + ")";
        if (p.isDirectory ())
        {
            p.list (new FilenameFilter ()
            {
                @Override
                public boolean accept ( File dir, String name )
                {
                    if (dir.isDirectory ())
                    {
                        convertSuffix (dir.getAbsolutePath () + SEPARATOR + name, suffix, newSuffix);
                    }
                    return false;
                }
            });
        }
        else if (name.matches (regex))
        {
            saveFiles (path, name, newSuffix);
        }
    }

    /**
     * 读取到特定的后缀，修改后缀，保存文件
     *
     * @param path
     *            String 读取的文件夹路径
     * @param name
     *            String 特定的后缀的文件名
     * @param newSuffix
     *            String 新的后缀名
     */
    public static void saveFiles ( String path, String name, String newSuffix )
    {
        try
        {
            File fp = new File (SAVE);
            if (!fp.exists ())
            {
                fp.mkdir ();
            }
            name = name.replaceAll ("([^\\.]+)(\\..*)?", "$1." + newSuffix);
            InputStream is = new FileInputStream (path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream ();
            byte[] buffer = new byte[1024];
            int len = -1;
            while (( len = is.read (buffer) ) != -1)
            {
                baos.write (buffer, 0, len);
            }
            baos.flush ();
            baos.close ();
            is.close ();
            byte[] data = baos.toByteArray ();
            FileOutputStream fos = new FileOutputStream (new File (SAVE + SEPARATOR + name));
            fos.write (data);
            fos.flush ();
            fos.close ();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }

    public static void main ( String[] args )
    {
        convertSuffix ("C:\\Users\\shenyy\\Desktop\\壁纸\\头像", "png|jpg|jpeg", "png");
    }
}