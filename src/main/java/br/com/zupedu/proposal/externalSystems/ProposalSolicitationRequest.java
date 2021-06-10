package br.com.zupedu.proposal.externalSystems;

import br.com.zupedu.proposal.createProposal.Proposal;

public class ProposalSolicitationRequest {

    private String documento;
    private String nome;
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
