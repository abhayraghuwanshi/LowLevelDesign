/*
    You are developing a software system for an e-commerce platform that deals with various types of products. 
    Each product category (e.g., electronics, clothing, books) requires specific handling during creation. 
    However, you want to decouple the client code from the concrete product creation logic to enhance flexibility and maintainability.
    Additionally, you want to allow for easy extension by adding new product types in the future without modifying existing code.

*/ 

public interface Product {

    void useProduct();

}

public class ElectronicProduct implements Product {

    @Override
    void useProduct(){
        log.info("using the electronic product");
    }

}

public class ClothingProduct implements Product {

    @Override
    void useProduct(){
        log.info("using the clothing product");
    }

}


abstract class ProductCreatorFactory {

    void someOperation(){
        Product p = getInstance();
        p.useProduct();
    }

    abstract Product getInstance();
}


class ClothingProductCreatorFactory implements ProductCreatorFactory {

    @Override
    Product getInstance(){
        return new ClothingProduct();
    }

}

class ElectronicProductCreatorFactory implements ProductCreatorFactory {

    @Override
    Product getInstance(){
        return new ElectronicProduct();
    }

}

public Client {

    void someMethod(){

        ProductCreatorFactory pcf = new ClothingProductCreatorFactory();
        pcf.someOperation();
    }

}