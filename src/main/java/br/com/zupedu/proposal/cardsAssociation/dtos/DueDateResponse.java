package br.com.zupedu.proposal.cardsAssociation.dtos;

import br.com.zupedu.proposal.cardsAssociation.entities.DueDate;

import java.time.LocalDateTime;

public class DueDateResponse {

    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    @Deprecated
    public DueDateResponse() {}

    public DueDateResponse(DueDate dueDate) {
        this.id = dueDate.getId();
        this.dia = dueDate.getDay();
        this.dataDeCriacao = dueDate.getCreatedDate();
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
}
