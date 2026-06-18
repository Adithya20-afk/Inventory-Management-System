import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;
import model.Product;

public boolean addProduct(Product product){
    try{
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO products(name, quantity, price) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setInt(2, product.getQuantity());
        ps.setDouble(3, product.getPrice());
        int rows = ps.executeUpdate();
        if(rows>0){
            ps.close();
            con.close();
            return true;
        }
        ps.close();
        con.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    return false;
}

public ArrayList<Product> getProducts(){
    ArrayList<Product> list = new ArrayList<>();
    try{
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM products";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            list.add(new Product(id,name,quantity,price));
        }
        rs.close();
        ps.close();
        con.close();
        return list;
    }catch(Exception e){
        e.printStackTrace();
    }
    return list;
}

public Product getProductById(int id){
    try{
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM products WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int id1 = rs.getInt("id");
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            rs.close();
            ps.close();
            con.close();
            return new Product(id1, name, quantity, price);
        }
        rs.close();
        ps.close();
        con.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    return null;
}

public boolean updateQuantity(int id, int quantity){
    try{
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE products SET quantity = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        
    }catch(Exception e){
        e.printStackTrace();
    }
}

public boolean updatePrice(int id, double price){

}

public boolean deleteProduct(int id){

}

public ArrayList<Product> getLowStockProducts(){

}

public double getTotalInventoryValue(){
    
}