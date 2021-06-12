package br.com.zupedu.proposal.createProposal.entities;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.createProposal.enums.StatusSolicitation;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Proposal {

    @Id
    private UUID id;

    @NotBlank
    private String document;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    @Positive
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private StatusSolicitation status;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_number")
    private Card card;

    @Deprecated
    public Proposal() {};

    public Proposal(@NotBlank String document,
                    @NotBlank @Email String email,
                    @NotBlank String name,
                    @NotBlank String address,
                    @NotNull @Positive BigDecimal salary) {
        this.id = UUID.randomUUID();
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public StatusSolicitation getStatus() {
        return status;
    }

    public Card getCard() {
        return card;
    }

    public void setStatus(StatusSolicitation status) {
        this.status = status;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proposal)) return false;

        Proposal proposal = (Proposal) o;

        if (getDocument() != null ? !getDocument().equals(proposal.getDocument()) : proposal.getDocument() != null)
            return false;
        if (email != null ? !email.equals(proposal.email) : proposal.email != null) return false;
        if (getName() != null ? !getName().equals(proposal.getName()) : proposal.getName() != null) return false;
        if (address != null ? !address.equals(proposal.address) : proposal.address != null) return false;
        if (salary != null ? !salary.equals(proposal.salary) : proposal.salary != null) return false;
        return getStatus() == proposal.getStatus();
    }

    @Override
    public int hashCode() {
        int result = getDocument() != null ? getDocument().hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
}
