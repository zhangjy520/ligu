package cc.ligu.common.utils;

import cc.ligu.mvc.modelView.DWZResponse;

public final class DWZResponseUtil {

	private DWZResponseUtil() {}
	
	private static DWZResponse callback(String code, String message, String navTabId, String callbackType) {
		DWZResponse response = new DWZResponse();
		response.setStatusCode(code);
		response.setMessage(message);
		response.setNavTabId(navTabId);
		response.setCallbackType(callbackType);
		return response;
	}
	
	public static DWZResponse callbackSuccess(String message) {
		return callback("200",message,null,null);
	}
	
	public static DWZResponse callbackFail(String code,String message) {
		return callback(code,message,null,null);
	}
}
