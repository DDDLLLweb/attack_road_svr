package com.el.domain;

import com.el.util.JsonUtil;
import lombok.Getter;
import lombok.val;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author neo.pan
 * @since 17/4/28
 */
public enum CoreOp implements OpResult {

    OK("操作成功"),
    NG_CAPTCHA("验证码输入错误"),
    NG_ACCOUNT("用户名或密码错"),
    NG_USER_NOT_FOUND("用户未找到"),
    NG_NEW_PWD_IS_OLD("新密码与旧密码重复"),
    NG_NEW_PWD_IS_POOR("新密码强度不够"),
    NG_OLD_PWD_IS_WRONG("旧密码错误"),
    NG_USER_ALREADY_EXISTS("用户已存在"),
    NG_EMAIL_FORMAT_ERROR("邮箱格式验证错误"),
    NG_PHONE_FORMAT_ERROR("手机号格式验证错误"),
    ;

    @Getter
    private final String desc;

    @Override
    public String getCode() {
        return name();
    }

    CoreOp(String desc) {
        this.desc = desc;
    }

    /**
     * @return 产生用于前端使用的代码消息映射
     */
    public static String toJsonCodeMap() {
        val codeMap = new HashMap<String, String>();
        Stream.of(CoreOp.values()).forEach(r -> codeMap.put(r.getCode(), r.getDesc()));
        return JsonUtil.toJsonOrEmpty(codeMap);
    }
}
