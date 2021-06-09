package br.com.zupedu.proposal.createProposal;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CheckAlreadyExistDocument {

    public Boolean check(NewProposalRequest request, ProposalRepository proposalRepository) {
        Optional<Proposal> proposal = proposalRepository.findByDocument(request.getDocument());
        return proposal.isPresent();
    }
}
