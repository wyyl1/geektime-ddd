package com.wyyl1.hi.adapter.driving.persistence.orgmng;

import com.test.common.BaseTest;
import com.test.common.factory.MapperFactoryImpl;
import com.wyyl1.hi.adapter.driving.persistence.orgmng.mapper.OrgMapper;
import com.wyyl1.hi.domain.orgmng.Org;
import com.wyyl1.hi.domain.orgmng.OrgRepository;
import com.wyyl1.hi.domain.orgmng.OrgStatus;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.time.LocalDateTime;

class OrgRepositoryImplTest extends BaseTest {

//    private OrgRepository repository = new OrgRepositoryImpl(MapperFactoryImpl.of().mapper(OrgMapper.class));

    @Resource
    private OrgRepository repository;
    @Test
    void save_success() {
        Org org = new Org();
        org.setTenantId(1);
        org.setSuperiorId(1);
        org.setOrgTypeCode("test");
        org.setLeaderId(1);
        org.setName("test");
        org.setStatus(OrgStatus.EFFECTIVE);
        org.setCreatedAt(LocalDateTime.now());
        org.setCreatedBy(1);

        repository.save(org);
    }
}