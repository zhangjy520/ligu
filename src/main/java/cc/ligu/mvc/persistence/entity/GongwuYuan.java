package cc.ligu.mvc.persistence.entity;

import cc.ligu.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

public class GongwuYuan implements Serializable {
    private String diqu;
    private String diqupinyin;
    private String bumendaima;
    private String zhaolujiguan;
    private String yongRenSiJu;
    private String jigouxingzhi;
    private String zhaokaozhiwei;
    private String zhiweixingzhi;
    private String zhiweifenbu;
    private String zhiweijianjie;
    private String zhiweidaima;
    private String jigoucengji;
    private String kaoshileibie;
    private String zhaokaorenshu;
    private String zhuanye;
    private String xueli;
    private String xuewei;
    private String zhengzhimianmao;
    private String jicenggongzuozuidi;
    private String fuwujicengzuidi;
    private String shifoumianshi;
    private String mianshibili;
    private String gongzuodidian;
    private String luohudidian;
    private String beizhu;
    private String bumenwangzhan;
    private String zixundianhua;

    @ExcelField(title = "地区", align = 2, sort = 1, groups = {1, 2})
    public String getDiqu() {
        return diqu;
    }

    public GongwuYuan setDiqu(String diqu) {
        this.diqu = diqu;
        return this;
    }
    @ExcelField(title = "地区拼音", align = 2, sort = 2, groups = {1, 2})
    public String getDiqupinyin() {
        return diqupinyin;
    }

    public GongwuYuan setDiqupinyin(String diqupinyin) {
        this.diqupinyin = diqupinyin;
        return this;
    }
    @ExcelField(title = "部门代码", align = 2, sort = 3, groups = {1, 2})
    public String getBumendaima() {
        return bumendaima;
    }

    public GongwuYuan setBumendaima(String bumendaima) {
        this.bumendaima = bumendaima;
        return this;
    }
    @ExcelField(title = "招录机关", align = 2, sort = 4, groups = {1, 2})
    public String getZhaolujiguan() {
        return zhaolujiguan;
    }

    public GongwuYuan setZhaolujiguan(String zhaolujiguan) {
        this.zhaolujiguan = zhaolujiguan;
        return this;
    }

    @ExcelField(title = "用人司局", align = 2, sort = 5, groups = {1, 2})
    public String getYongRenSiJu() {
        return yongRenSiJu;
    }

    public GongwuYuan setYongRenSiJu(String yongRenSiJu) {
        this.yongRenSiJu = yongRenSiJu;
        return this;
    }

    @ExcelField(title = "机构性质", align = 2, sort = 6, groups = {1, 2})
    public String getJigouxingzhi() {
        return jigouxingzhi;
    }

    public GongwuYuan setJigouxingzhi(String jigouxingzhi) {
        this.jigouxingzhi = jigouxingzhi;
        return this;
    }

    @ExcelField(title = "招考职位", align = 2, sort = 7, groups = {1, 2})
    public String getZhaokaozhiwei() {
        return zhaokaozhiwei;
    }

    public GongwuYuan setZhaokaozhiwei(String zhaokaozhiwei) {
        this.zhaokaozhiwei = zhaokaozhiwei;
        return this;
    }

    @ExcelField(title = "职位属性", align = 2, sort = 8, groups = {1, 2})
    public String getZhiweixingzhi() {
        return zhiweixingzhi;
    }

    public GongwuYuan setZhiweixingzhi(String zhiweixingzhi) {
        this.zhiweixingzhi = zhiweixingzhi;
        return this;
    }

    @ExcelField(title = "职位分布", align = 2, sort = 9, groups = {1, 2})
    public String getZhiweifenbu() {
        return zhiweifenbu;
    }

    public GongwuYuan setZhiweifenbu(String zhiweifenbu) {
        this.zhiweifenbu = zhiweifenbu;
        return this;
    }

    @ExcelField(title = "职位简介", align = 2, sort = 10, groups = {1, 2})
    public String getZhiweijianjie() {
        return zhiweijianjie;
    }

    public GongwuYuan setZhiweijianjie(String zhiweijianjie) {
        this.zhiweijianjie = zhiweijianjie;
        return this;
    }
    @ExcelField(title = "职位代码", align = 2, sort = 11, groups = {1, 2})
    public String getZhiweidaima() {
        return zhiweidaima;
    }

    public GongwuYuan setZhiweidaima(String zhiweidaima) {
        this.zhiweidaima = zhiweidaima;
        return this;
    }
    @ExcelField(title = "机构层级", align = 2, sort = 12, groups = {1, 2})
    public String getJigoucengji() {
        return jigoucengji;
    }

    public GongwuYuan setJigoucengji(String jigoucengji) {
        this.jigoucengji = jigoucengji;
        return this;
    }
    @ExcelField(title = "考试类别", align = 2, sort = 13, groups = {1, 2})
    public String getKaoshileibie() {
        return kaoshileibie;
    }

    public GongwuYuan setKaoshileibie(String kaoshileibie) {
        this.kaoshileibie = kaoshileibie;
        return this;
    }
    @ExcelField(title = "招考人数", align = 2, sort = 14, groups = {1, 2})
    public String getZhaokaorenshu() {
        return zhaokaorenshu;
    }

    public GongwuYuan setZhaokaorenshu(String zhaokaorenshu) {
        this.zhaokaorenshu = zhaokaorenshu;
        return this;
    }
    @ExcelField(title = "专业", align = 2, sort = 15, groups = {1, 2})
    public String getZhuanye() {
        return zhuanye;
    }

    public GongwuYuan setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
        return this;
    }
    @ExcelField(title = "学历", align = 2, sort = 16, groups = {1, 2})
    public String getXueli() {
        return xueli;
    }

    public GongwuYuan setXueli(String xueli) {
        this.xueli = xueli;
        return this;
    }
    @ExcelField(title = "学位", align = 2, sort = 17, groups = {1, 2})
    public String getXuewei() {
        return xuewei;
    }

    public GongwuYuan setXuewei(String xuewei) {
        this.xuewei = xuewei;
        return this;
    }
    @ExcelField(title = "政治面貌", align = 2, sort = 18, groups = {1, 2})
    public String getZhengzhimianmao() {
        return zhengzhimianmao;
    }

    public GongwuYuan setZhengzhimianmao(String zhengzhimianmao) {
        this.zhengzhimianmao = zhengzhimianmao;
        return this;
    }
    @ExcelField(title = "基层工作最低年限", align = 2, sort = 19, groups = {1, 2})
    public String getJicenggongzuozuidi() {
        return jicenggongzuozuidi;
    }

    public GongwuYuan setJicenggongzuozuidi(String jicenggongzuozuidi) {
        this.jicenggongzuozuidi = jicenggongzuozuidi;
        return this;
    }
    @ExcelField(title = "服务基层项目工作经历", align = 2, sort = 20, groups = {1, 2})
    public String getFuwujicengzuidi() {
        return fuwujicengzuidi;
    }

    public GongwuYuan setFuwujicengzuidi(String fuwujicengzuidi) {
        this.fuwujicengzuidi = fuwujicengzuidi;
        return this;
    }
    @ExcelField(title = "是否在面试阶段组织专业能力测试", align = 2, sort = 21, groups = {1, 2})
    public String getShifoumianshi() {
        return shifoumianshi;
    }

    public GongwuYuan setShifoumianshi(String shifoumianshi) {
        this.shifoumianshi = shifoumianshi;
        return this;
    }
    @ExcelField(title = "面试人员比例", align = 2, sort = 22, groups = {1, 2})
    public String getMianshibili() {
        return mianshibili;
    }

    public GongwuYuan setMianshibili(String mianshibili) {
        this.mianshibili = mianshibili;
        return this;
    }
    @ExcelField(title = "工作地点", align = 2, sort = 23, groups = {1, 2})
    public String getGongzuodidian() {
        return gongzuodidian;
    }

    public GongwuYuan setGongzuodidian(String gongzuodidian) {
        this.gongzuodidian = gongzuodidian;
        return this;
    }
    @ExcelField(title = "落户地点", align = 2, sort = 24, groups = {1, 2})
    public String getLuohudidian() {
        return luohudidian;
    }

    public GongwuYuan setLuohudidian(String luohudidian) {
        this.luohudidian = luohudidian;
        return this;
    }
    @ExcelField(title = "备注", align = 2, sort = 25, groups = {1, 2})
    public String getBeizhu() {
        return beizhu;
    }

    public GongwuYuan setBeizhu(String beizhu) {
        this.beizhu = beizhu;
        return this;
    }
    @ExcelField(title = "部门网站", align = 2, sort = 26, groups = {1, 2})
    public String getBumenwangzhan() {
        return bumenwangzhan;
    }

    public GongwuYuan setBumenwangzhan(String bumenwangzhan) {
        this.bumenwangzhan = bumenwangzhan;
        return this;
    }
    @ExcelField(title = "咨询电话", align = 2, sort = 27, groups = {1, 2})
    public String getZixundianhua() {
        return zixundianhua;
    }

    public GongwuYuan setZixundianhua(String zixundianhua) {
        this.zixundianhua = zixundianhua;
        return this;
    }

    @Override
    public String toString() {
        return "GongwuYuan{" +
                "" + diqu + '\'' +
                ",='" + diqupinyin + '\'' +
                ",='" + bumendaima + '\'' +
                ",='" + zhaolujiguan + '\'' +
                ",='" + yongRenSiJu + '\'' +
                ",='" + jigouxingzhi + '\'' +
                ",='" + zhaokaozhiwei + '\'' +
                ",='" + zhiweixingzhi + '\'' +
                ",='" + zhiweifenbu + '\'' +
                ", ='" + zhiweijianjie + '\'' +
                ", ='" + zhiweidaima + '\'' +
                ", ='" + jigoucengji + '\'' +
                ", ='" + kaoshileibie + '\'' +
                ", ='" + zhaokaorenshu + '\'' +
                ", ='" + zhuanye + '\'' +
                ", ='" + xueli + '\'' +
                ", ='" + xuewei + '\'' +
                ", ='" + zhengzhimianmao + '\'' +
                ", ='" + jicenggongzuozuidi + '\'' +
                ", ='" + fuwujicengzuidi + '\'' +
                ", ='" + shifoumianshi + '\'' +
                ", ='" + mianshibili + '\'' +
                ", ='" + gongzuodidian + '\'' +
                ", ='" + luohudidian + '\'' +
                ", ='" + beizhu + '\'' +
                ", ='" + bumenwangzhan + '\'' +
                ", ='" + zixundianhua + '\'' +
                '}';
    }
}