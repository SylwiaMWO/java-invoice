package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private HashMap<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null)
            throw new java.lang.IllegalArgumentException();
        if(products.containsKey(product)){
            products.put(product,products.get(product) +1);
        }
        else{
            products.put(product, 1);
        }
    }

    public void addProduct(Product product, Integer quantity) {
            if(quantity < 1)
                throw new java.lang.IllegalArgumentException();
            if(products.containsKey(product)){
                products.put(product,products.get(product) + quantity);
            }
            else{
                products.put(product, quantity);
            }
        }


    public BigDecimal getSubtotal() {
            BigDecimal temp = new BigDecimal(0);
            if(products == null)
                return temp;
            for(Product x: products.keySet()){
                temp = temp.add(x.getPrice().multiply(BigDecimal.valueOf(products.get(x))));
            }
            return temp;
        }


    public BigDecimal getTax() {
        BigDecimal temp = new BigDecimal(0);

            if(products == null)
                return temp;
            for(Product x: products.keySet()){
                temp = temp.add(x.getPriceWithTax().subtract(x.getPrice()).multiply(BigDecimal.valueOf(products.get(x))));

            }
            return temp;
    }

    public BigDecimal getTotal() {
            BigDecimal temp = new BigDecimal(0);
            if(products == null)
                return temp;
            return getTax().add(getSubtotal());
        }
    }

