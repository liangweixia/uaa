/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.vo;


import com.wayonsys.account.common.contract.BaseVo;
import com.wayonsys.account.login.domain.Login;

/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
public class LoginForm extends BaseVo<Login> {

    /**
     *  账户名
     */
    private String username;

    private String password;

    private String email;
    /**
     * 手机号 -
     */
    private String mobile;
    /**
     * 状态 -状态
     */
    private String status;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
