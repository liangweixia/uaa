/**
* Copyright 2019
* 版权所有 上海微元计算机集成有限公司
*/
package com.wayonsys.account.login.repository;

import com.wayonsys.account.login.domain.Login;
import com.wayonsys.uaa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * @Author: xia
 * @Description:
 * @Date: created in 2019-05-10 10:52:31
 * @Modified By:
 */
public interface LoginRepository extends JpaRepository<Login,Long> {
    Optional<Login> findByUsername(String username);
}
