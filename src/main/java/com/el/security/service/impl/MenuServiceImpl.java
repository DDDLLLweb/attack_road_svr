package com.el.security.service.impl;

import com.el.security.entity.Menu;
import com.el.security.mapper.MenuMapper;
import com.el.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/7/23
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> menusOf(Integer userId) {
        return menuMapper.menusOf(userId);
    }

}
