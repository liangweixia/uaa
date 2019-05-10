package com.wayonsys.account.common.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @Author: allen
 * @Description:
 * @Date: created in 2018/11/11 21:56
 * @Modified By:
 */
@MappedSuperclass
@Audited
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractAuditable extends IdEntity{

    /*@CreatedBy
    @JsonIgnore*/
    @Column(name = "created_by", nullable = false, updatable = false)
    private Long createdBy;

    /*@CreatedDate
    @JsonIgnore*/
    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    /*@LastModifiedBy
    @JsonIgnore*/
    @Column(name = "last_updated_by", nullable = false, updatable = false)
    private Long lastUpdatedBy;

    /*@LastModifiedDate
    @JsonIgnore*/
    @Column(name = "last_update_time", nullable = false)
    private LocalDateTime lastUpdatedTime;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
