package com.gerenciamentodeprocessos.service;

import com.gerenciamentodeprocessos.domain.doc.Doc;
import com.gerenciamentodeprocessos.dtos.DocDTO;
import com.gerenciamentodeprocessos.mapper.DocMapper;
import com.gerenciamentodeprocessos.repositories.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class DocService {

    private DocRepository docRepository;
    private DocMapper docMapper;

    public DocService(DocRepository repository, DocMapper mapper){
        this.docRepository = repository;
        this.docMapper = mapper;
    }

    public DocDTO saveDoc(DocDTO docDTO){
        Doc doc = new Doc(docDTO);
        return  docMapper.toDTO(docRepository.save(doc));
    }

    public List<DocDTO> listDoc(){
        return docRepository.findAll().stream().map(docMapper::toDTO).toList();
    }

    public Optional<DocDTO> findById(String id){
        return docRepository.findById(id).map(docMapper::toDTO);
    }

    public DocDTO updateDoc(String id, DocDTO docDTO){
        Doc doc = docRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Document not found"));

        doc.setCod(docDTO.cod());
        doc.setRequestingUnit(docDTO.requestingUnit());
        doc.setInvestiment(docDTO.investiment());
        doc.setCodPdm(docDTO.codPdm());
        doc.setCatmat(docDTO.catmat());
        doc.setCatser(docDTO.catser());
        doc.setCodSubClassCnae(docDTO.codSubClassCnae());
        doc.setDescriptionCnae(docDTO.descriptionCnae());
        doc.setObject(docDTO.object());
        doc.setNumberSei(docDTO.numberSei());
        doc.setUser(docDTO.user());
        doc.setItems(docDTO.item());

        return docMapper.toDTO(docRepository.save(doc));
    }

    public void deleteDoc(String id){
        docRepository.deleteById(id);
    }

    //Regra de negócio
    public List<DocDTO> findByNumberDoc(String numberSei){
        return docRepository.findByNumberSei(numberSei).stream().map(docMapper::toDTO).toList();
    }

}
