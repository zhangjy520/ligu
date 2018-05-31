package cc.ligu.test.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 题库表
 * </p>
 *
 * @author zjy
 * @since 2018-05-31
 */
@TableName("doc_question")
public class DocQuestion extends Model<DocQuestion> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 题目类别：1单选题 2多选题 3其他
     */
    private Integer type;
    /**
     * 题目简称
     */
    private String name;
    /**
     * 题目内容
     */
    private String content;
    /**
     * 题目难度：1简单 2一般 3困难
     */
    private Integer level;
    /**
     * 分值
     */
    private Integer score;
    /**
     * 答案A
     */
    private String a;
    /**
     * 答案B
     */
    private String b;
    /**
     * 答案C
     */
    private String c;
    /**
     * 答案D
     */
    private String d;
    /**
     * 答案E
     */
    private String e;
    /**
     * 答案F
     */
    private String f;
    /**
     * 答案G
     */
    private String g;
    /**
     * 其他答案
     */
    private String o;
    /**
     * 正确答案(单选：A,多选：A,B,C)
     */
    @TableField("answer_correct")
    private String answerCorrect;
    /**
     * 答案解析
     */
    @TableField("answer_explain")
    private String answerExplain;
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
     * 逻辑删除标记[0正常,1已删除]
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public String getAnswerExplain() {
        return answerExplain;
    }

    public void setAnswerExplain(String answerExplain) {
        this.answerExplain = answerExplain;
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
        return "DocQuestion{" +
        ", id=" + id +
        ", type=" + type +
        ", name=" + name +
        ", content=" + content +
        ", level=" + level +
        ", score=" + score +
        ", a=" + a +
        ", b=" + b +
        ", c=" + c +
        ", d=" + d +
        ", e=" + e +
        ", f=" + f +
        ", g=" + g +
        ", o=" + o +
        ", answerCorrect=" + answerCorrect +
        ", answerExplain=" + answerExplain +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        ", delFlag=" + delFlag +
        "}";
    }
}
