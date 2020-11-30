import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jyzhang29
 * @since 2020/11/25 13:54
 */
@Data
public class UserBean {
    public String faceUrl; //头像
    public String name; //名称
    public String schoolId; //学校id
    public String userId; //用户id

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserBean userBean = (UserBean)o;
        return Objects.equals(faceUrl, userBean.faceUrl) && Objects.equals(name, userBean.name) && Objects
            .equals(schoolId, userBean.schoolId) && Objects.equals(userId, userBean.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceUrl, name, schoolId, userId);
    }
}
