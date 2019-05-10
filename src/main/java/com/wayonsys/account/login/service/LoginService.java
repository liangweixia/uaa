/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.service;



import com.wayonsys.account.login.domain.Login;
import com.wayonsys.account.login.repository.LoginRepository;
import com.wayonsys.account.login.vo.LoginForm;
import com.wayonsys.uaa.domain.User;
import com.wayonsys.uaa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;


/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginRepository repository;
    @Autowired
    private LoginQueryService queryService;
    @Autowired
    private LoginService loginService;

    public Long create (LoginForm form){
        Login entity = form.toDomain();
        entity = repository.save(entity);
        return entity.getId();
    }

    public void modify(LoginForm form){
        Login entity = queryService.find(form.getId());
        BeanUtils.copyProperties(form,entity);
        repository.save(entity);
    }

    public void disable(Long id){
        Login entity = queryService.find(id);
        entity.setStatus("N");
        repository.save(entity);
    }

    public void delete(Long id){
        Login entity = queryService.find(id);
        repository.delete(entity);
    }
}
