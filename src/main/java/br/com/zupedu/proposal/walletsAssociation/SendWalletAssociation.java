package br.com.zupedu.proposal.walletsAssociation;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.externalSystems.accounts.AccountsIntegration;
import br.com.zupedu.proposal.externalSystems.accounts.wallets.WalletAssociationRequest;
import br.com.zupedu.proposal.externalSystems.accounts.wallets.WalletAssociationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class SendWalletAssociation {

    @Autowired
    private AccountsIntegration accountsIntegration;

    public Wallet execute(Card card, NewWalletAssociation newWalletAssociation) {
        WalletAssociationRequest request = newWalletAssociation.toModel();

        try {
            WalletAssociationResponse response = accountsIntegration.SendWalletAssociation(card.getId(), request);
            return new Wallet(response.getId(), request.getEmail(), WalletName.valueOf(request.getCarteira()), card);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
