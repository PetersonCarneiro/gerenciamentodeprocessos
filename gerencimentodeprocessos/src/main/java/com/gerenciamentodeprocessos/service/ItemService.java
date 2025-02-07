package com.gerenciamentodeprocessos.service;

import com.gerenciamentodeprocessos.domain.item.Item;
import com.gerenciamentodeprocessos.domain.sei.Sei;
import com.gerenciamentodeprocessos.dtos.ItemDTO;
import com.gerenciamentodeprocessos.repositories.ItemRepository;
import com.gerenciamentodeprocessos.repositories.SeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SeiRepository seiRepository;

    private ItemDTO convertDTO(Item item){
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
                item.getSei()
        );
    }

    public ItemDTO saveItem(ItemDTO itemDTO){
        Item item = new Item(itemDTO);
        return convertDTO(itemRepository.save(item));
    }
/*
    public ItemDTO saveItem(String id, ItemDTO itemDTO){
        Sei sei = seiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        Item item = new Item(itemDTO, sei);
        return convertDTO(itemRepository.save(item));
    }

*/
    public List<ItemDTO> listItem(){
        return itemRepository.findAll().stream()
                .map(this::convertDTO).toList();
    }


    public Optional<ItemDTO> findByIdItem(String id){
        return itemRepository.findById(id)
                .map(this::convertDTO);
    }


    public ItemDTO updateItem(String id, ItemDTO itemDTO){
        return itemRepository.findById(id).map(item -> {
                            item.setId(itemDTO.id());
                            item.setItem(itemDTO.item());
                            item.setQuantityPurchased(itemDTO.quantityPurchased());
                            item.setJustification(itemDTO.justification());
                            item.setBudgetHeading(itemDTO.budgetHeading());
                            item.setPriorityDegree(itemDTO.priorityDegree());
                            item.setExpectedContractStart(itemDTO.expectedContractStart());
                            item.setExpectedContractTermination(itemDTO.expectedContractTermination());
                            item.setRemainingDeadline(itemDTO.remainingDeadline());
                            item.setTotalDurationContract(itemDTO.totalDurationContract());
                            item.setEstimatedValueForTheYear(itemDTO.estimatedValueForTheYear());
                            item.setEstimatedContractValue(itemDTO.estimatedContractValue());
                            item.setType(itemDTO.type());
                            item.setContractNumber(itemDTO.contractNumber());
                            item.setContractingMode(itemDTO.contractingMode());
                            item.setTermsOfReference(itemDTO.termsOfReference());
                            item.setStateOfTheProcess(itemDTO.stateOfTheProcess());
                            item.setSustainabilityCriteria(itemDTO.sustainabilityCriteria());
                            item.setSlp(itemDTO.slp());
                            item.setSei(itemDTO.sei());

                            return convertDTO(itemRepository.save(item));
                })
                .orElseThrow(()-> new RuntimeException("Item not found"));
    }


    public void deleteItem(String id){
        if(!itemRepository.existsById(id)){
            throw new RuntimeException("Item not found");
        }
        itemRepository.deleteById(id);
    }
}
