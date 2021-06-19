package br.com.zupedu.proposal.travelNotice;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class NewTravelNoticeRequest {

    @NotBlank
    private String travelDestination;

    @NotNull
    @Future
    private LocalDateTime endOfTrip;

    @Deprecated
    public NewTravelNoticeRequest() {}

    public NewTravelNoticeRequest(String travelDestination, String endOfTrip) {
        this.travelDestination = travelDestination;
        this.endOfTrip = LocalDateTime.parse(endOfTrip);
    }

    public String getTravelDestination() {
        return travelDestination;
    }

    public LocalDateTime getEndOfTrip() {
        return endOfTrip;
    }

    public TravelNotice toModel(Card card, String ip, String userAgent) {
        return new TravelNotice(card, travelDestination, endOfTrip, ip, userAgent);
    }
}
