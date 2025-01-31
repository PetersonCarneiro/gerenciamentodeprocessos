package com.gerencimantodeprocessos.service;

import com.gerencimantodeprocessos.domain.sei.Sei;
import com.gerencimantodeprocessos.domain.user.User;
import com.gerencimantodeprocessos.dtos.SeiDTO;
import com.gerencimantodeprocessos.dtos.UserDTO;
import com.gerencimantodeprocessos.repositories.SeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SeiService {
    @Autowired
    private SeiRepository seiRepository;

    public SeiDTO saveSei(SeiDTO seiDTO){
        Sei sei = new Sei(seiDTO);
        Sei newSei = seiRepository.save(sei);
        return new SeiDTO(
                newSei.getId(),
                newSei.getNumberSei(),
                newSei.getUser()
        );

    }

    public List<SeiDTO> listSei(){
        return seiRepository.findAll().stream().map(sei ->
                new SeiDTO(
                        sei.getId(),
                        sei.getNumberSei(),
                        sei.getUser())
        ).toList();
    }

    public Optional<SeiDTO> findByNumberSei(String id){
        return seiRepository.findById(id).map(sei->
                new SeiDTO(
                        sei.getId(),
                        sei.getNumberSei(),
                        sei.getUser()
                )
        );
    }

    public SeiDTO updateSei(String id, SeiDTO seiDTO){
        return seiRepository.findById(id).map(sei -> {
            sei.setId(seiDTO.id());
            sei.setNumberSei(seiDTO.numberSei());
            sei.setUser(seiDTO.user());
            Sei updateSei = seiRepository.save(sei);
            return new SeiDTO(
                    updateSei.getId(),
                    updateSei.getNumberSei(),
                    updateSei.getUser());
        }).orElseThrow(()-> new RuntimeException("Sei not found"));
    }

    public void deleteSei(String id){
        seiRepository.deleteById(id);
    }

}
