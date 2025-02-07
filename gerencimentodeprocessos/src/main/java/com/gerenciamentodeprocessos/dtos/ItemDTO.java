package com.gerenciamentodeprocessos.dtos;

import com.gerenciamentodeprocessos.domain.sei.Sei;

import java.util.Date;

public record ItemDTO(String id,
                      String item,
                      String quantityPurchased,
                      String justification,
                      String budgetHeading,
                      String priorityDegree,
                      Date expectedContractStart,
                      Date expectedContractTermination,
                      Integer remainingDeadline,
                      Integer totalDurationContract,
                      Double estimatedValueForTheYear,
                      Double estimatedContractValue,
                      String type,
                      Integer contractNumber,
                      String contractingMode,
                      String termsOfReference,
                      String stateOfTheProcess,
                      String sustainabilityCriteria,
                      String slp,
                      Sei sei) {

}
