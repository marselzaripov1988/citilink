package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Notebook extends Product{
    private String brand;
    private String model;
    public Notebook(long id, String name, int price, String brand, String model, boolean removed) {
        super(id, name, price, removed);
        this.brand = brand;
        this.model = model;

    }
}
