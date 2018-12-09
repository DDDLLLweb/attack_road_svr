package com.el.designPatterns.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author Danfeng
 * @since 2018/12/1
 */
public class EnumerationIterator implements Iterator<Object> {

    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }


    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }


}
