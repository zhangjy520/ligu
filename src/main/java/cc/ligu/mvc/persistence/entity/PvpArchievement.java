package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class PvpArchievement implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 成就数字对应[比如1=青铜1,2=青铜2]
     */
    private Integer level;

    /**
     * 成就名称[青铜1，青铜2]
     */
    private String name;

    /**
     * 成就最低分
     */
    private Integer minScore;

    /**
     * 成就最高分
     */
    private Integer maxScore;

    /**
     * pvp_archievement
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
     * 获取成就数字对应[比如1=青铜1,2=青铜2]
     * @return level 成就数字对应[比如1=青铜1,2=青铜2]
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置成就数字对应[比如1=青铜1,2=青铜2]
     * @param level 成就数字对应[比如1=青铜1,2=青铜2]
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取成就名称[青铜1，青铜2]
     * @return name 成就名称[青铜1，青铜2]
     */
    public String getName() {
        return name;
    }

    /**
     * 设置成就名称[青铜1，青铜2]
     * @param name 成就名称[青铜1，青铜2]
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取成就最低分
     * @return min_score 成就最低分
     */
    public Integer getMinScore() {
        return minScore;
    }

    /**
     * 设置成就最低分
     * @param minScore 成就最低分
     */
    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    /**
     * 获取成就最高分
     * @return max_score 成就最高分
     */
    public Integer getMaxScore() {
        return maxScore;
    }

    /**
     * 设置成就最高分
     * @param maxScore 成就最高分
     */
    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
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
        PvpArchievement other = (PvpArchievement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMinScore() == null ? other.getMinScore() == null : this.getMinScore().equals(other.getMinScore()))
            && (this.getMaxScore() == null ? other.getMaxScore() == null : this.getMaxScore().equals(other.getMaxScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMinScore() == null) ? 0 : getMinScore().hashCode());
        result = prime * result + ((getMaxScore() == null) ? 0 : getMaxScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", level=").append(level);
        sb.append(", name=").append(name);
        sb.append(", minScore=").append(minScore);
        sb.append(", maxScore=").append(maxScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}