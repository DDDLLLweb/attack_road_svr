package com.el.udc;

import lombok.Value;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * UDC 说明注入器
 *
 * @author neo.pan
 * @since 16/11/8
 */
@Value(staticConstructor = "of")
class UdcNameInjector {
    /**
     * UDC 项目代码获取的方法
     */
    public Method codeGetter;
    /**
     * UDC 项目说明注入的方法
     */
    public Method nameSetter;
    /**
     * UDC 项目一览表
     */
    public Map<String, String> udcItems;
}
