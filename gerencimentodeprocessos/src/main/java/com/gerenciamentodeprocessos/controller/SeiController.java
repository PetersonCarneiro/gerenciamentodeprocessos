package com.gerenciamentodeprocessos.controller;

import com.gerenciamentodeprocessos.dtos.SeiDTO;
import com.gerenciamentodeprocessos.service.SeiService;
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

    @GetMapping("/id/{id}")
    public Optional<SeiDTO> findById(@PathVariable String id){
        return seiService.findById(id);
    }
    @PutMapping("/{id}")
    public SeiDTO updateSei(@PathVariable String id,@RequestBody SeiDTO seiDto){
        return seiService.updateSei(id,seiDto);
    }
    @DeleteMapping("/{id}")
    public void deleteSei(@PathVariable String id){
        seiService.deleteSei(id);
    }

    @GetMapping("/number/{numberSei}")
    public List<SeiDTO> findByNumberSei(@PathVariable String numberSei){
        return  seiService.findByNumberSei(numberSei);
    }

}
