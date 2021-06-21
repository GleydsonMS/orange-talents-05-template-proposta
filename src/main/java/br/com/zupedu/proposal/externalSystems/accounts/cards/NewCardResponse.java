package br.com.zupedu.proposal.externalSystems.accounts.cards;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.cardsAssociation.entities.DueDate;
import br.com.zupedu.proposal.createProposal.entities.Proposal;
import br.com.zupedu.proposal.createProposal.repositories.ProposalRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class NewCardResponse {

    @NotBlank
    private String id;

    @NotNull
    private LocalDateTime emitidoEm;

    @NotBlank
    private String titular;

    @NotNull
    private BigDecimal limite;

    @NotNull
    private NewDueDateResponse vencimento;

    @NotNull
    private UUID idProposta;

    @Deprecated
    public NewCardResponse() {}

    public NewCardResponse(String id, String emitidoEm, String titular,
                           BigDecimal limite, NewDueDateResponse vencimento, String idProposta) {
        this.id = id;
        this.emitidoEm = LocalDateTime.parse(emitidoEm);
        this.titular = titular;
        this.limite = limite;
        this.vencimento = vencimento;
        this.idProposta = UUID.fromString(idProposta);
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

    public NewDueDateResponse getVencimento() {
        return vencimento;
    }

    public UUID getIdProposta() {
        return idProposta;
    }

    public Card toModel(ProposalRepository proposalRepository) {
        Proposal proposal = proposalRepository.findById(idProposta).get();
        DueDate dueDate = vencimento.toModel();
        return new Card(id, emitidoEm, titular, limite, dueDate, proposal);
    }
}
