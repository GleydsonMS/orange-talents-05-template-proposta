package br.com.zupedu.proposal.travelNotice;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TravelNotice {

    @Id
    private UUID id;

    @NotNull
    @ManyToOne
    private Card card;

    @NotBlank
    private String travelDestination;

    @NotNull
    @Future
    private LocalDateTime endOfTrip;

    @NotNull
    private LocalDateTime instantNotice;

    @NotBlank
    private String ip;

    @NotBlank
    private String userAgent;

    @Deprecated
    public TravelNotice() {}

    public TravelNotice(Card card, String travelDestination, LocalDateTime endOfTrip, String ip, String userAgent) {
        this.id = UUID.randomUUID();
        this.card = card;
        this.travelDestination = travelDestination;
        this.endOfTrip = endOfTrip;
        this.instantNotice = LocalDateTime.now();
        this.ip = ip;
        this.userAgent = userAgent;
    }
}
