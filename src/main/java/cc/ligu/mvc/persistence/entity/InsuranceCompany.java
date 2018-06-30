package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class InsuranceCompany implements Serializable {
    private Integer id;

    private String name;

    private String urlForQuery;

    private String urlIndex;

    private String phone;

    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public String getUrlForQuery() {
        return urlForQuery;
    }

    public void setUrlForQuery(String urlForQuery) {
        this.urlForQuery = urlForQuery == null ? null : urlForQuery.trim();
    }

    public String getUrlIndex() {
        return urlIndex;
    }

    public void setUrlIndex(String urlIndex) {
        this.urlIndex = urlIndex == null ? null : urlIndex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
        InsuranceCompany other = (InsuranceCompany) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrlForQuery() == null ? other.getUrlForQuery() == null : this.getUrlForQuery().equals(other.getUrlForQuery()))
            && (this.getUrlIndex() == null ? other.getUrlIndex() == null : this.getUrlIndex().equals(other.getUrlIndex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrlForQuery() == null) ? 0 : getUrlForQuery().hashCode());
        result = prime * result + ((getUrlIndex() == null) ? 0 : getUrlIndex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
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
        sb.append(", urlForQuery=").append(urlForQuery);
        sb.append(", urlIndex=").append(urlIndex);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}