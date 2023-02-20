package com.wyyl1.hi.domain.orgmng;

import java.util.Optional;

public interface OrgRepository {

    Optional<Org> findByIdAndStatus(long tenantId, Long id, OrgStatus status);

    int countBySuperiorAndName(long tenantId, Long superiorId, String name);

    boolean existsBySuperiorAndName(Long tenant, Long superior, String name);

    Org save(Org org);
}
