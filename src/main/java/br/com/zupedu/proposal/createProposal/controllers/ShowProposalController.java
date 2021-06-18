package br.com.zupedu.proposal.createProposal.controllers;

import br.com.zupedu.proposal.config.metrics.ProposalMetrics;
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

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ShowProposalController {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private ProposalMetrics proposalMetrics;

    @GetMapping("/proposals/{id}")
    public ResponseEntity<ProposalResponse> find(@PathVariable("id") String id) {
        Long init = System.currentTimeMillis();
        UUID proposalId = UUID.fromString(id);
        Optional<Proposal> proposal = proposalRepository.findById(proposalId);

        if (proposal.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        ProposalResponse response = new ProposalResponse(proposal.get());
        Long end = System.currentTimeMillis();
        Long duration = end - init;
        proposalMetrics.timerFindProposalRecord(Duration.of(duration, ChronoUnit.MILLIS));
        return ResponseEntity.ok(response);
    }
}
