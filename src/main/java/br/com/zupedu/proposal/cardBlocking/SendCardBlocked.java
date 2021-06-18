package br.com.zupedu.proposal.cardBlocking;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.cardsAssociation.enums.BlockingStatus;
import br.com.zupedu.proposal.externalSystems.accounts.AccountsIntegration;
import br.com.zupedu.proposal.externalSystems.accounts.BlockRequest;
import br.com.zupedu.proposal.externalSystems.accounts.BlockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class SendCardBlocked {

    @Autowired
    private AccountsIntegration accountsIntegration;

    public void execute(Card card) {
        String id = card.getId();

        BlockRequest request = new BlockRequest("proposals");

        try {
            BlockResponse response = accountsIntegration.SendCardBlocked(id, request);

            if (response.isBlocked()) {
                card.setBlockingStatus(BlockingStatus.BLOCKED);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
