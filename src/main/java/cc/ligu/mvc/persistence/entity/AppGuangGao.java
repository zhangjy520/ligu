package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class AppGuangGao implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 广告类型[0图片 1文字]
     */
    private Integer type;

    /**
     * 如果是图片，是图片地址 否则是文字内容
     */
    private String content;

    /**
     * 广告标题
     */
    private String title;

    /**
     * app_guanggao
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取广告类型[0图片 1文字]
     * @return type 广告类型[0图片 1文字]
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置广告类型[0图片 1文字]
     * @param type 广告类型[0图片 1文字]
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取如果是图片，是图片地址 否则是文字内容
     * @return content 如果是图片，是图片地址 否则是文字内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置如果是图片，是图片地址 否则是文字内容
     * @param content 如果是图片，是图片地址 否则是文字内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取广告标题
     * @return title 广告标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置广告标题
     * @param title 广告标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppGuangGao other = (AppGuangGao) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}