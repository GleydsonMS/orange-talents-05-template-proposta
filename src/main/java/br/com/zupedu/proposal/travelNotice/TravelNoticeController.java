package br.com.zupedu.proposal.travelNotice;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.cardsAssociation.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
public class TravelNoticeController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TravelNoticeRepository travelNoticeRepository;

    @PostMapping("/cards/{id}/travelnotice")
    public ResponseEntity<Void> create(@Valid @PathVariable("id") @NotBlank String cardId,
                                 @Valid @RequestBody NewTravelNoticeRequest request,
                                 HttpServletRequest httpServletRequest) {

        Optional<Card> checkCard = cardRepository.findById(cardId);

        if (checkCard.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Card card = checkCard.get();

        String ip = httpServletRequest.getRemoteAddr();
        String userAgent = httpServletRequest.getHeader("User-Agent");

        TravelNotice travelNotice = request.toModel(card, ip, userAgent);
        travelNoticeRepository.save(travelNotice);

        return ResponseEntity.ok().build();
    }
}
