/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
/**
 *CAPSTONE PROJECT A
 * @author Tskulley
 * 
 */
public class Capstone implements CustomerConstants{
     private static CustomerDAO customerDAO = null;
    private static Scanner sc = null;
    public static void main(String args[])
    {
        //Setting GUI 
        JTextComponent textComponent = new JTextPane();
        JScrollPane scrollPane = new JScrollPane( textComponent );

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Customer Data");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( scrollPane );
        frame.setSize(700, 500);
        frame.setVisible(true);

        MessageConsole console = new MessageConsole(textComponent);
        console.redirectOut(null, System.out);
        System.out.println("Test");
        // display a welcome message
        System.out.println("Welcome to the Customer Maintenance application\n");
   
        customerDAO = CustomerDAOFactory.getCustomerDAO();
        sc = new Scanner(System.in);
   // display the command menu
        displayMenu();
 
        String action = "";
        while (!action.equalsIgnoreCase("exit"))
        {
           
            action = Validator.getString(sc,
                    "Enter a command: ");
            System.out.println();
    if (action.equalsIgnoreCase("list"))
                displayAllCustomers();
            else if (action.equalsIgnoreCase("add"))
                addCustomer();
            else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete"))
                deleteCustomer();
            else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu"))
                displayMenu();
            else if (action.equalsIgnoreCase("exit") || action.equalsIgnoreCase("quit"))
                System.out.println("Bye.\n");
            else
                System.out.println("Error! Not a valid command.\n");
        }
    }
public static void displayAllCustomers()
    {
        System.out.println("CUSTOMERS LIST");
ArrayList<Customer> customers = customerDAO.getCustomers();
        Customer c = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++)
        {
            c = customers.get(i);
            sb.append(StringUtils.padWithSpaces(c.getEmail(),EMAIL_SIZE + 4));
            sb.append(StringUtils.padWithSpaces(c.getFirstName(),FIRST_SIZE +4));
            sb.append(c.getLastName());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
 public static void addCustomer()
    {
        String email = Validator.getString(
                sc, "Enter customer email address: ");
        String firstName = Validator.getLine(
                sc, "Enter first name: ");
        String lastName = Validator.getLine(
                sc, "Enter last name: ");
   Customer customer = new Customer();
        customer.setEmail(email);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerDAO.addCustomer(customer);
    System.out.println();
        System.out.println(firstName
                + " has been added.\n");
    }
  public static void deleteCustomer()
    {
        String email = Validator.getString(sc,
                "Enter customer email address to delete: ");
  Customer c = customerDAO.getCustomer(email);
   System.out.println();
        if (c != null)
        {
            customerDAO.deleteCustomer(c);
            System.out.println(c.getFirstName()
            + " has been deleted.\n");
        }
        else
        {
            System.out.println("No customer matches that email.\n");
        }
    }
  public static void displayMenu(){
        System.out.println("COMMAND MENU");
        System.out.println("list  -  List all customers");
        System.out.println("add   -  Add a customer");
        System.out.println("del   -  Delete a customer");
        System.out.println("help  -  Show menu");
        System.out.println("exit  -  Exit application");
        
    }

}
