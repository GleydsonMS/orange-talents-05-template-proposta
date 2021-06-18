package br.com.zupedu.proposal.externalSystems.accounts;

import javax.validation.constraints.NotBlank;

public class BlockRequest {

    @NotBlank
    private String sistemaResponsavel;

    @Deprecated
    public BlockRequest(){}

    public BlockRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
