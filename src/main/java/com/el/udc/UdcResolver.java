package com.el.udc;

/**
 * @author neo.pan
 * @since 17/5/10
 */
public interface UdcResolver<U extends UdcFace> {

    /**
     * @param udc udc
     * @return udc object
     */
    U resolve(String udc);
}
