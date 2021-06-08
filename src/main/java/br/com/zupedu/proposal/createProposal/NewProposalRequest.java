package br.com.zupedu.proposal.createProposal;

import br.com.zupedu.proposal.validators.CPForCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NewProposalRequest {

    @NotBlank
    @CPForCNPJ
    private String document;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    @Positive
    private BigDecimal salary;

    public NewProposalRequest(@NotBlank String document,
                              @NotBlank @Email String email,
                              @NotBlank String name,
                              @NotBlank String address,
                              @NotNull @Positive BigDecimal salary) {
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Proposal toModel() {
        return new Proposal(document, email, name, address, salary);
    }
}
