package com.el.udc;

import java.lang.annotation.*;

/**
 * 用来标识 Domain 中需要注入UDC说明文字的属性，并结合 UdcService 完成注入。
 *
 * @author neo.pan
 * @since 17/5/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface UdcName {

    /**
     * @return UDC名
     */
    String udcName();

    /**
     * @return 存放UDC编码的属性名
     */
    String codePropName();

}
