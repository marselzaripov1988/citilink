package tech.itpark.citilink.manager;

import tech.itpark.citilink.domain.Book;
import tech.itpark.citilink.domain.Cap;
import tech.itpark.citilink.domain.Product;
import tech.itpark.citilink.repository.ProductRepository;
import tech.itpark.citilink.repository.ProductRepositoryInMemory;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    // private ProductRepository repository = new ProductRepositoryInMemory();
    private ArrayList<Product> items = new ArrayList<>();

    public List<Product> getAll() {
        return items;
    }

    // выделить + Ctrl + Shift + стрелки вверх/вниз
    public List<Product> search(String text) {
        ArrayList<Product> result = new ArrayList<>();
        String target = text.trim().toLowerCase();

        for (Product item : items) {
            if (contains(item.getName(), target)) {
                result.add(item);
                continue;
            }

            // inst + Tab
            if (item instanceof Book) {
                Book book = (Book) item;
                if (contains(book.getAuthor(), target)) {
                    result.add(item);
                    continue;
                }
            }
        }

        return result;
    }

    public List<Product> filter(String type) {
        ArrayList<Product> result = new ArrayList<>();

        // && - логическое И
        for (Product item : items) {
            if (type.equals("caps") && item instanceof Cap) {
                result.add(item);
                continue;
            }

            if (type.equals("books") && item instanceof Book) {
                result.add(item);
                continue;
            }

            // iPhone
        }

        return result;
    }

    public void add(Product product) {
        items.add(product);
    }

    public void update(int id, Product product){
        try { items.set(id, product);}
        catch (RuntimeException e){
            System.out.println("Sorry, error happened: " + e.getMessage());
        }
    }

    public void remove(int id, Product product){
        product.removed = true;
        try { items.set(id, product);}
        catch (RuntimeException e){
            System.out.println("Sorry, error happened: " + e.getMessage());
        }
    }



    private boolean contains(String field, String target) {
        return field.toLowerCase().contains(target);
    }
}