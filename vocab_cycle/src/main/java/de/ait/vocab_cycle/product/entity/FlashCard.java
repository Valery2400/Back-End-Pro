package de.ait.vocab_cycle.product.entity;
//Система для повторения слов иностранного языка.
//Давайте напишем сущность “Карточка слова”: В ней должны быть следующие поля:
//        ID,
//        String language (язык оригинала),
//        String word (слово),
//        String example (пример использования/фраза),
//        String translateLanguage (язык перевода),
//        String translation (перевод),
//        String group (группа карточек)
//        Вам необходимо написать API (по примеру того, как сделано на занятии),
//        которая позволяет отобразить все карточки и добавить новую карточка,
//        вывести карточку по id.


import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@Builder
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "flashcard")
public class FlashCard {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "language")
    private String language; // язык оригинала
    @Column(name = "word")
    private String word; // слово
    @Column(name = "example")
    private String example; // пример использования/фраза/example sentence
    @Column(name = "translate_language")
    private String translateLanguage; // язык перевода
    @Column(name = "translation")
    private String translation; // перевод
    @Column(name = "grouppe")
    private String grouppe; // группа карточек

}
