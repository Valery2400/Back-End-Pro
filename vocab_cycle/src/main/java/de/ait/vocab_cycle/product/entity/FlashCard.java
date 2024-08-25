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


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@EqualsAndHashCode
@Builder
@ToString
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class FlashCard {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "language")
    private String language; // язык оригинала
    @Column(name = "word")
    private String word; // слово
    @Column(name = "example")
    private String example; // пример использования/фраза/example sentence
    @Column(name = "translateLanguage")
    private String translateLanguage; // язык перевода
    @Column(name = "translation")
    private String translation; // перевод
    @Column(name = "group")
    private String group; // группа карточек

}
