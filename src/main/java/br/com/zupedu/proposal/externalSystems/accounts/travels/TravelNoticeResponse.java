package br.com.zupedu.proposal.externalSystems.accounts.travels;

public class TravelNoticeResponse {

    private ResultadoAvisoViagem resultado;

    @Deprecated
    public TravelNoticeResponse() {}

    public TravelNoticeResponse(ResultadoAvisoViagem resultado) {
        this.resultado = resultado;
    }

    public ResultadoAvisoViagem getResultado() {
        return resultado;
    }
}
