package br.com.zupedu.proposal.cardsAssociation;

import br.com.zupedu.proposal.createProposal.Proposal;
import br.com.zupedu.proposal.createProposal.ProposalRepository;
import br.com.zupedu.proposal.createProposal.StatusSolicitation;
import br.com.zupedu.proposal.externalSystems.accounts.AccountsIntegration;
import br.com.zupedu.proposal.externalSystems.accounts.NewCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryAccountAPI {

    @Autowired
    private AccountsIntegration accountsIntegration;

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private SendProposalToCreateCard sendProposalToCreateCard;

    @Scheduled(fixedDelayString = "${frequency.execute.operation}")
    public void execute() {
        List<Proposal> proposalsWithoutCard = proposalRepository
                .findAllByStatusAndCard(StatusSolicitation.ELEGIVEL, null)
                .get();

        boolean check = !proposalsWithoutCard.isEmpty();

        if (check) {
              proposalsWithoutCard.forEach(proposal -> {
                    sendProposalToCreateCard.execute(proposal);
                    NewCardResponse response = accountsIntegration.findCardProposalId(proposal.getId().toString());
                    Card card = response.toModel(proposalRepository);
                    proposal.setCard(card);
                    proposalRepository.save(proposal);
              });
        }
    }
}
