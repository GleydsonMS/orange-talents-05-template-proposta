package br.com.zupedu.proposal.walletsAssociation;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @NotBlank
    private String wallet;

    @NotNull
    @ManyToOne
    private Card card;

    @Deprecated
    public Wallet() {}

    public Wallet(String id, String email, String wallet, Card card) {
        this.id = id;
        this.email = email;
        this.wallet = wallet;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public String getWallet() {
        return wallet;
    }

    public Card getCard() {
        return card;
    }
}
