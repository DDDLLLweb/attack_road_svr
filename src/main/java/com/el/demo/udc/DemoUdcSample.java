package com.el.demo.udc;

import com.el.udc.UdcName;
import lombok.Data;

/**
 * @author neo.pan
 * @since 17/5/11
 */
@Data
public class DemoUdcSample {

    private String someUdcCode;

    @UdcName(udcName = "ACT.STATUS", codePropName = "someUdcCode")
    private String someUdcName;

    private String anyOthers;

    public static DemoUdcSample of(String code, String others) {
        DemoUdcSample obj = new DemoUdcSample();
        obj.someUdcCode = code;
        obj.anyOthers = others;
        return obj;
    }

}
