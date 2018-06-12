package com.el.demo.udc;

import com.el.udc.UdcOpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author neo.pan
 * @since 2018/04/11
 */
@Slf4j
@RequiredArgsConstructor
public class DemoUdcService implements UdcOpService<DemoUdc, DemoUdcItem> {

    private final DemoUdcStore store;

    @Override
    public void storeUdc(DemoUdc udc, List<DemoUdcItem> udcItems) {
        log.info("[DEMO-UDC] store udc");
        store.store(udc, udcItems);
    }

    @Override
    public void evictAll() {
        log.info("[DEMO-UDC] evict all");
    }

    @Override
    public List<DemoUdcItem> udcItems(DemoUdc udc) {
        log.info("[DEMO-UDC] fetch udc");
        return store.udcItemsOf(udc);
    }

}
