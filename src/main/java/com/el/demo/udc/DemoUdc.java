package com.el.demo.udc;

import com.el.udc.DomainUdcFace;
import lombok.Getter;

/**
 * @author neo.pan
 * @since 17/5/10
 */
@Getter
public enum DemoUdc implements DomainUdcFace {

    ACT_TYPE("ACT", "TYPE", "活动类型"),
    ACT_STATUS("ACT", "STATUS", "活动状态"),
    RES_TYPE("RES", "TYPE", "资源类型"),
    RES_STATUS("RES", "STATUS", "资源状态"),;

    private final String domainCode;
    private final String udcCode;
    private final String udcDesc;

    DemoUdc(String domainCode, String udcCode, String udcDesc) {
        this.domainCode = domainCode;
        this.udcCode = udcCode;
        this.udcDesc = udcDesc;
    }

}
