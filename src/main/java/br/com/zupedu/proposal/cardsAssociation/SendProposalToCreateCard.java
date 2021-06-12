package br.com.zupedu.proposal.cardsAssociation;

import br.com.zupedu.proposal.createProposal.Proposal;
import br.com.zupedu.proposal.createProposal.StatusSolicitation;
import br.com.zupedu.proposal.externalSystems.accounts.AccountsIntegration;
import br.com.zupedu.proposal.externalSystems.accounts.NewCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendProposalToCreateCard {

    @Autowired
    private AccountsIntegration accountsIntegration;

    public void execute(Proposal proposal) {
        if (proposal.getStatus().equals(StatusSolicitation.ELEGIVEL)) {
            NewCardRequest request = new NewCardRequest(proposal);
            accountsIntegration.create(request);
        }
    }
}
