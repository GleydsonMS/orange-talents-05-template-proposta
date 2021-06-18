package br.com.zupedu.proposal.cardBlocking;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.cardsAssociation.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class CardBlockingController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BlockadeRepository blockadeRepository;

    @Autowired
    private SendCardBlocked sendCardBlocked;

    @PostMapping("/cards/{id}/blocking")
    public ResponseEntity<Void> createBloking(@PathVariable("id") String cardId,
                                              HttpServletRequest request) {

        Optional<Card> checkCardExists = cardRepository.findById(cardId);

        if (checkCardExists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Card card = checkCardExists.get();

        if (card.isBlocked()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        sendCardBlocked.execute(card);

        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        Blockade blockade = new Blockade(card, ip, userAgent);

        blockadeRepository.save(blockade);

        return ResponseEntity.ok().build();
    }
}
