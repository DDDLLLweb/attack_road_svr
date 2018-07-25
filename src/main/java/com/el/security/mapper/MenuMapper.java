package com.el.security.mapper;

import com.el.domain.Sql;
import com.el.security.entity.Menu;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/7/23
 */
public interface MenuMapper {
    class SqlBuilder extends Sql {

        private static final String MENUS_OF_SQL = "menusOfSql";

        public String menusOfSql() {
            SELECT("distinct sm.menu_Id menuId, sm.upper_Id upperId, sm.menu_Uri menuUri, " +
                "sm.menu_Ico menuIco, sm.menu_Label menuLabel, sm.menu_Type menuType");
            FROM("S_MENU sm");
            INNER_JOIN("S_ROLE_MENU rm on rm.menu_id = sm.MENU_ID and rm.role_id = (select role_id from  S_ROLE_USER ru where ru.USER_ID = #{userId})");
            ORDER_BY("menuId");
            return toString();
        }

    }

    /**
     * 根据用户ID获取能访问的菜单一览
     *
     * @param userId 用户ID
     * @return 菜单一览
     */
    @SelectProvider(type = SqlBuilder.class, method = SqlBuilder.MENUS_OF_SQL)
    List<Menu> menusOf(Integer userId);

}
