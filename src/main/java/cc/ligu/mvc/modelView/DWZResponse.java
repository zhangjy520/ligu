package cc.ligu.mvc.modelView;

import java.io.Serializable;

public class DWZResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusCode;
	private String message;
	private String navTabId;
	private String rel;
	private String callbackType = "closeCurrent";
	private String forwardUrl;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	
	@Override
	public String toString() {
		return "DWZResponse [statusCode=" + statusCode + ", message=" + message + ", navTabId=" + navTabId + ", rel="
				+ rel + ", callbackType=" + callbackType + ", forwardUrl=" + forwardUrl + "]";
	}

}
