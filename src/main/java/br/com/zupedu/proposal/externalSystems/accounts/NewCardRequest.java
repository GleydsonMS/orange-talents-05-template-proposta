package br.com.zupedu.proposal.externalSystems.accounts;

import br.com.zupedu.proposal.createProposal.entities.Proposal;

import javax.validation.constraints.NotBlank;

public class NewCardRequest {

    @NotBlank
    private String documento;

    @NotBlank
    private String nome;

    @NotBlank
    private String idProposta;

    @Deprecated
    public NewCardRequest() {}

    public NewCardRequest(Proposal proposal) {
        this.documento = proposal.getDocument();
        this.nome = proposal.getName();
        this.idProposta = proposal.getId().toString();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
