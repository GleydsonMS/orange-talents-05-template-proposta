package br.com.zupedu.proposal.createProposal;

import br.com.zupedu.proposal.cardsAssociation.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, UUID> {
    Optional<Proposal> findByDocument(String document);
    Optional<List<Proposal>> findAllByStatusAndCard(StatusSolicitation status, Card card);
}
