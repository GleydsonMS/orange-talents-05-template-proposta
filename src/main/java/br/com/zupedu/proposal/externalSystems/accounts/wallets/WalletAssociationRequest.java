package br.com.zupedu.proposal.externalSystems.accounts.wallets;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class WalletAssociationRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String carteira;

    @Deprecated
    public WalletAssociationRequest() {}

    public WalletAssociationRequest(String email, String carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }
}
