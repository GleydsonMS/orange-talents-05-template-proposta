package br.com.zupedu.proposal.cardsAssociation.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class DueDate {

    @Id
    private String id;

    @NotNull
    private Integer day;

    @NotNull
    private LocalDateTime createdDate;

    @Deprecated
    public DueDate() {}

    public DueDate(String id, Integer day, LocalDateTime createdDate) {
        this.id = id;
        this.day = day;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public Integer getDay() {
        return day;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
