package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class Source implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 文档名称
     */
    private String name;

    /**
     * 0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例7H5图文资料
     */
    private Integer type;

    /**
     * 文档地址(全路径,可直接访问)
     */
    private String url;

    /**
     * 如果是文档内容,这里存储html代码
     */
    private String htmlContent;

    /**
     * 文档大小(kb)
     */
    private String size;

    /**
     * 文档后缀
     */
    private String suffix;

    /**
     * 文档请求次数(阅读量)
     */
    private Integer applyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期(时间戳格式)
     */
    private Long createDate;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 修改日期(时间戳格式)
     */
    private Long updateDate;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    private Integer delFlag;

    /**
     * doc_source
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取文档名称
     * @return name 文档名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文档名称
     * @param name 文档名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例7H5图文资料
     * @return type 0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例7H5图文资料
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例7H5图文资料
     * @param type 0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例7H5图文资料
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取文档地址(全路径,可直接访问)
     * @return url 文档地址(全路径,可直接访问)
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文档地址(全路径,可直接访问)
     * @param url 文档地址(全路径,可直接访问)
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取如果是文档内容,这里存储html代码
     * @return html_content 如果是文档内容,这里存储html代码
     */
    public String getHtmlContent() {
        return htmlContent;
    }

    /**
     * 设置如果是文档内容,这里存储html代码
     * @param htmlContent 如果是文档内容,这里存储html代码
     */
    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent == null ? null : htmlContent.trim();
    }

    /**
     * 获取文档大小(kb)
     * @return size 文档大小(kb)
     */
    public String getSize() {
        return size;
    }

    /**
     * 设置文档大小(kb)
     * @param size 文档大小(kb)
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * 获取文档后缀
     * @return suffix 文档后缀
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置文档后缀
     * @param suffix 文档后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    /**
     * 获取文档请求次数(阅读量)
     * @return apply_time 文档请求次数(阅读量)
     */
    public Integer getApplyTime() {
        return applyTime;
    }

    /**
     * 设置文档请求次数(阅读量)
     * @param applyTime 文档请求次数(阅读量)
     */
    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建日期(时间戳格式)
     * @return create_date 创建日期(时间戳格式)
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期(时间戳格式)
     * @param createDate 创建日期(时间戳格式)
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人
     * @return create_by 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取修改日期(时间戳格式)
     * @return update_date 修改日期(时间戳格式)
     */
    public Long getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改日期(时间戳格式)
     * @param updateDate 修改日期(时间戳格式)
     */
    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取修改人
     * @return update_by 修改人
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改人
     * @param updateBy 修改人
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取逻辑删除标记[0正常,1已删除,2黑名单]
     * @return del_flag 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除标记[0正常,1已删除,2黑名单]
     * @param delFlag 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
        Source other = (Source) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getHtmlContent() == null ? other.getHtmlContent() == null : this.getHtmlContent().equals(other.getHtmlContent()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getSuffix() == null ? other.getSuffix() == null : this.getSuffix().equals(other.getSuffix()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getHtmlContent() == null) ? 0 : getHtmlContent().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getSuffix() == null) ? 0 : getSuffix().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", url=").append(url);
        sb.append(", htmlContent=").append(htmlContent);
        sb.append(", size=").append(size);
        sb.append(", suffix=").append(suffix);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", remark=").append(remark);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}