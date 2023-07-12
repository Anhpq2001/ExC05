
public class ProductManage {
    Product Coca = new Product(1, "Coca", 9000, 90, "No description");
    Product Pesi = new Product(2, "Pesi", 8000, 10, "No description");
    Product Fanta = new Product(3, "Fanta", 11000, 1100, "No description");
    Product Lavie = new Product(4, "Lavie", 15000, 1200, "No description");
    Product Aquafina = new Product(5, "Aquafina", 7000, 3100, "No description");
    // init array
    Product[] listProduct = {Coca, Pesi, Fanta, Lavie, Aquafina};

    // function to manage menu
    public  void Menu() {
        do {
            System.out.println("1. Add new product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Display products");
            System.out.println("5. Display highest priced products");
            System.out.println("6. Display lowest priced products");
            System.out.println("7. Display highest quantity products");
            System.out.println("8. Display lowest quantity products ");
            System.out.println("9. Display total price");
            System.out.println("10. Exit");
            int choice = Validation.checkInt("Enter your choice:", 0, 11);
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    displayHighestPrice();
                    break;
                case 6:
                    displayLowestPrice();
                    break;
                case 7:
                    displayHighestQuantity();
                    break;
                case 8:
                    displayLowestQuantity();
                    break;
                case 9:
                    totalPrice();
                    break;
                case 10:
                    System.exit(0);
            }
        } while (true);
    }

    // function to add new product
    public void addProduct() {
        int id = listProduct.length;
        int newLength;
        int length = Validation.checkInt("Enter number of new element: ", 0, Integer.MAX_VALUE);
        Product[] newArray = new Product[length];
        for (int i = 0; i < length; i++) {
            id++;
            System.out.println("Enter value for element number " + id);
            String name = Validation.checkString("Enter new name: ");
            double price = Validation.checkDouble("Enter new price: ", 0, Double.MAX_VALUE);
            int quantity = Validation.checkInt("Enter new quantity: ", 0, Integer.MAX_VALUE);
            String description = Validation.checkString("Enter new description: ");
            newArray[i] = new Product(id, name, price, quantity, description);
        }
        newLength = listProduct.length + length;
        Product[] newProduct = new Product[newLength];
        for (int i = 0; i < listProduct.length; i++) {
            newProduct[i] = listProduct[i];
        }
        for (int i = 0; i < newArray.length; i++) {
            newProduct[i + listProduct.length] = newArray[i];
        }
        listProduct = newProduct;
    }

    // function to update by id
    public void updateProduct() {
        int id = Validation.checkInt("Enter ID need search: ", 0, listProduct.length);
        for (Product p : listProduct) {
            if (p.getId() == id) {
                System.out.println(p.toString());
            }
        }
        String name = Validation.checkString("Enter product name: ");
        double price = Validation.checkDouble("Enter product price: ", 0, Double.MAX_VALUE);
        int quantity = Validation.checkInt("Enter product quantity :", 0, Integer.MAX_VALUE);
        String description = Validation.checkString("Enter product description: ");
        for (Product p : listProduct) {
            if (p.getId() == id) {
                p.setName(name);
                p.setPrice(price);
                p.setQuantity(quantity);
                p.setDescription(description);
            }
        }
    }

    // functio to delete by id
    public void deleteProduct() {
        int id = listProduct.length;
        int idToDelete = Validation.checkInt("Enter id need delete: ", 0, listProduct.length);
        Product[] newProduct = new Product[listProduct.length - 1];
        for(int i = 0; i<idToDelete; i++){
            newProduct[i] = listProduct[i];
        }
        for(int i = idToDelete; i< listProduct.length -1; i++){
            newProduct[i] = listProduct[i+1];
            newProduct[i].setId(i+1);
        }
        listProduct = newProduct;
    }
    // function to dislay list product
    public void displayProducts() {
        for (Product p : listProduct) {
            System.out.println(p.toString());
        }
    }
    // function to dislay the highest price
    public void displayHighestPrice(){
        int count = 0;
        double maxPrice = listProduct[0].getPrice();
        for (int i = 0; i < listProduct.length; i++) {
            if (maxPrice < listProduct[i].getPrice()) {
                maxPrice = listProduct[i].getPrice() ;
                count = i ;
            }
        }
        System.out.println(listProduct[count]);
    }
    // function to display the lowest price
    public void displayLowestPrice(){
        int count =0;
        double minPrice = listProduct[0].getPrice();
        for (int i = 0; i < listProduct.length; i++) {
            if (minPrice > listProduct[i].getPrice()) {
                minPrice = listProduct[i].getPrice() ;
                count = i ;
            }
        }
        System.out.println(listProduct[count]);
    }
    // function to display the highest quantity
    public void displayHighestQuantity(){
        int count = 0;
        int maxQuantity = listProduct[0].getQuantity();
        for (int i = 0; i < listProduct.length; i++) {
            if (maxQuantity < listProduct[i].getQuantity()) {
                maxQuantity = listProduct[i].getQuantity() ;
                count = i ;
            }
        }
        System.out.println(listProduct[count]);
    }
    // function to display the lowest quantity
    public void displayLowestQuantity() {
        int count = 0;
        int minQuantity = listProduct[0].getQuantity();
        for (int i = 0; i < listProduct.length; i++) {
            if (minQuantity > listProduct[i].getQuantity()) {
                minQuantity = listProduct[i].getQuantity() ;
                count = i ;
            }
        }
        System.out.println(listProduct[count]);
    }
    // function counting total price
    public void totalPrice() {
        double result = 0;
        for (Product p : listProduct) {
            result += p.getPrice() * p.getQuantity();
        }
        System.out.println("Total price: " + result);
    }

}
