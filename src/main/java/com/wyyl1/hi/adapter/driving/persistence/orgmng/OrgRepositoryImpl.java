package com.wyyl1.hi.adapter.driving.persistence.orgmng;

import com.wyyl1.hi.adapter.driving.persistence.orgmng.entity.OrgEntity;
import com.wyyl1.hi.adapter.driving.persistence.orgmng.mapper.OrgMapper;
import com.wyyl1.hi.domain.orgmng.Org;
import com.wyyl1.hi.domain.orgmng.OrgRepository;
import com.wyyl1.hi.domain.orgmng.OrgStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class OrgRepositoryImpl implements OrgRepository {

    private OrgMapper mapper;

    @Override
    public Optional<Org> findByIdAndStatus(long tenantId, Long id, OrgStatus status) {
        return Optional.empty();
    }

    @Override
    public int countBySuperiorAndName(long tenantId, Long superiorId, String name) {
        return 0;
    }

    @Override
    public boolean existsBySuperiorAndName(Long tenant, Long superior, String name) {
        return false;
    }

    @Override
    public Org save(Org org) {
        OrgEntity entity = new OrgEntity();
        BeanUtils.copyProperties(org, entity);

        int insert = mapper.insert(entity);
        if (insert != 1) {
            throw new RuntimeException("插入组织失败");
        }

        return org;
    }
}
