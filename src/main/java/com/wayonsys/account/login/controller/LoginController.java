/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.controller;


import com.wayonsys.account.common.contract.BaseVo;
import com.wayonsys.account.common.contract.ResultVo;
import com.wayonsys.account.common.domain.PageInfo;
import com.wayonsys.account.common.exception.ServiceException;
import com.wayonsys.account.common.utils.ExceptionUtils;
import com.wayonsys.account.login.domain.Login;
import com.wayonsys.account.login.mapper.LoginMapperQueryService;
import com.wayonsys.account.login.service.LoginQueryService;
import com.wayonsys.account.login.service.LoginService;
import com.wayonsys.account.login.vo.LoginForm;
import com.wayonsys.account.login.vo.LoginQuery;
import com.wayonsys.account.login.vo.LoginRecord;
import com.wayonsys.uaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micrometer.core.annotation.Timed;


/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
@RestController
@RequestMapping("/api/user")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService service;
    @Autowired
    private LoginQueryService queryService;
    @Autowired
    private LoginMapperQueryService mapperQueryService;


    @PostMapping(value = "/create")
    @Timed
    public ResultVo create(@RequestBody LoginForm form){
        try {
            Long id = service.create(form);
            ResultVo resultVo = new ResultVo(id);
            return resultVo;
        }catch (ServiceException se){
            throw se;
        }catch (Exception e){
            log.error(ExceptionUtils.getErrorInfo(e));
            String message = String.format("controller:%s,method:%s,message:%s","UserController","create",e.getMessage());
            throw new ServiceException("2000",message);
        }
    }

    @PostMapping(value = "/modify")
    @Timed
    public ResultVo modify(@RequestBody LoginForm form){
        try {
            service.modify(form);
            ResultVo resultVo = new ResultVo();
            return resultVo;
        }catch (ServiceException se){
            throw se;
        }catch (Exception e){
            log.error(ExceptionUtils.getErrorInfo(e));
            String message = String.format("controller:%s,method:%s,message:%s","UserController","modify",e.getMessage());
            throw new ServiceException("2000",message);
        }
    }

    @PostMapping(value = "/search")
    @Timed
    public ResultVo search(@RequestBody LoginQuery query) {
        try {
            PageInfo<LoginRecord> pageInfo = mapperQueryService.search(query);
            ResultVo resultVo = new ResultVo(pageInfo);
            return resultVo;
        }catch (ServiceException se){
            throw se;
        }catch (Exception e){
            log.error(ExceptionUtils.getErrorInfo(e));
            String message = String.format("controller:%s,method:%s,message:%s","UserController","search",e.getMessage());
            throw new ServiceException("2000",message);
        }
    }

    @PostMapping(value = "/find")
    @Timed
    public ResultVo find(@RequestBody BaseVo vo){
        try {
            Long id = vo.getId();
            Login result = queryService.find(id);
            ResultVo resultVo = new ResultVo(result);
            return resultVo;
        }catch (ServiceException se){
            throw se;
        }catch (Exception e){
            log.error(ExceptionUtils.getErrorInfo(e));
            String message = String.format("controller:%s,method:%s,message:%s","UserController","find",e.getMessage());
            throw new ServiceException("2000",message);
        }
    }

    @PostMapping(value = "/disable")
    @Timed
    public ResultVo disable(@RequestBody BaseVo vo) {
        try {
            ResultVo resultVo = new ResultVo();
            service.disable(vo.getId());
            return resultVo;
        }catch (ServiceException se){
            throw se;
        }catch (Exception e){
            log.error(ExceptionUtils.getErrorInfo(e));
            String message = String.format("controller:%s,method:%s,message:%s","UserController","disable",e.getMessage());
            throw new ServiceException("2000",message);
        }
    }

    @PostMapping(value = "/delete")
    @Timed
    public ResultVo delete(@RequestBody BaseVo vo) {
        try {
            ResultVo resultVo = new ResultVo();
            service.delete(vo.getId());
            return resultVo;
        }catch (ServiceException se){
            throw se;
        }catch (Exception e){
            log.error(ExceptionUtils.getErrorInfo(e));
            String message = String.format("controller:%s,method:%s,message:%s","UserController","delete",e.getMessage());
            throw new ServiceException("2000",message);
        }
    }


}
