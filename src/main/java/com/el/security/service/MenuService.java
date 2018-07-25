package com.el.security.service;

import com.el.security.entity.Menu;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/7/10
 */
public interface MenuService {
    /**
     * 获取菜单
     *
     * @param userId 用戶ID
     * @return 菜单集合
     */
    List<Menu> menusOf(Integer userId);
}
