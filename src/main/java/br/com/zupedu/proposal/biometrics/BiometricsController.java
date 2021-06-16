package br.com.zupedu.proposal.biometrics;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.cardsAssociation.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class BiometricsController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired BiometryRepository biometryRepository;

    @PostMapping("/cards/{id}/biometrics")
    public ResponseEntity<Void> create(@PathVariable("id") String cardId,
                                       @Valid @RequestBody NewBiometryRequest biometryRequest,
                                       UriComponentsBuilder uriComponentsBuilder){
        Optional<Card> card = cardRepository.findById(cardId);

        if(card.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Biometry biometry = biometryRequest.toModel(card.get());
        biometryRepository.save(biometry);

        URI identifier = uriComponentsBuilder.path("/cards/{cardId}/biometrics/{id}").build(cardId, biometry.getId());

        return ResponseEntity.created(identifier).build();
    }
}
