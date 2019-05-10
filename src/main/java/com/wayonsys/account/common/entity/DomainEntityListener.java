package com.wayonsys.account.common.entity;


import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @Author: allen
 * @Description:
 * @Date: created in 2018/11/12 16:31
 * @Modified By:
 */
@Configurable
public class DomainEntityListener {

    @PrePersist
    public void touchForCreate(Object target) {
        update(target);
    }

    @PreUpdate
    public void touchForUpdate(Object target) {
        //update(target);
    }

    private void update(Object target) {
        if (target instanceof DomainEntity) {
            DomainEntity entity = (DomainEntity) target;
//            LoginUser loginUser = SecurityUtils.getCurrentLoginUser();
//            if (loginUser.getTenantId() != null) {
//                entity.setTenantId(loginUser.getTenantId());
//            }
//            if (loginUser.getUserId() != null) {
//                entity.setOwnerId(loginUser.getUserId());
//            }
        }
    }


}
