package com.wayonsys.account.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wayonsys.account.common.enums.StateEnum;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @Author: allen
 * @Description:
 * @Date: created in 2016/11/12 16:31
 * @Modified By:
 */
@MappedSuperclass
@EntityListeners({DomainEntityListener.class})
public abstract class DomainEntity extends AbstractAuditable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    protected Long tenantId;

    @JsonIgnore
    protected String objectState = StateEnum.ENABLE.getCode();

    @JsonIgnore
    protected Long ownerId = 0L;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getObjectState() {
        return objectState;
    }

    public void setObjectState(String objectState) {
        this.objectState = objectState;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
