package com.gerenciamentodeprocessos.controller;

import com.gerenciamentodeprocessos.dtos.DocDTO;
import com.gerenciamentodeprocessos.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocController {


    private DocService docService;

    public DocController(DocService service){
        this.docService = service;
    }

    @PostMapping
    public DocDTO newDoc(@RequestBody DocDTO docDTO){
        return docService.saveDoc(docDTO);
    }

    @GetMapping
    public List<DocDTO> listSei(){
        return docService.listDoc();
    }

    @GetMapping("/id/{id}")
    public Optional<DocDTO> findById(@PathVariable String id){
        return docService.findById(id);
    }
    @PutMapping("/{id}")
    public DocDTO updateSei(@PathVariable String id, @RequestBody DocDTO docDto){
        return docService.updateDoc(id, docDto);
    }
    @DeleteMapping("/{id}")
    public void deleteSei(@PathVariable String id){
        docService.deleteDoc(id);
    }

    @GetMapping("/number/{numberSei}")
    public List<DocDTO> findByNumberSei(@PathVariable String numberSei){
        return  docService.findByNumberDoc(numberSei);
    }

}
