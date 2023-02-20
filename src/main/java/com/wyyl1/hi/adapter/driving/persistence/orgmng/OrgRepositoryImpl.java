package com.wyyl1.hi.adapter.driving.persistence.orgmng;

import com.wyyl1.hi.domain.orgmng.Org;
import com.wyyl1.hi.domain.orgmng.OrgRepository;
import com.wyyl1.hi.domain.orgmng.OrgStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrgRepositoryImpl implements OrgRepository {
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
        return null;
    }
}
