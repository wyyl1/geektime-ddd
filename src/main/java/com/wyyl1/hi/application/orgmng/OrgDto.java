package com.wyyl1.hi.application.orgmng;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrgDto {

    private Integer id;
    private Integer tenantId;
    private Integer superiorId;
    private String orgTypeCode;
    private Integer leaderId;
    private String name;
    private String status;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime lastUpdatedAt;
    private Integer lastUpdatedBy;
}
