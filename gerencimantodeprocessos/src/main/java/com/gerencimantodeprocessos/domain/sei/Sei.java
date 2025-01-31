package com.gerencimantodeprocessos.domain.sei;

import com.gerencimantodeprocessos.domain.user.User;
import com.gerencimantodeprocessos.dtos.SeiDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "seis")
@Table(name = "seis")
@EqualsAndHashCode(of = "id")
public class Sei {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Long numberSei;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Sei(){

    }

    public Sei(String id, Long numberSei,User user){
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

    public Long getNumberSei() {
        return numberSei;
    }

    public void setNumberSei(Long numberSei) {
        this.numberSei = numberSei;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
