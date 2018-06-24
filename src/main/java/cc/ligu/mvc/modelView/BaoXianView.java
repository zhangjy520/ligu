package cc.ligu.mvc.modelView;

import java.io.Serializable;

public class BaoXianView implements Serializable{


	private static final long serialVersionUID = 1L;

	private String company;//保险信息
	private String order_num;//单号
	private String order_time;//保险期限

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	@Override
	public String toString() {
		return "BaoXianView{" +
				"company='" + company + '\'' +
				", order_num='" + order_num + '\'' +
				", order_time='" + order_time + '\'' +
				'}';
	}
}
