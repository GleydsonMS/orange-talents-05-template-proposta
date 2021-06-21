package br.com.zupedu.proposal.externalSystems.accounts.travels;

import javax.validation.constraints.NotBlank;

public class TravelNoticeRequest {

    @NotBlank
    private String destino;

    @NotBlank
    private String validoAte;

    @Deprecated
    public TravelNoticeRequest() {}

    public TravelNoticeRequest(String destino, String validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public String getValidoAte() {
        return validoAte;
    }
}
