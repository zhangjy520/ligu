package cc.ligu.common.tld;

import cc.ligu.common.utils.NumberConvertUtil;
import cc.ligu.mvc.persistence.entity.RoleMenu;

import java.util.List;

/**
 * Created by conn on 2016/8/8.
 */
public class RoleMenuUtil {

    public static Boolean roleMenuContains(String roleId, String menuId, List<RoleMenu> list) {
        if (null == list || list.size() == 0) return false;

        int _rid = NumberConvertUtil.convertS2I(roleId);
        int _mid = NumberConvertUtil.convertS2I(menuId);
        for (RoleMenu rm : list) {
            if (rm.getRoleId() == _rid && rm.getMenuId() == _mid) {
                return true;
            }
        }
        return false;
    }
}
