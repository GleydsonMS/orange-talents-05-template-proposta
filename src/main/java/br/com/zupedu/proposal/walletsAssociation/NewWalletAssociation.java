package br.com.zupedu.proposal.walletsAssociation;

import br.com.zupedu.proposal.externalSystems.accounts.wallets.WalletAssociationRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewWalletAssociation {

    @NotBlank
    @Email
    private String email;

    @NotNull
    private WalletName wallet;

    @Deprecated
    public NewWalletAssociation() {}

    public NewWalletAssociation(String email, WalletName wallet) {
        this.email = email;
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public WalletName getWallet() {
        return wallet;
    }

    public WalletAssociationRequest toModel() {
        return new WalletAssociationRequest(email, wallet.toString());
    }
}
