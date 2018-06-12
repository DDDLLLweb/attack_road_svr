package com.el.demo.udc;

import com.el.udc.UdcItem;
import lombok.Value;

/**
 * @author neo.pan
 * @since 2018/04/10
 */
@Value(staticConstructor = "of")
public class DemoUdcItem implements UdcItem {
    private final String code;
    private final String name;
}
