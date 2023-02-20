package com.wyyl1.hi.application.orgmng;

import com.wyyl1.hi.adapter.driving.persistence.orgmng.EmpRepository;
import com.wyyl1.hi.adapter.driving.persistence.tenantmng.TenantRepository;
import com.wyyl1.hi.domain.orgmng.Org;
import com.wyyl1.hi.domain.orgmng.OrgRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrgService {

    private final TenantRepository tenantRepository;
    private final OrgRepository orgRepository;
    private final EmpRepository empRepository;

    public OrgDto addOrg(OrgDto request, Long userId) {
        validate(request);
        Org org = buildOrg(request, userId);
        org = orgRepository.save(org);
        return buildOrgDto(org);
    }

    private OrgDto buildOrgDto(Org org) {
        // 将领域对象的值赋给DTO...
        OrgDto result = new OrgDto();
        BeanUtils.copyProperties(org, result);

        return result;
    }

    private Org buildOrg(OrgDto request, Long useId) {
        // 将DTO的值赋给领域对象...
        Org result = new Org();
        BeanUtils.copyProperties(request, result);

        return result;
    }

    private void validate(OrgDto request) {
        // 进行各种业务规则的校验，会用到上面的各个Repository...
    }
}