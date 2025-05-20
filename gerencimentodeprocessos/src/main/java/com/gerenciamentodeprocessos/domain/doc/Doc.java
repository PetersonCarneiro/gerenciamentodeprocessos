package com.gerenciamentodeprocessos.domain.doc;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gerenciamentodeprocessos.domain.item.Item;
import com.gerenciamentodeprocessos.domain.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "docs")
@Table(name = "docs")
@EqualsAndHashCode(of = "id")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer cod;
    private String competentUnit;
    private String requestingUnit;
    private Double investiment;
    private Integer codPdm;
    private Integer catmat;
    private Integer catser;
    private Integer codSubClassCnae;
    private String descriptionCnae;
    private String object;
    private String numberSei;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "doc",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item> items = new ArrayList<>();
    @Version
    private Integer version;

    public Doc(){
    }

    public Doc(String id,
               Integer cod,
               String competentUnit,
               String requestingUnit,
               Double investiment,
               Integer codPdm,
               Integer catmat,
               Integer catser,
               Integer codSubClassCnae,
               String descriptionCnae,
               String object,
               String numberSei) {
        this.id = id;
        this.cod = cod;
        this.competentUnit = competentUnit;
        this.requestingUnit = requestingUnit;
        this.investiment = investiment;
        this.codPdm = codPdm;
        this.catmat = catmat;
        this.catser = catser;
        this.codSubClassCnae = codSubClassCnae;
        this.descriptionCnae = descriptionCnae;
        this.object = object;
        this.numberSei = numberSei;
    }

    public Doc(String id,
               Integer cod,
               String competentUnit,
               String requestingUnit,
               Double investiment,
               Integer codPdm,
               Integer catmat,
               Integer catser,
               Integer codSubClassCnae,
               String descriptionCnae,
               String object,
               String numberSei,
               User user,
               List<Item> item) {
        this.id = id;
        this.cod = cod;
        this.competentUnit = competentUnit;
        this.requestingUnit = requestingUnit;
        this.investiment = investiment;
        this.codPdm = codPdm;
        this.catmat = catmat;
        this.catser = catser;
        this.codSubClassCnae = codSubClassCnae;
        this.descriptionCnae = descriptionCnae;
        this.object = object;
        this.numberSei = numberSei;
        this.user = user;
        this.items = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getCompetentUnit() {
        return competentUnit;
    }

    public void setCompetentUnit(String competentUnit) {
        this.competentUnit = competentUnit;
    }

    public String getRequestingUnit() {
        return requestingUnit;
    }

    public void setRequestingUnit(String requestingUnit) {
        this.requestingUnit = requestingUnit;
    }

    public Double getInvestiment() {
        return investiment;
    }

    public void setInvestiment(Double investiment) {
        this.investiment = investiment;
    }

    public Integer getCodPdm() {
        return codPdm;
    }

    public void setCodPdm(Integer codPdm) {
        this.codPdm = codPdm;
    }

    public Integer getCatmat() {
        return catmat;
    }

    public void setCatmat(Integer catmat) {
        this.catmat = catmat;
    }

    public Integer getCatser() {
        return catser;
    }

    public void setCatser(Integer catser) {
        this.catser = catser;
    }

    public Integer getCodSubClassCnae() {
        return codSubClassCnae;
    }

    public void setCodSubClassCnae(Integer codSubClassCnae) {
        this.codSubClassCnae = codSubClassCnae;
    }

    public String getDescriptionCnae() {
        return descriptionCnae;
    }

    public void setDescriptionCnae(String descriptionCnae) {
        this.descriptionCnae = descriptionCnae;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getNumberSei() {
        return numberSei;
    }

    public void setNumberSei(String numberSei) {
        this.numberSei = numberSei;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
