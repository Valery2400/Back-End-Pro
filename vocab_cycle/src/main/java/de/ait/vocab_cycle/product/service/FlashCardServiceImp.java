package de.ait.vocab_cycle.product.service;

import de.ait.vocab_cycle.product.entity.FlashCard;
import de.ait.vocab_cycle.product.repository.FlashCardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlashCardServiceImp implements FlashCardService {

    private final FlashCardRepository flashCardRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<FlashCard> findAll() {
        return flashCardRepository.findAll()
                .stream()
                .map(flashCard -> modelMapper.map(flashCard, FlashCard.class))
                .toList();
    }

    @Override
    public FlashCard findById(Long id) {
        return findAll()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public FlashCard save(FlashCard flashCard) {
        return flashCardRepository.save(flashCard);
    }

    @Override
    public FlashCard update(FlashCard flashCard) {
        return flashCardRepository.save(flashCard);
    }

    @Override
    public void delete(FlashCard flashCard) {
        flashCardRepository.delete(flashCard);

    }
    @Override
    public void delete(Long id) {
        flashCardRepository.delete(findById(id));

    }
    @Override
    public List<FlashCard> findAllByLanguageAndTranslateLanguage(String language, String translateLanguage ) {
        return flashCardRepository.findAllByLanguageAndTranslateLanguage(String.valueOf(language), String.valueOf(translateLanguage));

    }
}
