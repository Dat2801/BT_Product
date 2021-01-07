import java.util.Scanner;

public class Main {
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                int choice = 0;
                System.out.println("\n " +
                        "Menu");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Hiển thị sản phẩm");
                System.out.println("3. TÌm kiếm sản phẩm");
                System.out.println("4. Thoát");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addNewProduct();
                        break;
                    case 2:
                        productManager.showProduct();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai mời bạn nhập lại");
        }
    }

    public static void addNewProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mã sản phẩm");
            String id = scanner.nextLine();

            System.out.println("Tên sản phẩm");
            String name = scanner.nextLine();

            System.out.println("Nhà sản xuất");
            String producer = scanner.nextLine();

            System.out.println("Giá sản phẩm");
            double price = Double.parseDouble(scanner.nextLine());

            Product product = new Product(id, name, producer, price);
            productManager.addProduct(product);
        } catch (Exception e) {
            System.out.println("Nhập sai mời bạn nhập lại");
        }
    }

    public static void search() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập mã sản phẩm");
            String id = scanner.nextLine();
            Product p = productManager.searchProduct(id);
            System.out.printf("\n%-15s%-15s%-15s%-15s"
                    , "Mã sản phẩm"
                    , "Tên sản phẩm"
                    , "Nhà sản xuất"
                    , "Giá sản phẩm");
            System.out.printf("\n%-15s%-15s%-15s%-15s"
                    , p.getIdProduct()
                    , p.getNameProduct()
                    , p.getProducer()
                    , p.getPrice());
//            System.out.println(p);
        } catch (Exception e) {
            System.out.println("Nhập sai mời bạn nhập lại");
        }
    }
}
