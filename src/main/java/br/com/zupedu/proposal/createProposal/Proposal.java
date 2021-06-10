package br.com.zupedu.proposal.createProposal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Proposal {

    @Id
    private UUID id;

    @NotBlank
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

    @Enumerated(EnumType.STRING)
    private StatusSolicitation status;

    @Deprecated
    public Proposal() {};

    public Proposal(@NotBlank String document,
                    @NotBlank @Email String email,
                    @NotBlank String name,
                    @NotBlank String address,
                    @NotNull @Positive BigDecimal salary) {
        this.id = UUID.randomUUID();
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public void setStatus(StatusSolicitation status) {
        this.status = status;
    }
}
