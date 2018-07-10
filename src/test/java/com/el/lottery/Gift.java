package com.el.lottery;


import lombok.Data;

/**
 * @author Danfeng
 * @since 2018/7/3
 */
@Data
public class Gift {
    private int id;         //奖品Id
    private String name;    //奖品名称
    private double prob;    //获奖概率
}
