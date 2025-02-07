package com.gerenciamentodeprocessos.domain.item;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gerenciamentodeprocessos.domain.sei.Sei;
import com.gerenciamentodeprocessos.dtos.ItemDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "itens")
@Table(name = "itens")
@EqualsAndHashCode(of = "id")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String item;
    private String quantityPurchased;
    private String justification;
    private String budgetHeading;
    private String priorityDegree;
    private Date expectedContractStart;
    private Date expectedContractTermination;
    private Integer remainingDeadline;
    private Integer totalDurationContract;
    private Double estimatedValueForTheYear;
    private Double estimatedContractValue;
    private String type;
    private Integer contractNumber;
    private String contractingMode;
    private String termsOfReference;
    private String stateOfTheProcess;
    private String sustainabilityCriteria;
    private String slp;
    @ManyToOne()
    @JoinColumn(name = "item_id")
    @JsonBackReference
    private Sei sei;

    public Item(){

    }


    public Item(ItemDTO itemDTO) {
        this.id = itemDTO.id();
        this.item = itemDTO.item();
        this.quantityPurchased = itemDTO.quantityPurchased();
        this.justification = itemDTO.justification();
        this.budgetHeading = itemDTO.budgetHeading();
        this.priorityDegree = itemDTO.priorityDegree();
        this.expectedContractStart = itemDTO.expectedContractStart();
        this.expectedContractTermination = itemDTO.expectedContractTermination();
        this.remainingDeadline = itemDTO.remainingDeadline();
        this.totalDurationContract = itemDTO.totalDurationContract();
        this.estimatedValueForTheYear = itemDTO.estimatedValueForTheYear();
        this.estimatedContractValue = itemDTO.estimatedContractValue();
        this.type = itemDTO.type();
        this.contractNumber = itemDTO.contractNumber();
        this.contractingMode = itemDTO.contractingMode();
        this.termsOfReference = itemDTO.termsOfReference();
        this.stateOfTheProcess = itemDTO.stateOfTheProcess();
        this.sustainabilityCriteria = itemDTO.sustainabilityCriteria();
        this.slp = itemDTO.slp();

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(String quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getBudgetHeading() {
        return budgetHeading;
    }

    public void setBudgetHeading(String budgetHeading) {
        this.budgetHeading = budgetHeading;
    }

    public String getPriorityDegree() {
        return priorityDegree;
    }

    public void setPriorityDegree(String priorityDegree) {
        this.priorityDegree = priorityDegree;
    }

    public Date getExpectedContractStart() {
        return expectedContractStart;
    }

    public void setExpectedContractStart(Date expectedContractStart) {
        this.expectedContractStart = expectedContractStart;
    }

    public Date getExpectedContractTermination() {
        return expectedContractTermination;
    }

    public void setExpectedContractTermination(Date expectedContractTermination) {
        this.expectedContractTermination = expectedContractTermination;
    }

    public Integer getRemainingDeadline() {
        return remainingDeadline;
    }

    public void setRemainingDeadline(Integer remainingDeadline) {
        this.remainingDeadline = remainingDeadline;
    }

    public Integer getTotalDurationContract() {
        return totalDurationContract;
    }

    public void setTotalDurationContract(Integer totalDurationContract) {
        this.totalDurationContract = totalDurationContract;
    }

    public Double getEstimatedValueForTheYear() {
        return estimatedValueForTheYear;
    }

    public void setEstimatedValueForTheYear(Double estimatedValueForTheYear) {
        this.estimatedValueForTheYear = estimatedValueForTheYear;
    }

    public Double getEstimatedContractValue() {
        return estimatedContractValue;
    }

    public void setEstimatedContractValue(Double estimatedContractValue) {
        this.estimatedContractValue = estimatedContractValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractingMode() {
        return contractingMode;
    }

    public void setContractingMode(String contractingMode) {
        this.contractingMode = contractingMode;
    }

    public String getTermsOfReference() {
        return termsOfReference;
    }

    public void setTermsOfReference(String termsOfReference) {
        this.termsOfReference = termsOfReference;
    }

    public String getStateOfTheProcess() {
        return stateOfTheProcess;
    }

    public void setStateOfTheProcess(String stateOfTheProcess) {
        this.stateOfTheProcess = stateOfTheProcess;
    }

    public String getSustainabilityCriteria() {
        return sustainabilityCriteria;
    }

    public void setSustainabilityCriteria(String sustainabilityCriteria) {
        this.sustainabilityCriteria = sustainabilityCriteria;
    }

    public String getSlp() {
        return slp;
    }

    public void setSlp(String slp) {
        this.slp = slp;
    }

    public Sei getSei() {
        return sei;
    }

    public void setSei(Sei sei) {
        this.sei = sei;
    }
}
