package com.wyyl1.hi.application.orgmng;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrgDto {

    private Long id;
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private String status;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastUpdatedAt;
    private Long lastUpdatedBy;
}
