package com.wyyl1.hi.adapter.driven.restful.orgmng;

import com.wyyl1.hi.application.orgmng.OrgDto;
import com.wyyl1.hi.application.orgmng.OrgService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrgController {

    private final OrgService orgService;

    @PostMapping("/api/organizations")
    public OrgDto addOrg(@RequestBody OrgDto request) {
        return orgService.addOrg(request, request.getLeaderId());
    }
}
