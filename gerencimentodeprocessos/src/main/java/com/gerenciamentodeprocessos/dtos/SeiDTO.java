package com.gerenciamentodeprocessos.dtos;

import com.gerenciamentodeprocessos.domain.sei.Sei;
import com.gerenciamentodeprocessos.domain.user.User;

public record SeiDTO (String id,
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
                      User user


){


}