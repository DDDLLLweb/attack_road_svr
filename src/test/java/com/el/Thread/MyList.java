package com.el.Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源类
 * @author Danfeng
 * @since 2018/5/24
 */
public class MyList {
    //临界资源
    private volatile List<String> list = new ArrayList<String>();

    public void add() {
        list.add("abc");
    }

    public int size() {
        return list.size();
    }
}
