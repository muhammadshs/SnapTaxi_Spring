package com.dwteam.common;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class Person {
    @NotNull
    @Column(name = "userName", unique = true)
    private String userName;
    @NotNull
    @Column(name = "passWord")
    private String passWord;
    @NotNull
    @Column(name = "phoneNumber", unique = true)
    private Long phoneNumber;
    @NotNull
    @Column(name = "state", columnDefinition = "Integer default 0")
    private Integer state;

    @NotNull
    @Column(name = "balance")
    private Double balance;

    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifyBy;

    @Version
    private Integer version;
    @PrePersist
    private void valueState() {
        state = 0;
    }
}
