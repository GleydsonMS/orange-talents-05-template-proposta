package br.com.zupedu.proposal.externalSystems.accounts;

import br.com.zupedu.proposal.externalSystems.accounts.blocks.BlockRequest;
import br.com.zupedu.proposal.externalSystems.accounts.blocks.BlockResponse;
import br.com.zupedu.proposal.externalSystems.accounts.cards.NewCardRequest;
import br.com.zupedu.proposal.externalSystems.accounts.cards.NewCardResponse;
import br.com.zupedu.proposal.externalSystems.accounts.travels.TravelNoticeRequest;
import br.com.zupedu.proposal.externalSystems.accounts.travels.TravelNoticeResponse;
import br.com.zupedu.proposal.externalSystems.accounts.wallets.WalletAssociationRequest;
import br.com.zupedu.proposal.externalSystems.accounts.wallets.WalletAssociationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/api/cartoes/{id}/avisos")
    TravelNoticeResponse SendTravelNotice(@PathVariable("id") String id, @Valid TravelNoticeRequest request);

    @PostMapping("/api/cartoes/{id}/carteiras")
    WalletAssociationResponse SendWalletAssociation(@PathVariable("id") String id, @Valid WalletAssociationRequest request);
}
