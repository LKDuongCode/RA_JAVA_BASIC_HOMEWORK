package practiceHomework_27_03.utils;

import practiceHomework_27_03.entity.Product;

@FunctionalInterface
public interface ProductFilter {
    boolean checking (Product p);
}
