package br.com.zupedu.proposal.externalSystems.solicitations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "solicitation", url = "${external.api.solicitation}")
public interface SolicitationIntegration {

    @PostMapping("/api/solicitacao")
    ProposalSolicitationResponse evaluate(@RequestBody ProposalSolicitationRequest request);
}
