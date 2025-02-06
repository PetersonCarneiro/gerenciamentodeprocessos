package com.gerenciamentodeprocessos.domain.sei;

import com.gerenciamentodeprocessos.domain.user.User;
import com.gerenciamentodeprocessos.dtos.SeiDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity(name = "seis")
@Table(name = "seis")
@EqualsAndHashCode(of = "id")
public class Sei {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String numberSei;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Sei(){

    }

    public Sei(String id, String numberSei, User user){
        this.id = id;
        this.numberSei = numberSei;
        this.user=user;
    }

    public Sei(SeiDTO seiDTO){
        this.id= seiDTO.id();
        this.numberSei = seiDTO.numberSei();
        this.user = seiDTO.user();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
