package com.el.udc;

import java.util.regex.Pattern;

/**
 * @author neo.pan
 * @since 17/8/3
 */
public interface DomainUdcFace extends UdcFace {

    /**
     * @return 领域代码
     */
    String getDomainCode();

    /**
     * @return UDC代码
     */
    String getUdcCode();

    /**
     * @return UDC描述
     */
    String getUdcDesc();

    /**
     * 连结字符
     */
    String UDC_JOINER = ".";

    /**
     * UDC构成
     */
    Pattern UDC_PATTERN = Pattern.compile("^(\\w+)\\" + UDC_JOINER + "(\\w+)$");

    @Override
    default String getCode() {
        return getDomainCode() + UDC_JOINER + getUdcCode();
    }

    @Override
    default String getName() {
        return getUdcDesc();
    }

}
