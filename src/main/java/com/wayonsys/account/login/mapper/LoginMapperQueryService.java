/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.mapper;


import com.wayonsys.account.common.domain.PageInfo;
import com.wayonsys.account.login.vo.LoginQuery;
import com.wayonsys.account.login.vo.LoginRecord;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
@Service
public class LoginMapperQueryService {

    private static final Logger log = LoggerFactory.getLogger(LoginMapperQueryService.class);

    @Autowired
    private SqlSession sqlSession;

    public PageInfo<LoginRecord> search(LoginQuery query) {
        LoginQueryMapper mapper = sqlSession.getMapper(LoginQueryMapper.class);
        List<LoginRecord> results = mapper.findLoginList(query);
        int totalItems = mapper.findLoginListCount(query);
        PageInfo<LoginRecord> pageInfo = new PageInfo<>(results, totalItems);
        return pageInfo;
    }






}
