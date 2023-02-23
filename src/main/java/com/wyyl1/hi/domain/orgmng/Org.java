package com.wyyl1.hi.domain.orgmng;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Org {

    private Integer id;
    private Integer tenantId;
    private Integer superiorId;
    private String orgTypeCode;
    private Integer leaderId;
    private String name;
    private OrgStatus status;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime lastUpdatedAt;
    private Integer lastUpdatedBy;

    public Org() {
        // 组织的初始状态默认为有效
        status = OrgStatus.EFFECTIVE;
    }
}
