package com.el.udc;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author neo.pan
 * @since 2018/04/10
 */
@Service
public class SimpleUdcManager<U extends UdcFace> implements UdcManager<U> {

    private List<U> udcs;
    private Map<String, U> udcMap;

    public static <U extends UdcFace> SimpleUdcManager<U> of(List<U> udcs) {
        SimpleUdcManager<U> manager = new SimpleUdcManager<>();
        manager.udcs = udcs;
        manager.udcMap = udcs.stream().collect(Collectors.toMap(
            UdcFace::getCode, Function.identity()));
        return manager;
    }

    @Override
    public List<U> udcs() {
        return udcs;
    }

    @Override
    public U resolve(String udc) {
        return Optional.ofNullable(udcMap.get(udc))
            .orElseThrow(() -> new IllegalArgumentException("[CORE-UDC] Invalid UDC: " + udc));
    }

}
