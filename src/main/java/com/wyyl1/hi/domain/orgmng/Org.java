package com.wyyl1.hi.domain.orgmng;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Org {

    private Long id;
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private OrgStatus status;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastUpdatedAt;
    private Long lastUpdatedBy;

    public Org() {
        // 组织的初始状态默认为有效
        status = OrgStatus.EFFECTIVE;
    }
}
