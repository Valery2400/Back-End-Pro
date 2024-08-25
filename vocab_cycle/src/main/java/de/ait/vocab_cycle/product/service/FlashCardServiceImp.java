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
        return List.of();
    }

    @Override
    public FlashCard findById(int id) {
        return null;
    }

    @Override
    public FlashCard save(FlashCard flashCard) {
        return null;
    }

    @Override
    public FlashCard update(FlashCard flashCard) {
        return null;
    }

    @Override
    public void delete(FlashCard flashCard) {

    }
}
