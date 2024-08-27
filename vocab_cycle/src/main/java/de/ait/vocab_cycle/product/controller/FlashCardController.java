package de.ait.vocab_cycle.product.controller;

import de.ait.vocab_cycle.product.entity.FlashCard;

import de.ait.vocab_cycle.product.service.FlashCardServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/flashcards")
public class FlashCardController {
    private final FlashCardServiceImp flashCardServiceImp;

    @GetMapping("")
    public List<FlashCard> getAllFlashCards() {
        return flashCardServiceImp.findAll();
    }

    @GetMapping("/{id}")
    public FlashCard getFlashCardById(@PathVariable(name = "id") Long id) {
        return flashCardServiceImp.findById(id);
    }
    @GetMapping("/search")
    public List<FlashCard> findAllByLanguageAndTranslateLanguage(
            @RequestParam(name = "lan") String language,
            @RequestParam(name ="tran") String translateLanguage) {
        return flashCardServiceImp.findAllByLanguageAndTranslateLanguage(language,translateLanguage);
    }
    @GetMapping("/search/by-word")
    public FlashCard findFlashCardByWord(
            @RequestParam(name="word",required = false) String word){
        return flashCardServiceImp.findFlashCardByWord(word);
    }


    @PostMapping("")
    public FlashCard createFlashCard(@RequestBody FlashCard flashCard) {
        return flashCardServiceImp.save(flashCard);
    }

    @PutMapping("/{id}")
    public FlashCard updateFlashCard(@PathVariable(name = "id") Long id, @RequestBody FlashCard flashCard) {
        return flashCardServiceImp.update(flashCard);
    }

    @DeleteMapping("/{id}")
    public void deleteFlashCard(@PathVariable(name = "id") Long id, FlashCard flashCard) {
        flashCardServiceImp.delete(flashCard);
    }



}


