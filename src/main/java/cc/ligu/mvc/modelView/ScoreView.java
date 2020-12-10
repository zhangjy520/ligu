package cc.ligu.mvc.modelView;

import java.io.Serializable;
import java.util.Objects;

public class ScoreView implements Serializable, Comparable<ScoreView> {


    private static final long serialVersionUID = 1L;

    private int personId;//人主键oa_person
    private String personName;//人名
    private String personIdentity;//人身份证
    private String score;//分数
    private int month;//月份
    private int order;//排名

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonIdentity() {
        return personIdentity;
    }

    public void setPersonIdentity(String personIdentity) {
        this.personIdentity = personIdentity;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ScoreView{" +
                "personId='" + personId + '\'' +
                ", personName='" + personName + '\'' +
                ", personIdentity='" + personIdentity + '\'' +
                ", score='" + score + '\'' +
                ", month='" + month + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreView scoreView = (ScoreView) o;
        return Objects.equals(personIdentity, scoreView.personIdentity) &&
                Objects.equals(month, scoreView.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personIdentity, month);
    }

    @Override
    public int compareTo(ScoreView o) {
        return new Double(o.getScore()).compareTo(new Double(this.score));
    }
}
