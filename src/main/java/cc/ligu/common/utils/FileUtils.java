package cc.ligu.common.utils;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

public class FileUtils {

	public static String readStreamAsString(InputStream ins) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
		StringBuilder builder = new StringBuilder();
		String line = reader.readLine();
		while(line!=null){
			builder.append(line+"\n");
			line = reader.readLine();	
		}
		reader.close();
		return builder.toString();
		
	}
	
	public static void writeLines(List<String> lines, String fileName) throws IOException{
		PrintWriter writer = new PrintWriter(new FileWriter(fileName));
		for(String line : lines){
			writer.print(line+"\r\n");
		}
		writer.close();
	}
	
	
	public static String getFileExtention(String fname){
		int idx = fname.lastIndexOf(".");
		if(idx>=0){
			return fname.substring(idx);
		}else{
			return "";
		}
	}
	
	public static boolean isExists(String filePath){
		if(StringUtils.isEmpty(filePath)){
			return false;
		}
		File file = new File(filePath);
		return file.exists();
	}
}
