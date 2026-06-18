package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;
import model.Product;

public class ProductService{
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
            ps.setInt(1,quantity);
            ps.setInt(2,id);
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

    public boolean updatePrice(int id, double price){
        try{
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE products SET price = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1,price);
            ps.setInt(2,id);
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

    public boolean deleteProduct(int id){
        try{
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
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

    public ArrayList<Product> getLowStockProducts(int quantity){
        ArrayList<Product> list = new ArrayList<>();
        try{
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM products WHERE quantity < ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,quantity);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                int quantity1 = rs.getInt("quantity");
                double price = rs.getDouble("price");
                list.add(new Product(id1, name, quantity1, price));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public double getTotalInventoryValue(){
        double total=0;
        try{
            Connection con = DBConnection.getConnection();
            String sql = "SELECT SUM(quantity * price) FROM products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getDouble(1);
                rs.close();
                ps.close();
                con.close();
                return total;
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return total;
    }
}