package com.dxj.common.util;

import com.dxj.common.exception.BadRequestException;

import java.util.Optional;

/**
 * 验证工具
 *
 * @author dxj
 * @date 2019-04-23
 */
public class ValidationUtils {

    /**
     * 验证空
     *
     * @param optional
     */
    public static void isNull(Optional optional, String entity, String parameter, Object value) {
        if (!optional.isPresent()) {
            String msg = entity
                    + " 不存在 "
                    + "{ " + parameter + ":" + value.toString() + " }";
            throw new BadRequestException(msg);
        }
    }

    /**
     * 验证是否为邮箱
     *
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        if (string == null) {
            return false;
        }
        String regEx = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return string.matches(regEx);
    }
}
