package br.com.zupedu.proposal.travelNotice;

import br.com.zupedu.proposal.externalSystems.accounts.AccountsIntegration;
import br.com.zupedu.proposal.externalSystems.accounts.travels.ResultadoAvisoViagem;
import br.com.zupedu.proposal.externalSystems.accounts.travels.TravelNoticeRequest;
import br.com.zupedu.proposal.externalSystems.accounts.travels.TravelNoticeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;

@Component
public class SendTravelNotice {

    @Autowired
    private AccountsIntegration accountsIntegration;

    public void execute(TravelNotice travelNotice) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String id = travelNotice.getCard().getId();
        String destino = travelNotice.getTravelDestination();
        String validoAte = travelNotice.getEndOfTrip().format(formatter);
        TravelNoticeRequest request = new TravelNoticeRequest(destino, validoAte);

        try {
            TravelNoticeResponse response = accountsIntegration.SendTravelNotice(id, request);
            if(!response.getResultado().equals(ResultadoAvisoViagem.CRIADO)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
