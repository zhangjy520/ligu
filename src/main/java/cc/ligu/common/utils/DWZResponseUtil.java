package cc.ligu.common.utils;

import cc.ligu.mvc.modelView.DWZResponse;

public final class DWZResponseUtil {

	private DWZResponseUtil() {}

	private static DWZResponse callback(String code, String message, String navTabId, String callbackType,String forwardUrl) {
		DWZResponse response = new DWZResponse();
		response.setStatusCode(code);
		response.setMessage(message);
		response.setNavTabId(navTabId);
		response.setCallbackType(callbackType);
		response.setForwardUrl(forwardUrl);
		return response;
	}
	
	public static DWZResponse callbackSuccess(String message,String navTabId) {
		return callback("200",message,navTabId,null,null);
	}
	
	public static DWZResponse callbackFail(String code,String message,String navTabId) {
		return callback(code,message,navTabId,null,null);
	}
}
