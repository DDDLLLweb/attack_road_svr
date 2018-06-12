package com.el.demo.udc;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author neo.pan
 * @since 17/5/10
 */
@Data
@EqualsAndHashCode(of = "udc")
public class DemoUdcPayload {
    private String udc;
    private List<DemoUdcItem> items;
}
