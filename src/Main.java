
import controller.ProductController;

public class Main {
    public static void main(String[] args){
        ProductController controller = new ProductController();
        controller.start();
    }
}



/* 
import db.DBConnection;
import java.sql.Connection;

public class Main{
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Connected Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
*/

/*
import service.ExpenseService;
import model.Expense;

public class Main{
    public static void main(String[] args) {

        ExpenseService service = new ExpenseService();

        boolean added = service.addExpenseDB(new Expense("Food", 250, "Pizza"));

        System.out.println(added);
    }
}
*/
/*
import java.util.ArrayList;

import controller.ExpenseController;
import model.Expense;
import service.ExpenseService;

public class Main {
    public static void main(String[] args){
        ExpenseService service = new ExpenseService();

        ArrayList<Expense> expenses = service.getExpensesDB();

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }
}
*/
/*cd src
java -cp ".;../lib/mysql-connector-j-9.7.0.jar" Main
*/
//To run from terminal