package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;

    private Integer schoolId;

    private Integer classId;

    private String studentAccount;

    private String patriachAccount;

    private String xsxm;

    private String xmpy;

    private String ywm;

    private String ysbj;

    private Integer xsxb;

    private Integer xssg;

    private Integer xstz;

    private String xjh;

    private String xh;

    private String qgxjh;

    private String jyid;

    private Long csrq;

    private String syd;

    private String yxzjlx;

    private String yxzjh;

    private String sfbjgb;

    private String sfjs;

    private String sfcj;

    private String sfsbt;

    private String sbtxh;

    private String xslb;

    private String gb;

    private String mz;

    private String jg;

    private String zzmm;

    private String jdfs;

    private String xzz;

    private String txdz;

    private String hkxz;

    private String hkszd;

    private String hkszdxxdz;

    private String sfabshkxsdd;

    private String sfbsxj;

    private String zslb;

    private String xszp;

    private String dyzh;

    private String jzzh;

    private String rxnd;

    private Integer status;

    private Integer delFlag;

    private String remarks;

    private Integer createBy;

    private Long createDate;

    private Integer updateBy;

    private Long updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount == null ? null : studentAccount.trim();
    }

    public String getPatriachAccount() {
        return patriachAccount;
    }

    public void setPatriachAccount(String patriachAccount) {
        this.patriachAccount = patriachAccount == null ? null : patriachAccount.trim();
    }

    public String getXsxm() {
        return xsxm;
    }

    public void setXsxm(String xsxm) {
        this.xsxm = xsxm == null ? null : xsxm.trim();
    }

    public String getXmpy() {
        return xmpy;
    }

    public void setXmpy(String xmpy) {
        this.xmpy = xmpy == null ? null : xmpy.trim();
    }

    public String getYwm() {
        return ywm;
    }

    public void setYwm(String ywm) {
        this.ywm = ywm == null ? null : ywm.trim();
    }

    public String getYsbj() {
        return ysbj;
    }

    public void setYsbj(String ysbj) {
        this.ysbj = ysbj == null ? null : ysbj.trim();
    }

    public Integer getXsxb() {
        return xsxb;
    }

    public void setXsxb(Integer xsxb) {
        this.xsxb = xsxb;
    }

    public Integer getXssg() {
        return xssg;
    }

    public void setXssg(Integer xssg) {
        this.xssg = xssg;
    }

    public Integer getXstz() {
        return xstz;
    }

    public void setXstz(Integer xstz) {
        this.xstz = xstz;
    }

    public String getXjh() {
        return xjh;
    }

    public void setXjh(String xjh) {
        this.xjh = xjh == null ? null : xjh.trim();
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getQgxjh() {
        return qgxjh;
    }

    public void setQgxjh(String qgxjh) {
        this.qgxjh = qgxjh == null ? null : qgxjh.trim();
    }

    public String getJyid() {
        return jyid;
    }

    public void setJyid(String jyid) {
        this.jyid = jyid == null ? null : jyid.trim();
    }

    public Long getCsrq() {
        return csrq;
    }

    public void setCsrq(Long csrq) {
        this.csrq = csrq;
    }

    public String getSyd() {
        return syd;
    }

    public void setSyd(String syd) {
        this.syd = syd == null ? null : syd.trim();
    }

    public String getYxzjlx() {
        return yxzjlx;
    }

    public void setYxzjlx(String yxzjlx) {
        this.yxzjlx = yxzjlx == null ? null : yxzjlx.trim();
    }

    public String getYxzjh() {
        return yxzjh;
    }

    public void setYxzjh(String yxzjh) {
        this.yxzjh = yxzjh == null ? null : yxzjh.trim();
    }

    public String getSfbjgb() {
        return sfbjgb;
    }

    public void setSfbjgb(String sfbjgb) {
        this.sfbjgb = sfbjgb == null ? null : sfbjgb.trim();
    }

    public String getSfjs() {
        return sfjs;
    }

    public void setSfjs(String sfjs) {
        this.sfjs = sfjs == null ? null : sfjs.trim();
    }

    public String getSfcj() {
        return sfcj;
    }

    public void setSfcj(String sfcj) {
        this.sfcj = sfcj == null ? null : sfcj.trim();
    }

    public String getSfsbt() {
        return sfsbt;
    }

    public void setSfsbt(String sfsbt) {
        this.sfsbt = sfsbt == null ? null : sfsbt.trim();
    }

    public String getSbtxh() {
        return sbtxh;
    }

    public void setSbtxh(String sbtxh) {
        this.sbtxh = sbtxh == null ? null : sbtxh.trim();
    }

    public String getXslb() {
        return xslb;
    }

    public void setXslb(String xslb) {
        this.xslb = xslb == null ? null : xslb.trim();
    }

    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb == null ? null : gb.trim();
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz == null ? null : mz.trim();
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg == null ? null : jg.trim();
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm == null ? null : zzmm.trim();
    }

    public String getJdfs() {
        return jdfs;
    }

    public void setJdfs(String jdfs) {
        this.jdfs = jdfs == null ? null : jdfs.trim();
    }

    public String getXzz() {
        return xzz;
    }

    public void setXzz(String xzz) {
        this.xzz = xzz == null ? null : xzz.trim();
    }

    public String getTxdz() {
        return txdz;
    }

    public void setTxdz(String txdz) {
        this.txdz = txdz == null ? null : txdz.trim();
    }

    public String getHkxz() {
        return hkxz;
    }

    public void setHkxz(String hkxz) {
        this.hkxz = hkxz == null ? null : hkxz.trim();
    }

    public String getHkszd() {
        return hkszd;
    }

    public void setHkszd(String hkszd) {
        this.hkszd = hkszd == null ? null : hkszd.trim();
    }

    public String getHkszdxxdz() {
        return hkszdxxdz;
    }

    public void setHkszdxxdz(String hkszdxxdz) {
        this.hkszdxxdz = hkszdxxdz == null ? null : hkszdxxdz.trim();
    }

    public String getSfabshkxsdd() {
        return sfabshkxsdd;
    }

    public void setSfabshkxsdd(String sfabshkxsdd) {
        this.sfabshkxsdd = sfabshkxsdd == null ? null : sfabshkxsdd.trim();
    }

    public String getSfbsxj() {
        return sfbsxj;
    }

    public void setSfbsxj(String sfbsxj) {
        this.sfbsxj = sfbsxj == null ? null : sfbsxj.trim();
    }

    public String getZslb() {
        return zslb;
    }

    public void setZslb(String zslb) {
        this.zslb = zslb == null ? null : zslb.trim();
    }

    public String getXszp() {
        return xszp;
    }

    public void setXszp(String xszp) {
        this.xszp = xszp == null ? null : xszp.trim();
    }

    public String getDyzh() {
        return dyzh;
    }

    public void setDyzh(String dyzh) {
        this.dyzh = dyzh == null ? null : dyzh.trim();
    }

    public String getJzzh() {
        return jzzh;
    }

    public void setJzzh(String jzzh) {
        this.jzzh = jzzh == null ? null : jzzh.trim();
    }

    public String getRxnd() {
        return rxnd;
    }

    public void setRxnd(String rxnd) {
        this.rxnd = rxnd == null ? null : rxnd.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
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
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getStudentAccount() == null ? other.getStudentAccount() == null : this.getStudentAccount().equals(other.getStudentAccount()))
            && (this.getPatriachAccount() == null ? other.getPatriachAccount() == null : this.getPatriachAccount().equals(other.getPatriachAccount()))
            && (this.getXsxm() == null ? other.getXsxm() == null : this.getXsxm().equals(other.getXsxm()))
            && (this.getXmpy() == null ? other.getXmpy() == null : this.getXmpy().equals(other.getXmpy()))
            && (this.getYwm() == null ? other.getYwm() == null : this.getYwm().equals(other.getYwm()))
            && (this.getYsbj() == null ? other.getYsbj() == null : this.getYsbj().equals(other.getYsbj()))
            && (this.getXsxb() == null ? other.getXsxb() == null : this.getXsxb().equals(other.getXsxb()))
            && (this.getXssg() == null ? other.getXssg() == null : this.getXssg().equals(other.getXssg()))
            && (this.getXstz() == null ? other.getXstz() == null : this.getXstz().equals(other.getXstz()))
            && (this.getXjh() == null ? other.getXjh() == null : this.getXjh().equals(other.getXjh()))
            && (this.getXh() == null ? other.getXh() == null : this.getXh().equals(other.getXh()))
            && (this.getQgxjh() == null ? other.getQgxjh() == null : this.getQgxjh().equals(other.getQgxjh()))
            && (this.getJyid() == null ? other.getJyid() == null : this.getJyid().equals(other.getJyid()))
            && (this.getCsrq() == null ? other.getCsrq() == null : this.getCsrq().equals(other.getCsrq()))
            && (this.getSyd() == null ? other.getSyd() == null : this.getSyd().equals(other.getSyd()))
            && (this.getYxzjlx() == null ? other.getYxzjlx() == null : this.getYxzjlx().equals(other.getYxzjlx()))
            && (this.getYxzjh() == null ? other.getYxzjh() == null : this.getYxzjh().equals(other.getYxzjh()))
            && (this.getSfbjgb() == null ? other.getSfbjgb() == null : this.getSfbjgb().equals(other.getSfbjgb()))
            && (this.getSfjs() == null ? other.getSfjs() == null : this.getSfjs().equals(other.getSfjs()))
            && (this.getSfcj() == null ? other.getSfcj() == null : this.getSfcj().equals(other.getSfcj()))
            && (this.getSfsbt() == null ? other.getSfsbt() == null : this.getSfsbt().equals(other.getSfsbt()))
            && (this.getSbtxh() == null ? other.getSbtxh() == null : this.getSbtxh().equals(other.getSbtxh()))
            && (this.getXslb() == null ? other.getXslb() == null : this.getXslb().equals(other.getXslb()))
            && (this.getGb() == null ? other.getGb() == null : this.getGb().equals(other.getGb()))
            && (this.getMz() == null ? other.getMz() == null : this.getMz().equals(other.getMz()))
            && (this.getJg() == null ? other.getJg() == null : this.getJg().equals(other.getJg()))
            && (this.getZzmm() == null ? other.getZzmm() == null : this.getZzmm().equals(other.getZzmm()))
            && (this.getJdfs() == null ? other.getJdfs() == null : this.getJdfs().equals(other.getJdfs()))
            && (this.getXzz() == null ? other.getXzz() == null : this.getXzz().equals(other.getXzz()))
            && (this.getTxdz() == null ? other.getTxdz() == null : this.getTxdz().equals(other.getTxdz()))
            && (this.getHkxz() == null ? other.getHkxz() == null : this.getHkxz().equals(other.getHkxz()))
            && (this.getHkszd() == null ? other.getHkszd() == null : this.getHkszd().equals(other.getHkszd()))
            && (this.getHkszdxxdz() == null ? other.getHkszdxxdz() == null : this.getHkszdxxdz().equals(other.getHkszdxxdz()))
            && (this.getSfabshkxsdd() == null ? other.getSfabshkxsdd() == null : this.getSfabshkxsdd().equals(other.getSfabshkxsdd()))
            && (this.getSfbsxj() == null ? other.getSfbsxj() == null : this.getSfbsxj().equals(other.getSfbsxj()))
            && (this.getZslb() == null ? other.getZslb() == null : this.getZslb().equals(other.getZslb()))
            && (this.getXszp() == null ? other.getXszp() == null : this.getXszp().equals(other.getXszp()))
            && (this.getDyzh() == null ? other.getDyzh() == null : this.getDyzh().equals(other.getDyzh()))
            && (this.getJzzh() == null ? other.getJzzh() == null : this.getJzzh().equals(other.getJzzh()))
            && (this.getRxnd() == null ? other.getRxnd() == null : this.getRxnd().equals(other.getRxnd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getStudentAccount() == null) ? 0 : getStudentAccount().hashCode());
        result = prime * result + ((getPatriachAccount() == null) ? 0 : getPatriachAccount().hashCode());
        result = prime * result + ((getXsxm() == null) ? 0 : getXsxm().hashCode());
        result = prime * result + ((getXmpy() == null) ? 0 : getXmpy().hashCode());
        result = prime * result + ((getYwm() == null) ? 0 : getYwm().hashCode());
        result = prime * result + ((getYsbj() == null) ? 0 : getYsbj().hashCode());
        result = prime * result + ((getXsxb() == null) ? 0 : getXsxb().hashCode());
        result = prime * result + ((getXssg() == null) ? 0 : getXssg().hashCode());
        result = prime * result + ((getXstz() == null) ? 0 : getXstz().hashCode());
        result = prime * result + ((getXjh() == null) ? 0 : getXjh().hashCode());
        result = prime * result + ((getXh() == null) ? 0 : getXh().hashCode());
        result = prime * result + ((getQgxjh() == null) ? 0 : getQgxjh().hashCode());
        result = prime * result + ((getJyid() == null) ? 0 : getJyid().hashCode());
        result = prime * result + ((getCsrq() == null) ? 0 : getCsrq().hashCode());
        result = prime * result + ((getSyd() == null) ? 0 : getSyd().hashCode());
        result = prime * result + ((getYxzjlx() == null) ? 0 : getYxzjlx().hashCode());
        result = prime * result + ((getYxzjh() == null) ? 0 : getYxzjh().hashCode());
        result = prime * result + ((getSfbjgb() == null) ? 0 : getSfbjgb().hashCode());
        result = prime * result + ((getSfjs() == null) ? 0 : getSfjs().hashCode());
        result = prime * result + ((getSfcj() == null) ? 0 : getSfcj().hashCode());
        result = prime * result + ((getSfsbt() == null) ? 0 : getSfsbt().hashCode());
        result = prime * result + ((getSbtxh() == null) ? 0 : getSbtxh().hashCode());
        result = prime * result + ((getXslb() == null) ? 0 : getXslb().hashCode());
        result = prime * result + ((getGb() == null) ? 0 : getGb().hashCode());
        result = prime * result + ((getMz() == null) ? 0 : getMz().hashCode());
        result = prime * result + ((getJg() == null) ? 0 : getJg().hashCode());
        result = prime * result + ((getZzmm() == null) ? 0 : getZzmm().hashCode());
        result = prime * result + ((getJdfs() == null) ? 0 : getJdfs().hashCode());
        result = prime * result + ((getXzz() == null) ? 0 : getXzz().hashCode());
        result = prime * result + ((getTxdz() == null) ? 0 : getTxdz().hashCode());
        result = prime * result + ((getHkxz() == null) ? 0 : getHkxz().hashCode());
        result = prime * result + ((getHkszd() == null) ? 0 : getHkszd().hashCode());
        result = prime * result + ((getHkszdxxdz() == null) ? 0 : getHkszdxxdz().hashCode());
        result = prime * result + ((getSfabshkxsdd() == null) ? 0 : getSfabshkxsdd().hashCode());
        result = prime * result + ((getSfbsxj() == null) ? 0 : getSfbsxj().hashCode());
        result = prime * result + ((getZslb() == null) ? 0 : getZslb().hashCode());
        result = prime * result + ((getXszp() == null) ? 0 : getXszp().hashCode());
        result = prime * result + ((getDyzh() == null) ? 0 : getDyzh().hashCode());
        result = prime * result + ((getJzzh() == null) ? 0 : getJzzh().hashCode());
        result = prime * result + ((getRxnd() == null) ? 0 : getRxnd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", classId=").append(classId);
        sb.append(", studentAccount=").append(studentAccount);
        sb.append(", patriachAccount=").append(patriachAccount);
        sb.append(", xsxm=").append(xsxm);
        sb.append(", xmpy=").append(xmpy);
        sb.append(", ywm=").append(ywm);
        sb.append(", ysbj=").append(ysbj);
        sb.append(", xsxb=").append(xsxb);
        sb.append(", xssg=").append(xssg);
        sb.append(", xstz=").append(xstz);
        sb.append(", xjh=").append(xjh);
        sb.append(", xh=").append(xh);
        sb.append(", qgxjh=").append(qgxjh);
        sb.append(", jyid=").append(jyid);
        sb.append(", csrq=").append(csrq);
        sb.append(", syd=").append(syd);
        sb.append(", yxzjlx=").append(yxzjlx);
        sb.append(", yxzjh=").append(yxzjh);
        sb.append(", sfbjgb=").append(sfbjgb);
        sb.append(", sfjs=").append(sfjs);
        sb.append(", sfcj=").append(sfcj);
        sb.append(", sfsbt=").append(sfsbt);
        sb.append(", sbtxh=").append(sbtxh);
        sb.append(", xslb=").append(xslb);
        sb.append(", gb=").append(gb);
        sb.append(", mz=").append(mz);
        sb.append(", jg=").append(jg);
        sb.append(", zzmm=").append(zzmm);
        sb.append(", jdfs=").append(jdfs);
        sb.append(", xzz=").append(xzz);
        sb.append(", txdz=").append(txdz);
        sb.append(", hkxz=").append(hkxz);
        sb.append(", hkszd=").append(hkszd);
        sb.append(", hkszdxxdz=").append(hkszdxxdz);
        sb.append(", sfabshkxsdd=").append(sfabshkxsdd);
        sb.append(", sfbsxj=").append(sfbsxj);
        sb.append(", zslb=").append(zslb);
        sb.append(", xszp=").append(xszp);
        sb.append(", dyzh=").append(dyzh);
        sb.append(", jzzh=").append(jzzh);
        sb.append(", rxnd=").append(rxnd);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remarks=").append(remarks);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}