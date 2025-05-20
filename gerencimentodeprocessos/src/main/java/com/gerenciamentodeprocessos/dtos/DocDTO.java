package com.gerenciamentodeprocessos.dtos;

public record DocDTO(String id,
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
                     String numberSei
                     //User user,
                     //List<Item> item
) {
}