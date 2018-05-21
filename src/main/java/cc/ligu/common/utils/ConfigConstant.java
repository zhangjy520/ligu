package cc.ligu.common.utils;

import com.sun.org.glassfish.gmbal.Description;

/**
 * �����ļ��еĳ���
 * @author Administrator
 */
public interface ConfigConstant {
	
	@Description("�ļ�����")
	String CONFIG_FILE = "smart.properties";
	
	@Description("JDBC-����")
	String JDBC_DRIVER = "smart.framework.jdbc.driver";
	
	@Description("JDBC-URL")
	String JDBC_URL = "smart.framework.jdbc.url";

	@Description("JDBC-USERNAME")
	String JDBC_USERNAME = "smart.framework.jdbc.username";

	@Description("JDBC-PASSWORD")
	String JDBC_PASSWORD = "smart.framework.jdbc.password";

	@Description("��Ŀ��������")
	String APP_BASE_PACKAGE = "smart.framework.app.base_package";

	@Description("JSPҳ��·��")
	String APP_JSP_PATH = "smart.framework.app.jsp_path";

	@Description("��̬�ļ�·��")
	String APP_ASSET_PATH = "smart.framework.app.asset_path";



}
