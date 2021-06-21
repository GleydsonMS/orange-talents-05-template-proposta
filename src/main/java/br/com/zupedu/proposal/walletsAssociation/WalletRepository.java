package br.com.zupedu.proposal.walletsAssociation;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
    Optional<Wallet> findByCardAndWallet(Card card, WalletName wallet);
}
