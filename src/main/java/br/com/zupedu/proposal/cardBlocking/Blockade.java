package br.com.zupedu.proposal.cardBlocking;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Blockade {

    @Id
    private UUID id;

    @NotNull
    @ManyToOne
    private Card card;

    @NotNull
    private LocalDateTime blockageInstant;

    @NotBlank
    private String ipAddress;

    @NotBlank
    private String userAgent;

    @Deprecated
    public Blockade() {}

    public Blockade(Card card, String ipAddress, String userAgent) {
        this.id = UUID.randomUUID();
        this.card = card;
        this.blockageInstant = LocalDateTime.now();
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }
}
