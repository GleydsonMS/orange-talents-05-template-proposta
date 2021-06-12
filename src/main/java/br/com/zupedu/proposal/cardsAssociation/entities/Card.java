package br.com.zupedu.proposal.cardsAssociation.entities;

import br.com.zupedu.proposal.createProposal.entities.Proposal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Card {

    @Id
    private String id;

    @NotNull
    private LocalDateTime issuedOn;

    @NotBlank
    private String holder;

    @NotNull
    private BigDecimal creditLimit;

    @OneToOne(cascade = CascadeType.MERGE)
    private DueDate dueDate;

    @OneToOne
    private Proposal proposal;

    @Deprecated
    public Card() {}

    public Card(String id, LocalDateTime issuedOn, String holder, BigDecimal creditLimit,  DueDate dueDate, Proposal proposal) {
        this.id = id;
        this.issuedOn = issuedOn;
        this.holder = holder;
        this.creditLimit = creditLimit;
        this.dueDate = dueDate;
        this.proposal = proposal;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getIssuedOn() {
        return issuedOn;
    }

    public String getHolder() {
        return holder;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public DueDate getDueDate() {
        return dueDate;
    }

    public Proposal getProposal() {
        return proposal;
    }
}
