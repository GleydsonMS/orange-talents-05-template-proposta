package br.com.zupedu.proposal.createProposal.repositories;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.createProposal.enums.StatusSolicitation;
import br.com.zupedu.proposal.createProposal.entities.Proposal;
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
