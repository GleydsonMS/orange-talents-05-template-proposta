package br.com.zupedu.proposal.biometrics;

import br.com.zupedu.proposal.cardsAssociation.entities.Card;
import br.com.zupedu.proposal.validators.IsBase64;

import javax.validation.constraints.NotBlank;

public class NewBiometryRequest {

    @NotBlank
    @IsBase64
    private String fingerprint;

    @Deprecated
    public NewBiometryRequest() {}

    public NewBiometryRequest(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public Biometry toModel(Card card) {
        return new Biometry(fingerprint, card);
    }
}
