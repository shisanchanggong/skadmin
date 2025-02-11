package com.dxj.admin.domain;

import com.dxj.common.util.AesEncryptUtils;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author dxj
 * @date 2019-04-30
 */
@Getter
@Setter
public class AuthorizationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Override
    public String toString() {
        return "{username=" + username + ", password=" + AesEncryptUtils.encryptPassword(username + password);
    }
}
