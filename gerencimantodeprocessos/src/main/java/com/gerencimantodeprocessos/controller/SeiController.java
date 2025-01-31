package com.gerencimantodeprocessos.controller;

import com.gerencimantodeprocessos.dtos.SeiDTO;
import com.gerencimantodeprocessos.dtos.UserDTO;
import com.gerencimantodeprocessos.service.SeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sei")
public class SeiController {

    @Autowired
    private SeiService seiService;

    @PostMapping
    public SeiDTO newSei(@RequestBody SeiDTO seiDTO){
        return seiService.saveSei(seiDTO);
    }

    @GetMapping
    public List<SeiDTO> listSei(){
        return seiService.listSei();
    }

    @GetMapping("/{id}")
    public Optional<SeiDTO> findBySeiId(@PathVariable String id){
        return seiService.findByNumberSei(id);
    }
    @PutMapping("/{id}")
    public SeiDTO updateSei(@PathVariable String id,@RequestBody SeiDTO seiDto){
        return seiService.updateSei(id,seiDto);
    }
    @DeleteMapping("/{id}")
    public void deleteSei(String id){
        seiService.deleteSei(id);
    }





}
