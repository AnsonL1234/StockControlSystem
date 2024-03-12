import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main implements Serializable
{
    ArrayList<Inventory> list;
    
    public Main() {
        mainMenu();
    }
    
    public void mainMenu() {
        displayMenu();
        askMenuOption();
    }
    
    public void displayMenu() {
        System.out.println("==========================");
        System.out.println("##Welcome to PCTechWorld##");
        System.out.println("==========================");
        System.out.println("****TecFurniture - SCS****");
        System.out.println("==========================");
        System.out.println("  ||(1)Customer Menu  ||");
        System.out.println("  ||(2)Staff Menu     ||");
        System.out.println("  ||(3)Exit System    ||");
        System.out.println("==========================");
    }
    
    public void askMenuOption() {
        Scanner scan = new Scanner(System.in);
        int menuOption = 0;
        boolean isValidOption = true;
        
        do {
            System.out.print("\nPick the option : ");
            try {
                menuOption = scan.nextInt();
                isValidOption = true;
            } catch (InputMismatchException e) {
                System.out.println("\n***** Incorrect Type *****");
                isValidOption = false;
                scan.next();//clear the scanner
            }
            switch (menuOption) {
                case 1: customerOption1();break;
            }
        } while ((menuOption != 3) || !isValidOption);
        System.out.println("==========================");
    }
    
    /** 5. menu option 1 **/
    public void customerOption1() {
        displayCustomerMenu();
        askCustomerMenuOption();
    }
    
    public void displayCustomerMenu() {
        System.out.println("***** Customers Menu *****");
        System.out.println("==========================");
        System.out.println("  ||(1)Display Mobile ||");
        System.out.println("  ||(2)Display Laptop ||");
        System.out.println("  ||(3)Purchase Mobile||");
        System.out.println("  ||(4)Purchase Laptop||");
        System.out.println("  ||(5)Exit Menu      ||");
        System.out.println("==========================");
    }
    
    public void askCustomerMenuOption() {
        Scanner scan = new Scanner(System.in);
        int customerOption = 0;
        boolean isValidCustumerOption = true;
        
        do {
            System.out.print("\nPick the option : ");
            try {
                customerOption = scan.nextInt();
                isValidCustumerOption = true;
            } catch (NumberFormatException e) {
                System.out.println("\n**** Incorrect Option ****");
                isValidCustumerOption = false;
            }
            switch (customerOption) {
                case 1:cusrtomerOption1();break;
                case 2:cusrtomerOption2();break;
            }
        } while ((customerOption != 5) || !isValidCustumerOption);
        System.out.println("==========================");
    }
    
    // 6. customer menu option 1 - display all the mobile that is for sale
    public void cusrtomerOption1() {
        Mobile mobile = null;
        System.out.println("==========================");
        System.out.println("**** Mobile Sales List ***");
        for (Inventory each: list) {
            mobile = (Mobile) each;
            if (mobile != null) {
                System.out.println("\n==========================");
                System.out.println(mobile.toString());
            } else {
                System.out.println("No stock on list");
            }
        }
        System.out.println("*********** End **********");
        System.out.println("==========================");
    }
    
    // 6. customer menu option 2 - display all the laptop that is for sale
    public void cusrtomerOption2() {
        Laptop laptop = null;
        System.out.println("==========================");
        System.out.println("**** Laptop Sales List ***");
        for (Inventory each: list) {
            laptop = (Laptop) each;
            if (laptop != null) {
                System.out.println("\n==========================");
                System.out.println(laptop.toString());
            } else {
                System.out.println("No stock on list");
            }
        }
        System.out.println("*********** End **********");
        System.out.println("==========================");
    }
    /** 5. menu option 1 - end here **/
    
    /** main method **/
    public static void main(String[] args) {
        
    }
}
