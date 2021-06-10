package br.com.zupedu.proposal.externalSystems;

public class ProposalSolicitationResponse {

    private String resultadoSolicitacao;

    @Deprecated
    public ProposalSolicitationResponse() {}

    public ProposalSolicitationResponse(String resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProposalSolicitationResponse)) return false;

        ProposalSolicitationResponse response = (ProposalSolicitationResponse) o;

        return getResultadoSolicitacao().equals(response.getResultadoSolicitacao());
    }

    @Override
    public int hashCode() {
        return getResultadoSolicitacao().hashCode();
    }
}
