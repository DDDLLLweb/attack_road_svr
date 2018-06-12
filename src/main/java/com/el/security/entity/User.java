package com.el.security.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author danfeng
 * @since 2018/4/24
 */
@Data
@EqualsAndHashCode(of = "userId")
public class User implements Serializable {
    /**
     *  用户ID
     */
    private Long userId;
    /**
     *  用户名
     */
    private String username;
    /**
     * 加密密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nick;
    /**
     * 加密盐值
     */
    private String salt;
    /**
     * 记住我
     */
    private Boolean rememberMe;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 用户所有角色值，用于shiro做角色权限的判断
     */
    private Set<String> roles = new HashSet<>();
    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    private Set<String> perms = new HashSet<>();
}
