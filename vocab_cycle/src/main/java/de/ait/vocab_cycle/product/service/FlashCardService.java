package de.ait.vocab_cycle.product.service;

import de.ait.vocab_cycle.product.entity.FlashCard;

import java.util.List;

public interface FlashCardService {
    List<FlashCard> findAll();
    FlashCard findById(Long id);
    FlashCard save(FlashCard flashCard);
    FlashCard update(FlashCard flashCard);
    void delete(FlashCard flashCard);

}
