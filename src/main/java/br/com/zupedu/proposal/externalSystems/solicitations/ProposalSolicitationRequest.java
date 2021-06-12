package br.com.zupedu.proposal.externalSystems.solicitations;

import br.com.zupedu.proposal.createProposal.entities.Proposal;
import br.com.zupedu.proposal.validators.CPForCNPJ;

import javax.validation.constraints.NotBlank;

public class ProposalSolicitationRequest {

    @NotBlank
    @CPForCNPJ
    private String documento;

    @NotBlank
    private String nome;

    @NotBlank
    private String idProposta;

    @Deprecated
    public ProposalSolicitationRequest() {}

    public  ProposalSolicitationRequest(Proposal proposal) {
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
