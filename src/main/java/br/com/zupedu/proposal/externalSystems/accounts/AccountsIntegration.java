package br.com.zupedu.proposal.externalSystems.accounts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "accounts", url = "${external.api.accounts}")
public interface AccountsIntegration {

    @PostMapping("/api/cartoes")
    void create(NewCardRequest request);

    @GetMapping("/api/cartoes")
    NewCardResponse findCardProposalId(@Valid @RequestParam("idProposta") String id);

    @GetMapping("/api/cartoes/{id}")
    NewCardResponse findCardId(@Valid @PathVariable("id") String id);

    @PostMapping("/api/cartoes/{id}/bloqueios")
    BlockResponse SendCardBlocked(@PathVariable("id") String id, @Valid BlockRequest request);
}
