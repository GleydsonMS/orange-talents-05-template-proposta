package br.com.zupedu.proposal.walletsAssociation;

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
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class WalletAssociationController {

    @Autowired
    private SendWalletAssociation sendWalletAssociation;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private WalletRepository walletRepository;

    @PostMapping("/cards/{id}/wallets")
    public ResponseEntity<Void> createWalletAssociation(@PathVariable("id") String cardId,
                                                        @RequestBody @Valid NewWalletAssociation request,
                                                        UriComponentsBuilder builder) {

        Optional<Card> card = cardRepository.findById(cardId);

        if(card.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Wallet wallet = sendWalletAssociation.execute(card.get(), request);

        Optional<Wallet> checkWallet = walletRepository.findByCardAndWallet(wallet.getCard(), wallet.getWallet());

        if(checkWallet.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        walletRepository.save(wallet);

        URI uri = builder.path("/cards/{id}/wallets/{walletId}").build(cardId, wallet.getId());

        return ResponseEntity.created(uri).build();
    }
}
