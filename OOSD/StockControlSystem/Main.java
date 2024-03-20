import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Write a description of class Main here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public class Main
{
    //private static final String adminPassword = "Admin123";

    //my own destop version
    private final String finalFile = "C:\\Users\\anson\\OneDrive - Technological University Dublin\\Year 1\\Business Computing Sem 2\\OOSD&PSD Final Assignment\\OOSD\\StockInventory\\StockInventory.csv";
    final String finalFile1 = "StockInventory.dat";

    private final String[] HeadList = {"Type of Products","Brand","Model","Memory","Stock","Prices"}; // header for text file
    private int count = 0;
    
    ArrayList<Inventory> list; 
    ArrayList<Staff> sList;

    //constructor
    public Main() {
        Scanner scan = new Scanner(System.in);
        list = new ArrayList<Inventory>();
        sList = new ArrayList<Staff>();
        if (readTheFile()) {
            System.out.println("\nThe list has been populated with product!");
        } else {
            System.out.println("\nThere are no products in the list!");
        }
        System.out.println("\nEnter press to continue....");
        scan.nextLine();
        mainMenu();
    }

    /** pure module for updating the file **/
    public void updateBinaryFile() {
        String splite = ",";
        try  {
            ObjectOutputStream oOP = new ObjectOutputStream(new FileOutputStream(finalFile1)); //outpur the file as dat

            // check everthing value on the list and add it to the text file
            for (Inventory each: list) {
                oOP.writeObject(each); //file out every value into object
            }
        }catch (EOFException e) {
            System.out.println("\nThere is an error with save the file...");
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** create a pure module ot update the file **/
    public void updateTextFile() {
        String splite = ",";
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.finalFile))) {
            writer.println(String.join(splite,HeadList)); //the common and header of all data

            // check everthing value on the list and add it to the text file
            for (Inventory each: list) {
                if (each instanceof Laptop) {
                    Laptop laptop = (Laptop) each;

                    //get everydata and put it in an array
                    String[] laptopList = {laptop.getTyOfProducts(),laptop.getBrand(),laptop.getDeviceModel(),laptop.getMemoryOp(),Integer.toString(laptop.getNumOfStock()),Double.toString(laptop.getPrices())}; //pass in all the detail with all the 
                    writer.println(String.join(splite,laptopList)); //common (", ") the data
                } else if (each instanceof Mobile) {
                    Mobile mobile = (Mobile) each;
                    String[] line = {mobile.getTyOfProducts(), mobile.getBrand(), mobile.getDeviceModel(), mobile.getMemoryOp(),Integer.toString(mobile.getNumOfStock()),Double.toString(mobile.getPrices())};
                    writer.println(String.join(splite,line));
                }
            }
            writer.close();
        }catch (EOFException e) {
            System.out.println("\nThere is an error with save the file...");
        }catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    /** create pure module read the file **/
    public boolean readTheFile() {
        ObjectInputStream fileImport;
        int index = 0;
        Inventory i;
        
        //read file
        try {
            fileImport = new ObjectInputStream(new FileInputStream(finalFile1));//read the dat file
            i = (Inventory) fileImport.readObject();
            index = 1;
            //read everything on the list
            while(i != null) {
                list.add(i);
                i = (Inventory) fileImport.readObject(); 
            }
            fileImport.close();
            return true;
        } catch (IOException e) { //catch the error
            // if the index is more than one which mean there is value, else there is nothing
            if (index > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /** 4. display the main menu and ask the option **/
    public void mainMenu() {
        askMenuOption();
    }

    //display main menu
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
        count = 0;
    }

    //pure module for asking the menu
    public void askMenuOption() {
        Scanner scan = new Scanner(System.in);
        int menuOption = 0;
        //System.out.print("\f");
        
        do {
            System.out.print("\f");
            displayMenu(); // display main menu
            menuOption = checkOption();
            switch (menuOption) {
                case 1: customerOption1();break;
                case 2: menuOption2();break;
            }
        } while (menuOption != 3);
        updateTextFile(); // update csv file
        updateBinaryFile(); // update the binary file
        System.out.println("==========================");
    }

    //checking is it the valid opyion
    public int checkOption() {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        boolean isValidOption = true;
        try {
            System.out.print("\nPick the option : ");
            option = scan.nextInt();
            isValidOption = true;
        } catch (InputMismatchException e) {
            System.out.println("\n***** Incorrect Type *****");
            isValidOption = false;
            scan.next();//clear the scanner
        }
        return option;
    }
    /** 4. end here **/

    /** 5. menu option 1 **/
    public void customerOption1() {
        //System.out.print("\f");
        askCustomerMenuOption();
    }

    // menu
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

        do {
            System.out.print("\f");
            displayCustomerMenu();
            customerOption = checkOption();
            switch (customerOption) {
                case 1:cusrtomerOption1();break;
                case 2:cusrtomerOption2();break;
                case 3:buyMobile();break;
                case 4:buyLaptops();break;
                case 5: break;
            }
        } while (customerOption != 5);
        System.out.println("==========================");
    }
    /** 5. menu option 1 - end here **/

    /** 6. customer menu option 1 - display all the mobile that is for sale **/
    public void cusrtomerOption1() {
        System.out.print("\f");
        System.out.println("==========================");
        System.out.println("**** Mobile Sales List ***\n");
        if (list.isEmpty()) {
            System.out.println("No Stock on the list!");
        } else {
            for (Inventory each: list) {
                if (each instanceof Mobile) {
                    System.out.println(each.toString());
                    System.out.println("\n==========================\n");
                } 
            }
        }

        System.out.println("*********** End **********");
        System.out.println("==========================");
        exit();
    }
    /** 6. customer menu option 1 end here**/

    /** 7. customer menu option 2 - display all the laptop that is for sale **/
    public void cusrtomerOption2() {
        System.out.print("\f");
        System.out.println("==========================");
        System.out.println("**** Laptop Sales List ***\n");
        if (list.isEmpty()) {
            System.out.println("No Stock on the list!");
        } else {
            for (Inventory each: list) {
                if (each instanceof Laptop) {
                    System.out.println(each.toString());
                    System.out.println("\n==========================\n");
                } 
            }
        }

        System.out.println("*********** End **********");
        System.out.println("==========================");
        exit();
    }
    /** 7. customer menu option 2 - end here **/

    /** 8. customer menu option 3 - purchase mobile action**/
    public void buyMobile() {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        String brand = "", model = "", ans = "";
        int quantity = 0;
        System.out.print("\f");
        System.out.println("**** Enter the detail ****");
        System.out.println("==========================");
        System.out.print("\nEnter the brand: ");
        brand = scan.nextLine();
        System.out.print("\nEnter the model: ");
        model = scan.nextLine();

        mobile = searchMobileProducts(brand,model); //search the product
        if (mobile != null) {
            System.out.print("How many did you wish to purchase: ");
            quantity = scan.nextInt();
            scan.nextLine();
            if (mobile.getNumOfStock() < quantity) { // if stock is less than the quantity, no enough stock
                System.out.println("\nNot enough stock - couldn't process");
            } else {
                System.out.print("\nDid you wish to process(y/n)? ");
                ans = scan.nextLine();
                if (ans.equalsIgnoreCase("y")) { // if customer say yes display receipt
                    System.out.print("\f");
                    double totalPrices = mobile.getPrices() * quantity;
                    mobile.setNumOfStock(mobile.getNumOfStock() - quantity);
                    System.out.println("==========================");
                    System.out.println("********* Receipt ********");
                    System.out.println("********* Details ********");
                    System.out.println("Brand   : " + mobile.getBrand());
                    System.out.println("Products: " + mobile.getDeviceModel());
                    System.out.println("Quantity: " + quantity);
                    System.out.println(" ");
                    System.out.println("**************************");
                    System.out.println("\nPrices : " + mobile.getPrices() + " euro");
                    System.out.println("Total  : " + totalPrices + " euro");
                    System.out.println("==========================");
                    updateTextFile();
                }else if (ans.equalsIgnoreCase("n")) {
                    System.out.println("\n*** Cancel the payment successfully ***");
                } else {
                    System.out.println("\nNo correct option - couldn't process");
                }
            }
        } else {
            System.out.println("\n*** No Product Found! ***");
        }
        exit();
    }
    /** 8. customer menu option 3 - end here **/

    /** 9. customer menu option 4 - purchase laptop action**/
    public void buyLaptops() {
        Scanner scan = new Scanner(System.in);
        Laptop laptop = null;
        String brand = "", model = "", ans = "";
        int quantity = 0;
        System.out.print("\f"); // clear the scrrem
        System.out.println("**** Enter the detail ****");
        System.out.println("==========================");
        System.out.print("Enter the brand: ");
        brand = scan.nextLine();
        System.out.print("Enter the model: ");
        model = scan.nextLine();

        laptop = searchLaptopProducts(brand,model);// search the product
        if (laptop != null) {
            System.out.print("\nHow many did you wish to purchase: ");
            quantity = scan.nextInt();
            scan.nextLine();
            if (laptop.getNumOfStock() < quantity) {
                System.out.println("\nNot enough stock - couldn't process");
            } else {
                System.out.print("Did you wish to process(y/n)? ");
                ans = scan.nextLine();
                if (ans.equalsIgnoreCase("y")) { // if customer say yes display the receipt
                    System.out.print("\f");
                    double totalPrices = laptop.getPrices() * quantity;
                    laptop.setNumOfStock(laptop.getNumOfStock() - quantity);
                    System.out.println("==========================");
                    System.out.println("********* Receipt ********");
                    System.out.println("********* Details ********");
                    System.out.println("Brand   : " + laptop.getBrand());
                    System.out.println("Products: " + laptop.getDeviceModel());
                    System.out.println("Quantity: " + quantity);
                    System.out.println(" ");
                    System.out.println("**************************");
                    System.out.println("\nPrices: " + laptop.getPrices() + " euro");
                    System.out.println("Total : " + totalPrices + " euro");
                    System.out.println("==========================");
                    updateTextFile();
                }else if (ans.equalsIgnoreCase("n")) { // if customer say no cancel the payment
                    System.out.println("\n*** Cancel the payment successfully ***");
                } else {
                    System.out.println("\nNo correct option - couldn't process");
                }
            }
        } else {
            System.out.println("\n*** No Product Found! ***");
        }
        exit();
    }
    /** 9. customer menu option 4 - end here **/

    /** 11. staff menu **/
    public void menuOption2() {
        System.out.print("\f");
        System.out.println("==========================");
        System.out.println("******* Staff Login ******");
        System.out.println("==========================");
        askThePassword();
    }

    public void askThePassword() {
        Scanner scan = new Scanner(System.in);
        String password = "";
        Staff staff = null;
        if (sList.isEmpty()) {
            createPassword();
        } else {
            do {
                System.out.print("Enter password: ");
                password = scan.nextLine();
                count++;
                staff = searchPassword(password); // do the searching
                if (staff == null) {
                    System.out.println("Password is Incorrect!");
                } 
            } while (staff == null && count < 3);
            if (staff != null) {
                askStaffMenuOption();
            } else {
                System.out.println("Run Out of " + count + " attempts!");
            }
        }
    }

    //search the password on the list
    public Staff searchPassword(String pas) {
        Staff staff = null;
        for (Staff each: sList) {
            if (pas.equalsIgnoreCase(each.getPassword())) {
                staff = each;
            }
        }
        return staff;
    }

    // ask staff to create password
    public void createPassword() {
        Scanner scan = new Scanner(System.in);
        String staName = "", staPass = ""; 
        final String staID ="D221234";
        Staff staff = null;
        
        System.out.print("\f");
        System.out.println("No account found - create form");
        System.out.println("==============================");
        System.out.print("\nEnter name: ");
        staName = scan.nextLine();

        //validate the correct password
        do {
            System.out.print("\nCreate pass: ");
            staPass = scan.nextLine();
            staff = new Staff("","",staPass);
            if (!staff.isCorrectPassword())
                System.out.println("*** Incorrect Type Password ***");
        }while(!staff.isCorrectPassword());
        System.out.println("\n*** Password Create Successfully ***");

        staff = new Staff(staName,staID,staPass);
        sList.add(staff);
    } 

    public void displayStaffMenu() {
        System.out.println("==========================");
        System.out.println("******* Staff Menu *******");
        System.out.println("==========================");
        System.out.println("  ||(1) Add new Mobile ||");
        System.out.println("  ||(2) Add new Laptop ||");
        System.out.println("  ||(3) Update stock   ||");
        System.out.println("  ||(4) Check stock    ||");
        System.out.println("  ||(5) Exit staff menu||");
        System.out.println("==========================");
    }
    /** 11. menu option 2 - end here **/

    /** 12. staff menu option 1 - askk staff to add the new item**/
    public void askStaffMenuOption() {
        Scanner scan = new Scanner(System.in);
        int staffOption = 0;
        //System.out.print("\f");

        // display menu and validate the option
        do {
            System.out.print("\f");
            displayStaffMenu();
            staffOption = checkOption();
            switch (staffOption) {
                case 1:staffMenuOption1();break;
                case 2:staffMenuOption2();break;
                case 3:UpdateStockAndDelivery();break;
                case 4:checkStock();break;
                case 5:break;
            }
        } while (staffOption != 5);
    }
    /** 11. staff menu - end here **/

    /** 12. staff menu option 1 - ask staff adding new products for mobile **/
    public void staffMenuOption1() {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        String brand = "", model = "", memoryOption = "", ans = "";
        int numOfAsk = 0;

        System.out.print("\f");//clear the screem
        System.out.println("**** Enter the detail ****");
        System.out.println("==========================");
        //enter the brand, model, option
        System.out.print("\nEnter the brand  : ");
        brand = scan.nextLine();
        System.out.print("\nEnter the model  : ");
        model = scan.nextLine();
        System.out.print("\nEnter the memoryOption  : ");
        memoryOption = scan.nextLine();

        //store everything into the object/reference varibale
        mobile = new Mobile("Mobile",brand,model,memoryOption);
        list.add(mobile);
        System.out.println("\n*** The item is add to store ***");
        exit();
    }
    /** 12. staff menu option 1 - end here **/

    /** 13. staff menu option 2 - ask staff adding new products for laptop **/
    public void staffMenuOption2() {
        Scanner scan = new Scanner(System.in);
        Laptop laptop = null;
        String brand = "", model = "", memory = "", ans = "";

        System.out.print("\f");
        System.out.println("**** Enter the detail ****");
        System.out.println("==========================");
        System.out.print("\nEnter the brand  : ");
        brand = scan.nextLine();
        System.out.print("\nEnter the model  : ");
        model = scan.nextLine();
        System.out.print("\nEnter the memoryOption  : ");
        memory = scan.nextLine();

        //update value to the object/reference variable
        laptop = new Laptop("Laptop",brand,model,memory);
        list.add(laptop);
        System.out.println("\nThe item has been add to store!");
        exit();
    }
    /** 13. staff menu option 2 - end here **/

    /** 14. staff menu option 3 - update the stock and prices **/
    public void UpdateStockAndDelivery() {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        Laptop laptop = null;
        String typeOfProd = "", brand = "", model = "";
        System.out.print("\f");
        System.out.print("\nInput the type of products: ");
        typeOfProd = scan.nextLine();

        if (typeOfProd.equalsIgnoreCase("mobile")) { // if staff input mobile
            System.out.print("\f");
            System.out.println("**** Enter the detail ****");
            System.out.println("==========================");
            System.out.print("\nEnter the brand: ");
            brand = scan.nextLine();
            System.out.print("\nEnter the model: ");
            model = scan.nextLine();
            mobile = searchMobileProducts(brand,model); // search the product
            if (mobile != null) { // if there is product on the list
                System.out.print("\f");
                System.out.println("\n*** found the device ***");
                setMobileStockAndPrices(mobile);
            } else {
                System.out.println("The device is not found - couldn't process");
            }
        } else if (typeOfProd.equalsIgnoreCase("laptop")) { // if staff input laptop
            System.out.print("\f");
            System.out.println("**** Enter the detail ****");
            System.out.println("==========================");
            System.out.print("\nEnter the brand: ");
            brand = scan.nextLine();
            System.out.print("\nEnter the model: ");
            model = scan.nextLine();
            laptop = searchLaptopProducts(brand,model);
            if (laptop != null) {
                System.out.print("\f");
                System.out.println("\n*** found the device ***");
                setLaptopStockAndPrices(laptop);
            } else {
                System.out.println("\nThe " + model + " is not found - couldn't process");
            }
        } else { // if not both of them
            System.out.println("\nNo products found - only mobile/laptop at the moment");
        }
        exit();
    }

    public void checkStock() {
        System.out.print("\f");
        System.out.println("==========================");
        System.out.println("********* Stocks *********\n");
        for (Inventory each: list) {
            System.out.println(each.toStockString());
            System.out.println("\n==========================");
        }
        exit();
    }

    // pure module for asking the stock and prices for mobile
    public void setMobileStockAndPrices(Mobile m) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the stock: ");
        int stock = scan.nextInt();
        System.out.print("\nEnter the prices: ");
        double prices = scan.nextDouble();
        if (stock < 1) {
            System.out.println("\nNeed at least 1 stock!");
        } else {
            m.setNumOfStock(stock);//set the stock
            m.setPrices(prices);//set the prices
            System.out.println("\nNew stock is been delivered!");
        }
    }

    // pure module for asking the stock and prices for laptop
    public void setLaptopStockAndPrices(Laptop l) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the stock: ");
        int stock = scan.nextInt();
        System.out.print("\nEnter the prices: ");
        double prices = scan.nextDouble();
        if (stock < 1) {
            System.out.println("\nNeed at least 1 stock!");
        } else {
            l.setNumOfStock(stock);//set the stock
            l.setPrices(prices);//set the prices
            System.out.println("\nNew stock is been delivered!");
        }
    }
    /** 14. staff menu option 3 - end here **/

    /** pure module for search the mobile phone **/
    public Mobile searchMobileProducts(String brand, String model) {
        Mobile mobile = null;
        for (Inventory each: list) {
            if (each instanceof Mobile) {
                mobile = (Mobile)each;
                if (brand.equalsIgnoreCase(mobile.getBrand()) && model.equalsIgnoreCase(mobile.getDeviceModel())) {
                    return mobile;
                }
            } 
        }
        return null;
    }

    /** pure module for search the laptop **/
    public Laptop searchLaptopProducts(String brand, String model) {
        Laptop laptop = null;
        for (Inventory each: list) {
            if (each instanceof Laptop) {
                laptop = (Laptop)each;
                if (brand.equalsIgnoreCase(laptop.getBrand()) && model.equalsIgnoreCase(laptop.getDeviceModel())) {
                    return laptop;
                }
            } 
        }
        return null;
    }

    /** 15. & 16. pure module for press go back and exit **/
    public void exit() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPress enter to go back/exits...");
        String input = scan.nextLine();
    }

    /** main method **/
    public static void main(String[] args) {
        new Main();
    }
}
