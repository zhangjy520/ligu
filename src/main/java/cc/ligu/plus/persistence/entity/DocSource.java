package cc.ligu.plus.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 媒体资源表
 * </p>
 *
 * @author 你的名字
 * @since 2018-05-31
 */
@TableName("doc_source")
public class DocSource extends Model<DocSource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文档名称
     */
    private String name;
    /**
     * 文档类别：1文档类 2视频类 3音频类 4图片类
     */
    private Integer type;
    /**
     * 文档地址(全路径,可直接访问)
     */
    private String url;
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
    @TableField("apply_time")
    private Integer applyTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建日期(时间戳格式)
     */
    @TableField("create_date")
    private Long createDate;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Integer createBy;
    /**
     * 修改日期(时间戳格式)
     */
    @TableField("update_date")
    private Long updateDate;
    /**
     * 修改人
     */
    @TableField("update_by")
    private Integer updateBy;
    /**
     * 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DocSource{" +
        ", id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", url=" + url +
        ", size=" + size +
        ", suffix=" + suffix +
        ", applyTime=" + applyTime +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        ", delFlag=" + delFlag +
        "}";
    }
}
