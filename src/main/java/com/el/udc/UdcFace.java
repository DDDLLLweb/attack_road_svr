package com.el.udc;

import com.el.domain.CodeName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * UDC 定义
 *
 * @author neo.pan
 * @since 17/3/7
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface UdcFace extends CodeName, Serializable {
}
