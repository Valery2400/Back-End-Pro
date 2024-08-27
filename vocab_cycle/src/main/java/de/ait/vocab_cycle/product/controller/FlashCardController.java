package de.ait.vocab_cycle.product.controller;

import de.ait.vocab_cycle.product.entity.FlashCard;
import de.ait.vocab_cycle.product.service.FlashCardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class FlashCardController {
    private final FlashCardService flashCardService;

    @GetMapping("/flashcards")
    public List<FlashCard> getAllFlashCards() {
        return flashCardService.findAll();
    }

    @GetMapping("/flashcards/{id}")
    public FlashCard getFlashCardById(@PathVariable(name = "id") Long id) {
        return flashCardService.findById(id);
    }

    @PostMapping("/flashcards")
    public FlashCard createFlashCard(@RequestBody FlashCard flashCard) {
        return flashCardService.save(flashCard);
    }

    @PutMapping("/flashcards/{id}")
    public FlashCard updateFlashCard(@PathVariable(name = "id") Long id, @RequestBody FlashCard flashCard) {
        return flashCardService.update(flashCard);
    }

    @DeleteMapping("/flashcards/{id}")
    public void deleteFlashCard(@PathVariable(name = "id") Long id, FlashCard flashCard) {
        flashCardService.delete(flashCard);
    }



}


