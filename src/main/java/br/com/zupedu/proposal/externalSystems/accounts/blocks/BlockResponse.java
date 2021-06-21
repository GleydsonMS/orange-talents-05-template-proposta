package br.com.zupedu.proposal.externalSystems.accounts.blocks;

import javax.validation.constraints.NotBlank;

public class BlockResponse {

    @NotBlank
    private StatusResultado resultado;

    @Deprecated
    public BlockResponse() {
    }

    public BlockResponse(StatusResultado resultado) {
        this.resultado = resultado;
    }

    public StatusResultado getResultado() {
        return resultado;
    }

    public boolean isBlocked(){
        return this.resultado.equals(StatusResultado.BLOQUEADO);
    }
}
