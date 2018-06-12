package com.el.udc;

import com.el.cache.CacheName;
import com.el.cache.CachePoint;

import java.util.List;

/**
 * UDC 操作服务
 *
 * @author neo.pan
 * @since 16/11/8
 */
@CacheName("UDC")
public interface UdcService<U extends UdcFace, I extends UdcItem> {

    /**
     * 取得一组 UDC 项目
     *
     * @param udc UDC 定义
     * @return UDC 选项列表
     */
    @CachePoint("code")
    List<I> udcItems(U udc);

}
