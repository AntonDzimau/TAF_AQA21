package models;


import lombok.*;
//добавляет геттеры
@Getter
//добавляет сеттеры
@Setter
//исключаем параметр из метода тустринг
@ToString (exclude = "id")
//исключаем параметр из сравнения
@EqualsAndHashCode(exclude = "id")
//добавляет конструктор без аргументов
@NoArgsConstructor
//добавляет коструктор со всеми аргументами
@AllArgsConstructor
//содержит геттеры, сеттеры, тустринг, иквалс и хэшкод, но тут нет эксклюдов
@Data
//если уж очень нужно что-то все-таки исключить, можно после @Data
//просто добавляем доп аннотацию, в которую включаем исключения
public class Milestone {
    private int id;
    private String name;
    private String references;
    private String description;
    private boolean completed;
}
