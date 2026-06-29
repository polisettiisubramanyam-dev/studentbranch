package com.site.studentbranch.entity;

import com.site.studentbranch.auditing.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
    @CreatedBy
    @Column(updatable = false,name="created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(insertable = false,name="modified_by")
    private String updatedBy;

    @CreatedDate
    @Column(updatable = false,name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false,name="modified_at")
    private LocalDateTime updatedAt;
}
