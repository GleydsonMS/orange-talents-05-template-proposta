package br.com.zupedu.proposal.createProposal.controllers;

import br.com.zupedu.proposal.createProposal.dtos.ProposalResponse;
import br.com.zupedu.proposal.createProposal.entities.Proposal;
import br.com.zupedu.proposal.createProposal.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ShowProposalController {

    @Autowired
    private ProposalRepository proposalRepository;

    @GetMapping("/proposals/{id}")
    public ResponseEntity<ProposalResponse> find(@PathVariable("id") String id) {
        UUID proposalId = UUID.fromString(id);
        Optional<Proposal> proposal = proposalRepository.findById(proposalId);

        if (proposal.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        ProposalResponse response = new ProposalResponse(proposal.get());
        return ResponseEntity.ok(response);
    }
}
