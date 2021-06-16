package br.com.zupedu.proposal.cardsAssociation.repositories;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
