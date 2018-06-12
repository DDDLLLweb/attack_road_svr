package com.el.udc;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Optional;

/**
 * @author neo.pan
 * @since 2018/04/10
 */
@Slf4j
@Getter
@EqualsAndHashCode(of = {"domainCode", "udcCode"})
@RequiredArgsConstructor
public class SimpleDomainUdc implements DomainUdcFace {

    private final String domainCode;
    private final String udcCode;
    private final String udcDesc;

    /**
     * @param udc udc
     * @return simple domain udc
     */
    public static Optional<SimpleDomainUdc> of(String udc) {
        val matcher = UDC_PATTERN.matcher(udc);
        return Optional.ofNullable(matcher.find() ? new SimpleDomainUdc(
            matcher.group(1), matcher.group(2), "") : null);
    }

    /**
     * @param udc udc
     * @return simple domain udc
     * @throws IllegalArgumentException if udc is invalid
     */
    public static SimpleDomainUdc ofOrThrow(String udc) {
        return of(udc).orElseThrow(() -> new IllegalArgumentException(
            "[CORE-UDC] Invalid UDC expression: " + udc));
    }

}
