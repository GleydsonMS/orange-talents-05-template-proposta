package br.com.zupedu.proposal.createProposal.controllers;

import br.com.zupedu.proposal.createProposal.dtos.NewProposalRequest;
import br.com.zupedu.proposal.createProposal.entities.Proposal;
import br.com.zupedu.proposal.createProposal.repositories.ProposalRepository;
import br.com.zupedu.proposal.createProposal.components.CheckAlreadyExistDocument;
import br.com.zupedu.proposal.createProposal.components.CheckSolicitation;
import br.com.zupedu.proposal.externalSystems.solicitations.SolicitationIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/proposals")
public class CreateProposalController {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private CheckAlreadyExistDocument checkAlreadyExistDocument;

    @Autowired
    private SolicitationIntegration solicitationIntegration;

    @Autowired
    private CheckSolicitation solicitation;

    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody @Valid NewProposalRequest request,
                                            UriComponentsBuilder uriComponentsBuilder) {

        checkAlreadyExistDocument.check(request, proposalRepository);

        Proposal proposal = request.toModel();

        solicitation.check(solicitationIntegration, proposal);

        proposalRepository.save(proposal);

        URI identifier = uriComponentsBuilder.path("/proposal/{id}").build(proposal.getId());

        return ResponseEntity.created(identifier).build();
    }
}
