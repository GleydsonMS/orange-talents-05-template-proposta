package br.com.zupedu.proposal.externalSystems.accounts.wallets;

import javax.validation.constraints.NotBlank;

public class WalletAssociationResponse {

    @NotBlank
    private ResultadoCarteira resultado;

    @NotBlank
    private String id;

    @Deprecated
    public WalletAssociationResponse() {}

    public WalletAssociationResponse(ResultadoCarteira resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }

    public ResultadoCarteira getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }
}
