package com.el.lottery;


import lombok.Data;

/**
 * @author Danfeng
 * @since 2018/7/3
 */
public class Gift {
    private int id;         //奖品Id
    private String name;    //奖品名称
    private double prob;    //获奖概率

    public int getId() {
        System.out.println("gift---id="+id);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }
}
