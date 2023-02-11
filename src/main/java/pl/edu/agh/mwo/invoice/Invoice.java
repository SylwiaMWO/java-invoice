package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
   // private Collection<Product> products = new ArrayList<>();
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product, 1)
    }

    public void addProduct(Product product, Integer quantity) {
        for (int i=0; i < quantity; i++){
            products.add(product);
        }
    }

    public BigDecimal getSubtotal() {
    BigDecimal temp = new BigDecimal(0);
    if (products == null)
        return temp;
    for (Product x: products){
        temp = temp.add(x.getPrice());
    }
    return temp;
    }

    public BigDecimal getTax() {
        BigDecimal temp = new BigDecimal(0);
        if (products == null)
            return temp;
        for (Product x: products){
            temp = temp.add(x.getPriceWithTax().subtract(x.getPrice()));
        }
        return temp;
    }

    public BigDecimal getTotal() {
        BigDecimal temp = new BigDecimal(0);
        if (products == null)
            return temp;
        return getTax().add(getSubtotal());
    }
}
