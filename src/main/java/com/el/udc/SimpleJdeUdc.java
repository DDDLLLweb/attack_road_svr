package com.el.udc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author neo.pan
 * @since 2018/04/11
 */
@Slf4j
public class SimpleJdeUdc extends SimpleDomainUdc {

    public SimpleJdeUdc(String domainCode, String udcCode, String udcDesc) {
        super(domainCode, udcCode, udcDesc);
    }

    /**
     * UDC值字段存储容量(单位：字符)
     */
    private static final int UDC_VAL_SIZE = 10;
    /**
     * 完整宽度的UDC值
     */
    private static final String UDC_VAL_FULL = " " + UDC_VAL_SIZE;

    /**
     * 当UDC的DD定义的宽度小于DB字段宽度，需要左边补空。
     */
    private String leftSpaces = "";

    /**
     * @param valSize UDC值宽度
     */
    public void setValSize(int valSize) {
        if (valSize < UDC_VAL_SIZE) {
            leftSpaces = UDC_VAL_FULL.substring(0, UDC_VAL_SIZE - valSize);
        }
    }

    /**
     * 例如：valSize=3，则左空数=UDC_VAL_SIZE-valSize=7，故UDC值"AB" -> "       AB"。
     *
     * @param udcVal UDC值
     * @return 填充左空
     */
    public String leftPad(String udcVal) {
        udcVal = leftSpaces + udcVal;
        if (udcVal.length() > UDC_VAL_SIZE) {
            log.warn("[CORE-UDC] UDC value({})' size is oversized.", udcVal, UDC_VAL_SIZE);
        }
        return udcVal;
    }

    /**
     * 例如：valSize=3，则左空数=UDC_VAL_SIZE-valSize=7，故UDC值"AB" -> "       AB "。
     *
     * @param udcVal UDC值
     * @return 左右空填充
     */
    public String fullPad(String udcVal) {
        udcVal = leftPad(udcVal);
        if (udcVal.length() < UDC_VAL_SIZE) {
            udcVal += UDC_VAL_FULL.substring(0, UDC_VAL_SIZE - udcVal.length());
        }
        return udcVal;
    }

}
