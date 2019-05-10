/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.mapper;



import com.wayonsys.account.login.vo.LoginQuery;
import com.wayonsys.account.login.vo.LoginRecord;

import java.util.List;

/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
public interface LoginQueryMapper {

    Integer findLoginListCount(LoginQuery query);
    List<LoginRecord> findLoginList(LoginQuery query);
}
