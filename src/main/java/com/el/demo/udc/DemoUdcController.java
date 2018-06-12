package com.el.demo.udc;

import com.el.udc.UdcManager;
import com.el.udc.UdcNameResolver;
import com.el.udc.UdcOpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author neo.pan
 * @since 17/5/10
 */
@Profile("demo")
@Slf4j
@RestController
@RequestMapping("/demo/udcs")
@RequiredArgsConstructor
public class DemoUdcController {

    private final UdcManager<DemoUdc> udcManager;

    private final UdcOpService<DemoUdc, DemoUdcItem> udcService;

    private final UdcNameResolver<DemoUdc, DemoUdcItem> udcNameResolver;

    @GetMapping
    public List<DemoUdc> udcs() {
        return udcManager.udcs();
    }

    @GetMapping("/{udc}/items")
    public List<DemoUdcItem> udcItems(@PathVariable("udc") String udc) {
        log.info("[DEMO-UDC] udc: {}", udc);
        return udcService.udcItems(udcManager.resolve(udc));
    }

    @PostMapping("/store")
    public void storeUdc(@RequestBody DemoUdcPayload payload) {
        udcService.storeUdc(udcManager.resolve(payload.getUdc()), payload.getItems());
    }

    @PostMapping("/evict")
    public void evictAll() {
        udcService.evictAll();
    }

    /**
     * 比如是从DB取出来的原始数据（其中的 UDC Name 尚未被赋值）
     */
    private static List<DemoUdcSample> fetchSampleItems() {
        return Arrays.asList(
            DemoUdcSample.of("01", "Hello"),
            DemoUdcSample.of("04", "World"));
    }

    /**
     * @return 返回的原始数据
     */
    @GetMapping("/sample/items")
    public List<DemoUdcSample> sampleItems() {
        return fetchSampleItems();
    }

    /**
     * @return 返回的数据中 UDC Name 已被赋值
     */
    @GetMapping("/sample/itemsWithUdcNames")
    public List<DemoUdcSample> sampleItemsWithUdcNames() {
        return udcNameResolver.resolveUdcNames(fetchSampleItems());
    }

}
