package com.el.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author danfeng
 * @since 2018/1/25.
 */
@Data
@EqualsAndHashCode(of = "id")
public class User implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private boolean deleteflag;
}
