package br.com.zupedu.proposal.biometrics;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Biometry {

    @Id
    private UUID id;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String fingerprint;

    @NotNull
    private LocalDateTime createdAt;

    @ManyToOne
    @NotNull
    private Card card;

    @Deprecated
    private Biometry() {}

    public Biometry(String fingerprint, Card card) {
        this.id = UUID.randomUUID();
        this.fingerprint = fingerprint;
        this.createdAt = LocalDateTime.now();
        this.card = card;
    }

    public UUID getId() {
        return id;
    }
}
