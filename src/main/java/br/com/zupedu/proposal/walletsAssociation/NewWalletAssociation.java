package br.com.zupedu.proposal.walletsAssociation;

import br.com.zupedu.proposal.externalSystems.accounts.wallets.WalletAssociationRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewWalletAssociation {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String wallet;

    @Deprecated
    public NewWalletAssociation() {}

    public NewWalletAssociation(String email, String wallet) {
        this.email = email;
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public String getWallet() {
        return wallet;
    }

    public WalletAssociationRequest toModel() {
        return new WalletAssociationRequest(email, wallet);
    }
}
