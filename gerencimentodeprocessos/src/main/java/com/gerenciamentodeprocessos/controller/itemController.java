package com.gerenciamentodeprocessos.controller;

import com.gerenciamentodeprocessos.dtos.ItemDTO;
import com.gerenciamentodeprocessos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class itemController {

    @Autowired
    private ItemService itemService;

    //Salvar
    @PostMapping()
    public ResponseEntity<ItemDTO> createItem(@PathVariable String docId, @RequestBody ItemDTO itemDTO) {
        ItemDTO saveItem = itemService.saveItem(docId, itemDTO);
        return ResponseEntity.status(201).body(saveItem);
    }

    //Retorna todos
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = itemService.listItem();
        return ResponseEntity.ok(items);
    }

    //Retorna um item pelo id
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable String id) {
        Optional<ItemDTO> itemDTO = itemService.findByIdItem(id);
        return itemDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Altera o item
    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable String id, @PathVariable String docId, @RequestBody ItemDTO itemDTO) {

        ItemDTO updatedItem = itemService.updateItem(id, docId, itemDTO);

        return ResponseEntity.ok(updatedItem);
    }

    //Deleta o item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }

}
