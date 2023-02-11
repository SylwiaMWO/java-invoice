package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products;

    public void addProduct(Product product) {
        // TODO: implement

    }

    public void addProduct(Product product, Integer quantity) {
        // TODO: implement
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
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }
}
