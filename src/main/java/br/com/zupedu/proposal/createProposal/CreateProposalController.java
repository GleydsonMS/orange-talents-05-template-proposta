package br.com.zupedu.proposal.createProposal;

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

    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody @Valid NewProposalRequest request,
                                            UriComponentsBuilder uriComponentsBuilder) {
        Proposal proposal = request.toModel();
        proposalRepository.save(proposal);

        URI identifier = uriComponentsBuilder.path("/proposal/{id}").build(proposal.getId());

        return ResponseEntity.created(identifier).build();
    }
}
