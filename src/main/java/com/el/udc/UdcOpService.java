package com.el.udc;


import com.el.cache.CachePointEvict;
import com.el.cache.CachePointEvictAll;

import java.util.List;

/**
 * @author neo.pan
 * @since 17/5/10
 */
public interface UdcOpService<U extends UdcFace, I extends UdcItem> extends UdcService<U, I> {

    /**
     * 保存更新一组 UDC
     *
     * @param udc      UDC定义
     * @param udcItems UDC项目列表
     */
    @CachePointEvict("[0].code")
    void storeUdc(U udc, List<I> udcItems);

    /**
     * 清除所有 UDC
     */
    @CachePointEvictAll
    void evictAll();

}
