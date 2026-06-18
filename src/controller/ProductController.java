package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Product;
import service.ProductService;
public class ProductController {
    public void start(){
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();
        while(true){
            System.out.println("\n");
            System.out.println(
            "[ADD : ADD Name Quantity Price]\n" +
            "[LIST : LIST]\n" +
            "[GET : GET ID]\n" +
            "[UPDATE_QUANTITY : UPDATE_QUANTITY ID Quantity]\n" +
            "[UPDATE_PRICE : UPDATE_PRICE ID Price]\n" +
            "[DELETE : DELETE ID]\n" +
            "[LOW_STOCK : LOW_STOCK Quantity]\n" +
            "[TOTAL_VALUE : TOTAL_VALUE]\n" +
            "[EXIT]");
            System.out.print("Enter command :");
            String line = sc.nextLine();
            if(line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            Command cmd = null;
            try{
                cmd = Command.valueOf(parts[0]);
            }
            catch(IllegalArgumentException iae){
                System.out.println("Invalid command");
                continue;
            }

            switch(cmd){
                case ADD:
                    if(parts.length!=4){
                        System.out.println("Invalid format");
                        break;
                    }
                    try{
                        String name = parts[1];
                        int quantity = Integer.parseInt(parts[2]);
                        double price = Double.parseDouble(parts[3]);
                        boolean add = service.addProduct(new Product(name, quantity, price));
                        if(add) System.out.println("Added successfully");
                        else System.out.println("add failed");
                    }
                    catch(NumberFormatException nfe){
                        System.out.println("Invalid amount");
                        break;
                    }
                    break;

                case LIST:
                    if(parts.length != 1){
                        System.out.println("Invalid LIST command");
                        break;
                    }
                    ArrayList<Product> products = service.getProducts();
                    for(Product p : products)
                        System.out.println(p);
                    break;

                case GET:
                    if(parts.length!=2){
                        System.out.println("Invalid Get by ID command");
                        break;
                    }
                    int id0;
                    try{
                        id0 = Integer.parseInt(parts[1]);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    System.out.println(service.getProductById(id0));
                    break;

                case UPDATE_QUANTITY:
                    if(parts.length!=3){
                        System.out.println("Invalid UPDATE_QUANTITY command");
                        break;
                    }
                    int id1 = 0;
                    int quantity = 0;
                    try{
                        id1 = Integer.parseInt(parts[1]);
                        quantity = Integer.parseInt(parts[2]);
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe.getMessage());
                        break;
                    }
                    if(service.updateQuantity(id1, quantity)) System.out.println("Quantity updated successfully!");
                    else System.out.println("Quantity updation Failed");
                    break;

                case UPDATE_PRICE:
                    if(parts.length!=3){
                        System.out.println("Invalid UPDATE command");
                        break;
                    }
                    int id2 = 0;
                    double price = 0;
                    try{
                        id2 = Integer.parseInt(parts[1]);
                        price = Double.parseDouble(parts[2]);
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe.getMessage());
                        break;
                    }
                    if(service.updatePrice(id2, price)) System.out.println("Price updated successfully!");
                    else System.out.println("Price updation Failed");
                    break;
                    
                case DELETE:
                    if(parts.length != 2){
                        System.out.println("Invalid DELETE command");
                        break;
                    }
                    int id3 = 0;
                    try{
                        id3 = Integer.parseInt(parts[1]);
                        if(id3<1){
                            System.out.println("Invalid ID");
                            continue;
                        }
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe.getMessage());
                        break;
                    }
                    if(service.deleteProduct(id3)) System.out.println("Deleted "+id3+" successsfully!");
                    else System.out.println("Delete unseccessful");
                    break;
                    
                case LOW_STOCK:
                    if(parts.length !=2){
                        System.out.println("Invalid command");
                        break;
                    }
                    int quantity1 = 0;
                    try{
                        quantity1 = Integer.parseInt(parts[1]);
                        if(quantity1<0){
                            System.out.println("Invalid quantity value!");
                            break;
                        }
                    }catch(Exception e){
                        System.out.println("error");
                        break;
                    }
                    ArrayList<Product> products1 = service.getLowStockProducts(quantity1);
                    for(Product p: products1)
                        System.out.println(p);
                    break;
                    
                case TOTAL_VALUE:
                    if(parts.length != 1){
                        System.out.println("Invalid TOTAL command");
                        break;
                    }
                    System.out.println(service.getTotalInventoryValue());
                    break;
                    
                case EXIT:
                    if(parts.length != 1){
                        System.out.println("Invalid EXIT command");
                        break;
                    }
                    sc.close();
                    return;
            }
        }
    }
}
