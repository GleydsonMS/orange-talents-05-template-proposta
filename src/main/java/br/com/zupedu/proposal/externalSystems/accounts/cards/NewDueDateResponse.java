package br.com.zupedu.proposal.externalSystems.accounts.cards;

import br.com.zupedu.proposal.cardsAssociation.entities.DueDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class NewDueDateResponse {

    @NotBlank
    private String id;

    @NotNull
    private Integer dia;

    @NotNull
    private LocalDateTime dataDeCriacao;

    @Deprecated
    public NewDueDateResponse() {}

    public NewDueDateResponse(String id, Integer dia, String dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = LocalDateTime.parse(dataDeCriacao);
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public DueDate toModel() {
        return new DueDate(id, dia, dataDeCriacao);
    }
}
