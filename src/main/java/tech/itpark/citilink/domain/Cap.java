package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter // будет генерировать геттеры
@Setter // будет генерировать сеттеры
public class Cap extends Product {
    private String color;
    private String size;

    public Cap(long id, String name, int price, String color, String size, boolean removed) {
        super(id, name, price, removed);
        this.color = color;
        this.size = size;
    }
}
