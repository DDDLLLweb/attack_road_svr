package com.el.demo.udc;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author neo.pan
 * @since 17/5/10
 */
public class DemoUdcStore {

    private Map<DemoUdc, List<DemoUdcItem>> store = new ConcurrentHashMap<>();

    public DemoUdcStore() {
        // INITAL DATA
        store.put(DemoUdc.ACT_STATUS, Arrays.asList(
            DemoUdcItem.of("01", "已生成"),
            DemoUdcItem.of("02", "已派发"),
            DemoUdcItem.of("03", "已执行"),
            DemoUdcItem.of("04", "已完成")));
        store.put(DemoUdc.ACT_TYPE, Arrays.asList(
            DemoUdcItem.of("01", "JDE"),
            DemoUdcItem.of("02", "Java"),
            DemoUdcItem.of("03", ".NET"),
            DemoUdcItem.of("04", "HTML")));
        store.put(DemoUdc.RES_STATUS, Arrays.asList(
            DemoUdcItem.of("01", "FREE"),
            DemoUdcItem.of("02", "BUSY")));
        store.put(DemoUdc.RES_TYPE, Arrays.asList(
            DemoUdcItem.of("01", "JDE-Dev"),
            DemoUdcItem.of("02", "JDE-Biz"),
            DemoUdcItem.of("03", "Java-Dev"),
            DemoUdcItem.of("04", ".NET-Dev")));
    }

    public void store(DemoUdc udc, Collection<DemoUdcItem> items) {
        store.put(udc, new ArrayList<>(items));
    }

    public List<DemoUdcItem> udcItemsOf(DemoUdc udc) {
        return Collections.unmodifiableList(store.get(udc));
    }

}
