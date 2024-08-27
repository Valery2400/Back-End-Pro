package de.ait.vocab_cycle.product.repository;

import de.ait.vocab_cycle.product.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
    List<FlashCard> findAllByLanguageAndTranslateLanguage(String language, String translateLanguage);
    FlashCard findFlashCardByWord(String word);





};

