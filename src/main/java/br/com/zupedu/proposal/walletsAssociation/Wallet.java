package br.com.zupedu.proposal.walletsAssociation;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Wallet {

    @Id
    private String id;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WalletName wallet;

    @NotNull
    @ManyToOne
    private Card card;

    @Deprecated
    public Wallet() {}

    public Wallet(String id, String email, WalletName wallet, Card card) {
        this.id = id;
        this.email = email;
        this.wallet = wallet;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public WalletName getWallet() {
        return wallet;
    }

    public Card getCard() {
        return card;
    }
}
