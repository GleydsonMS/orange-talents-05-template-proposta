package br.com.zupedu.proposal.createProposal.dtos;

import br.com.zupedu.proposal.cardsAssociation.dtos.CardResponse;
import br.com.zupedu.proposal.createProposal.entities.Proposal;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class ProposalResponse {

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String documento;
    @JsonProperty
    private String email;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String endereco;
    @JsonProperty
    private BigDecimal salario;
    @JsonProperty
    private String statusSolicitacao;
    @JsonProperty
    private CardResponse cartao;

    public ProposalResponse(Proposal proposal) {
        this.id = proposal.getId();
        this.documento = proposal.getDocument();
        this.email = proposal.getEmail();
        this.nome = proposal.getName();
        this.endereco = proposal.getAddress();
        this.salario = proposal.getSalary();
        this.statusSolicitacao = proposal.getStatus().toString();
        this.cartao = proposal.getCard() == null ? null : new CardResponse(proposal.getCard());
    }
}
