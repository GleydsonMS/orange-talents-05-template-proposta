package br.com.zupedu.proposal.createProposal;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class CheckAlreadyExistDocument {

    public void check(NewProposalRequest request, ProposalRepository proposalRepository) {
        Optional<Proposal> proposal = proposalRepository.findByDocument(request.getDocument());

        if (proposal.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
