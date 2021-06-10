package br.com.zupedu.proposal.externalSystems;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "solicitation", url = "http://localhost:9999/api/solicitacao")
public interface SolicitationIntegration {

    @PostMapping("/")
    ProposalSolicitationResponse evaluate(@RequestBody ProposalSolicitationRequest request);
}
