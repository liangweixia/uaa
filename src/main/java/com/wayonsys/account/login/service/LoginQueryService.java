/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.service;


import com.wayonsys.account.common.exception.ServiceException;
import com.wayonsys.account.login.domain.Login;
import com.wayonsys.account.login.repository.LoginRepository;
import com.wayonsys.uaa.domain.User;
import com.wayonsys.uaa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoginQueryService {

    private static final Logger log = LoggerFactory.getLogger(LoginQueryService.class);

    @Autowired
    private LoginRepository repository;

    public Login find(Long id) {
        if(id == null) {
            throw new ServiceException("传入的id为空，请检查!");
        }
        Login result = repository.findById(id).get();
        if(result == null){
            throw new ServiceException("id无效，请检查!");
        }
        return result;
    }









}
