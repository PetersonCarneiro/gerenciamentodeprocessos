package com.gerenciamentodeprocessos.mapper;

import com.gerenciamentodeprocessos.domain.doc.Doc;
import com.gerenciamentodeprocessos.dtos.DocDTO;
import org.springframework.stereotype.Component;

@Component
public class DocMapper {

    public Doc toEntity(DocDTO docDTO){
        return new Doc(
                docDTO.id(),
                docDTO.cod(),
                docDTO.competentUnit(),
                docDTO.requestingUnit(),
                docDTO.investiment(),
                docDTO.codPdm(),
                docDTO.catmat(),
                docDTO.catser(),
                docDTO.codSubClassCnae(),
                docDTO.descriptionCnae(),
                docDTO.object(),
                docDTO.numberSei()
                //docDTO.user(),
                //docDTO.item()
        );
    }

    public DocDTO toDTO(Doc doc){
        return new DocDTO(
                doc.getId(),
                doc.getCod(),
                doc.getCompetentUnit(),
                doc.getRequestingUnit(),
                doc.getInvestiment(),
                doc.getCodPdm(),
                doc.getCatmat(),
                doc.getCatser(),
                doc.getCodSubClassCnae(),
                doc.getDescriptionCnae(),
                doc.getObject(),
                doc.getNumberSei()
                //doc.getUser(),
                //doc.getItems()
        );

    }
}
