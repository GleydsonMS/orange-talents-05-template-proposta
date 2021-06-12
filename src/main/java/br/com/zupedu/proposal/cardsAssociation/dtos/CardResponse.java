package br.com.zupedu.proposal.cardsAssociation.dtos;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CardResponse {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private BigDecimal limite;
    private DueDateResponse vencimento;
    private UUID idProposta;

    @Deprecated
    public CardResponse() {}

    public CardResponse(Card card) {
        this.id = card.getId();
        this.emitidoEm = card.getIssuedOn();
        this.titular = card.getHolder();
        this.limite = card.getCreditLimit();
        this.vencimento = new DueDateResponse(card.getDueDate());
        this.idProposta = card.getProposal().getId();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public DueDateResponse getVencimento() {
        return vencimento;
    }

    public UUID getIdProposta() {
        return idProposta;
    }
}
