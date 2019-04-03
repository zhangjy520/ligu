package cc.ligu.mvc.modelView;

import java.io.Serializable;

public class MessageView implements Serializable{


	public static final long serialVersionUID = 1L;
	public static final int SALARY_NOT_SEND =1;
	public static final int SALARY_OVER_TIME =4;
	public static final int INSU_NOT_SEND =2;
	public static final int INSU_OVER_TIME =3;
	public static final int EXAM_NOTICE =5;

	private String id;
	private String title;//消息标题
	private String time;//消息时间
	private String content;//消息内容
	private String person;//消息人
	private int type;//消息类型[1薪资未发放,2保险未交,3保险过期消息 4薪资过期消息 5考试消息]
	private String examId;//如果是考试消息，这个字段是考试的ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


}
