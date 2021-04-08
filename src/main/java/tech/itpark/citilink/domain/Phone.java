package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone extends Product{
    private String model;
    private String brand;
    public Phone(long id, String name, int price, String brand, String model, boolean removed) {
        super(id, name, price, removed);
        this.brand = brand;
        this.model = model;
    }
}
