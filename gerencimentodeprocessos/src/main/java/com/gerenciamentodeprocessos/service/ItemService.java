package com.gerenciamentodeprocessos.service;

import com.gerenciamentodeprocessos.domain.doc.Doc;
import com.gerenciamentodeprocessos.domain.item.Item;
import com.gerenciamentodeprocessos.dtos.ItemDTO;
import com.gerenciamentodeprocessos.mapper.ItemMapper;
import com.gerenciamentodeprocessos.repositories.ItemRepository;
import com.gerenciamentodeprocessos.repositories.DocRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private DocRepository docRepository;
    private ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, DocRepository docRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.docRepository = docRepository;
        this.itemMapper = itemMapper;
    }


    public ItemDTO saveItem(ItemDTO itemDTO) {
        if (itemDTO.documentId()== null || itemDTO.documentId().isEmpty()) {
            throw new RuntimeException("Document ID is required");
        }

        Doc doc = docRepository.findById(itemDTO.documentId())
                .orElseThrow(() -> new RuntimeException("Document not found"));

        Item item = itemMapper.toEntity(itemDTO);
        item.setDoc(doc);

        return itemMapper.toDTO(itemRepository.save(item));
    }



    public List<ItemDTO> listItem() {
        return itemRepository.findAll().stream()
                .map(itemMapper::toDTO).toList();
    }


    public Optional<ItemDTO> findByIdItem(String id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDTO);
    }


    public ItemDTO updateItem(String id, String docId, ItemDTO itemDTO) {

        Doc doc = docRepository.findById(docId)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

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
        item.setDoc(doc);

        return itemMapper.toDTO(itemRepository.save(item));


    }


    public void deleteItem(String id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found");
        }
        itemRepository.deleteById(id);
    }
}
