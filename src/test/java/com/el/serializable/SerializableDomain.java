package com.el.serializable;

import java.io.Serializable;

/**
 * @author Danfeng
 * @since 2018/10/31
 */
public class SerializableDomain implements Serializable {

    private Long id;

    public static String test;

    private transient String testTransient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTestTransient() {
        return testTransient;
    }

    public void setTestTransient(String testTransient) {
        this.testTransient = testTransient;
    }
}
