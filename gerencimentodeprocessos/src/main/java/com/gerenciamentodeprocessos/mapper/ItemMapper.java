package com.gerenciamentodeprocessos.mapper;

import com.gerenciamentodeprocessos.domain.item.Item;
import com.gerenciamentodeprocessos.dtos.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item toEntity(ItemDTO dto){
        return new Item(
                null,
                dto.item(),
                dto.quantityPurchased(),
                dto.justification(),
                dto.budgetHeading(),
                dto.priorityDegree(),
                dto.expectedContractStart(),
                dto.expectedContractTermination(),
                dto.remainingDeadline(),
                dto.totalDurationContract(),
                dto.estimatedValueForTheYear(),
                dto.estimatedContractValue(),
                dto.type(),
                dto.contractNumber(),
                dto.contractingMode(),
                dto.termsOfReference(),
                dto.stateOfTheProcess(),
                dto.sustainabilityCriteria(),
                dto.slp(),
                dto.doc());
    }

    public ItemDTO toDTO(Item item){
        return new ItemDTO(
                item.getId(),
                item.getItem(),
                item.getQuantityPurchased(),
                item.getJustification(),
                item.getBudgetHeading(),
                item.getPriorityDegree(),
                item.getExpectedContractStart(),
                item.getExpectedContractTermination(),
                item.getRemainingDeadline(),
                item.getTotalDurationContract(),
                item.getEstimatedValueForTheYear(),
                item.getEstimatedContractValue(),
                item.getType(),
                item.getContractNumber(),
                item.getContractingMode(),
                item.getTermsOfReference(),
                item.getStateOfTheProcess(),
                item.getSustainabilityCriteria(),
                item.getSlp(),
                item.getDoc()
        );
    }
}
