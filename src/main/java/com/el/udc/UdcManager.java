package com.el.udc;

import java.util.List;

/**
 * @author neo.pan
 * @since 2018/04/10
 */
public interface UdcManager<U extends UdcFace> extends UdcResolver<U> {

    /**
     * @return 所有的 UDC 定义
     */
    List<U> udcs();

}
