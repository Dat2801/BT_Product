import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        writerFile();
    }

    public void showProduct() {
        readFile();
        System.out.printf("\n%-15s%-15s%-15s%-15s"
                , "Mã sản phẩm"
                , "Tên sản phẩm"
                , "Nhà sản xuất"
                , "Giá sản phẩm");
        for (Product product : products) {
            System.out.printf("\n%-15s%-15s%-15s%-15s"
            , product.getIdProduct()
            , product.getNameProduct()
            , product.getProducer()
            , product.getPrice());
        }
    }

    public Product searchProduct(String id) {
        Product product = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getIdProduct())) {
                product = products.get(i);
            }
        }
        return product;
    }

    public void writerFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("dat.txt");
            ObjectOutputStream obj = new ObjectOutputStream(fileOutputStream);
            obj.writeObject(getProducts());
            obj.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Product> readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("dat.txt");
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            products = (ArrayList<Product>) obj.readObject();
            obj.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return getProducts();
    }
}

