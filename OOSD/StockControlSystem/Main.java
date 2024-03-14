import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Write a description of class Main here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public class Main implements Serializable
{
    private static final String adminPassword = "Admin123";
    private final String finalFile = "C:\\Users\\anson\\OneDrive - Technological University Dublin\\Year 1\\Business Computing Sem 2\\OOSD&PSD Final Assignment\\OOSD\\StockInventory\\StockInventory.csv";
    private final String[] HeadList = {"Type of Products","Brand","Model","Memory","Stock","Prices"};
    ArrayList<Inventory> list; 
    ArrayList<Staff> sList;
    
    public Main() {
        list = new ArrayList<Inventory>();
        sList = new ArrayList<Staff>();
        mainMenu();
    }

    public void mainMenu() {
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
            displayMenu();
            try {
                System.out.print("\nPick the option : ");
                menuOption = scan.nextInt();
                isValidOption = true;
            } catch (InputMismatchException e) {
                System.out.println("\n***** Incorrect Type *****");
                isValidOption = false;
                scan.next();//clear the scanner
            }
            switch (menuOption) {
                case 1: customerOption1();break;
                case 2: menuOption2();break;
            }
        } while ((menuOption != 3) || !isValidOption);
        System.out.println("==========================");
    }

    /** 5. menu option 1 **/
    public void customerOption1() {
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
            displayCustomerMenu();
            try {
                System.out.print("\nPick the option : ");
                customerOption = scan.nextInt();
                isValidCustumerOption = true;
            } catch (NumberFormatException e) {
                System.out.println("\n**** Incorrect Option ****");
                isValidCustumerOption = false;
                scan.next();//clear the scanner
            }
            switch (customerOption) {
                case 1:cusrtomerOption1();break;
                case 2:cusrtomerOption2();break;
                case 5:mainMenu();break;
            }
        } while ((customerOption != 5) || !isValidCustumerOption);
        System.out.println("==========================");
    }
    
    //update the file
    public void updateTextFile(String[] HeadList) {
        String splite = ",";
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.finalFile))) {
            writer.println(String.join(splite,HeadList)); //the header of all data
                
            // check everthing value on the list and add it to the text file
            for (Inventory each: list) {
                if (each instanceof Laptop) {
                    Laptop laptop = (Laptop) each;
                    String[] laptopList = {laptop.getTyOfLap(),laptop.getBrand(),laptop.getModelLap(),laptop.getMemoryOp(),Integer.toString(laptop.getNumOfStock()),Double.toString(laptop.getPrices())}; //pass in all the detail with all the 
                    writer.println(String.join(splite,laptopList)); //seprate the actual value data by ", " in order
                 } else if (each instanceof Mobile) {
                    Mobile mobile = (Mobile) each;
                    String[] line = {mobile.getTyOfMob(), mobile.getBrand(), mobile.getModelMob(), mobile.getMemoryOp(),Integer.toString(mobile.getNumOfStock()),Double.toString(mobile.getPrices())};
                    writer.println(String.join(splite,line));
                }
            }
            writer.close();
            }catch (IOException e) {
                System.out.println("\nThere is an error with the file...");
                e.printStackTrace();
            }
    }
    
    // 6. customer menu option 1 - display all the mobile that is for sale
    public void cusrtomerOption1() {
        Mobile mobile = null;
        System.out.println("==========================");
        System.out.println("**** Mobile Sales List ***\n");
        for (Inventory each: list) {
            mobile = (Mobile) each;
            if (mobile != null) {
                System.out.println(mobile.toString());
            } else {
                System.out.println("\n*** No stock on list ***\n");
            }
        }
        
        System.out.println("*********** End **********");
        System.out.println("==========================");
        exit();
    }

    // 7. customer menu option 2 - display all the laptop that is for sale
    public void cusrtomerOption2() {
        Laptop laptop = null;
        System.out.println("==========================");
        System.out.println("**** Laptop Sales List ***\n");
        for (Inventory each: list) {
            laptop = (Laptop) each;
            if (laptop != null) {
                System.out.println(laptop.toString());
            } else {
                System.out.println("\n*** No stock on list ***\n");
            }
        }
        
        System.out.println("*********** End **********");
        System.out.println("==========================");
        exit();
    }
    
    public void buyMobile() {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        String brand = "", model = "", ans = "";
        int quantity = 0;
        System.out.print("Enter the brand: ");
        brand = scan.nextLine();
        System.out.print("Enter the model: ");
        model = scan.nextLine();
        
        mobile = searchMobileProducts(brand,model);
        if (mobile == null) {
            System.out.print("How many did you wish to purchase: ");
            quantity = scan.nextInt();
            if (mobile.getNumOfStock() < quantity) {
                System.out.println("\nNot enough stock - couldn't process");
            } else {
                System.out.print("Did you wish to process(y/n)? ");
                ans = scan.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    mobile.setPrices(mobile.getPrices() * quantity);
                    System.out.println("==========================");
                    System.out.println("********* Receipt ********");
                    System.out.println("Products: " + mobile.getBrand());
                    System.out.println("Quantity: " + quantity);
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("**************************");
                    System.out.println(" ");
                    System.out.println("\nTotal: " + mobile.getPrices());
                    System.out.println("==========================");
                }else if (ans.equalsIgnoreCase("n")) {
                    System.out.println("\n*** Cancel the payment successfully ***");
                } else {
                    System.out.println("\nNo correct option - couldn't process");
                }
            }
        }
    }
    /** 5. menu option 1 - end here **/

    /** 11. menu option 2 **/
    public void menuOption2() {
        System.out.println("==========================");
        System.out.println("******* Staff Login ******");
        System.out.println("==========================");
        askThePassword();
    }

    public void askThePassword() {
        Scanner scan = new Scanner(System.in);
        String password = "";
        int count = 0;
        do {
            System.out.print("\nEnter the password: ");
            password = scan.next();
            if(password.equals(adminPassword)) {
                askStaffMenuOption(HeadList);
            } else {
                count++;
                System.out.println("*** Incorrect password ***");
            }
            if (count >= 3) {
                System.out.println("You have you all the " + count + " attempts");
            }
        } while (count != 3);
    }

    /**public Staff searchPassword(String pas) {
        Staff staff = null;
        for (Staff each: sList) {
            if (pas.equals(each.getPassword())) {
                staff = each;
                return staff;
            }
        }
        return null;
    }**/

    // ask staff to create password
    /**public void createPassword() {
        Scanner scan = new Scanner(System.in);
        Staff staff = null;
        String staName = "", staPass = "", staID ="";

        System.out.print("Enter name: ");
        staName = scan.nextLine();

        staff = new Staff("",staPass,"");
        do {
            System.out.print("Create password: ");
            staPass = scan.nextLine();
            staPass = (staff.isCorrectPassword())?"\n*** Incorrect ***": "";
        }while (staff.isCorrectPassword());
        
        staff = new Staff("","",staID);
        do {
            System.out.print("Enter ID: ");
            staID = scan.nextLine();
            staID = (staff.isCorrectID())?"\n*** Incorrect ***": "";
        }while (staff.isCorrectID());
        
        staff = new Staff(staName,staPass,staID);
        sList.add(staff);
    } **/

    //validate the password type
    public boolean isCorrectPassword(String crePas) {
        boolean isValidPassword = ((crePas.length() < 12) || (crePas.matches("[a-zA-Z]{6}\\d{6}")))?false:true;
        return isValidPassword = false;
    }

    public void displayStaffMenu() {
        System.out.println("==========================");
        System.out.println("******* Staff Menu *******");
        System.out.println("==========================");
        System.out.println("  ||(1) Add new Mobile ||");
        System.out.println("  ||(2) Add new Laptop ||");
        System.out.println("  ||(3) Update stock   ||");
        System.out.println("  ||(4) Exit staff menu||");
        System.out.println("==========================");
    }

    public void askStaffMenuOption(String[] HeadList) {
        Scanner scan = new Scanner(System.in);
        int staffOption = 0;
        boolean isValidStaffOption = true;
        do {
            displayStaffMenu();
            try {
                System.out.print("\nPick the option : ");
                staffOption = scan.nextInt();
                isValidStaffOption = true;
            } catch (InputMismatchException e) {
                System.out.println("\n**** Incorrect Option ****");
                isValidStaffOption = false;
                scan.next();//clear the scanner
            }
            switch (staffOption) {
                case 1:staffMenuOption1(HeadList);break;
                case 2:staffMenuOption2(HeadList);break;
                case 3:UpdateStockAndDelivery(HeadList);break;
                case 4:mainMenu();break;
            }
        } while ((staffOption != 4) || !isValidStaffOption);
        System.out.println("==========================");
    }
    /** 11. menu option 2 - end here **/
    
    /** 12. staff menu option 1**/
    public void staffMenuOption1(String[] HeadList) {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        String brand = "", model = "", memoryOption = "", ans = "";
        int numOfAsk = 0;
        boolean isCorrectOP = true;
        
        System.out.print("\nEnter the brand  : ");
        brand = scan.nextLine();
        System.out.print("Enter the model  : ");
        model = scan.nextLine();
        System.out.print("Enter the memoryOption  : ");
        memoryOption = scan.nextLine();
            
        //store everything into the object/reference varibale
        mobile = new Mobile("Mobile",brand,model,memoryOption);
        list.add(mobile);
        
        System.out.print("Did you wish to process(y/n)? ");
        ans = scan.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            updateTextFile(HeadList); 
        } else if (ans.equalsIgnoreCase("n")) {
            System.out.println("\n*** The item adding is cancel ***");
            //just reading it from the text file
            try {
                FileReader reader = new FileReader(this.finalFile);
            }catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\n*** Incorrect option, the adding couldn't process ***");
        }
    }
    
    public void staffMenuOption2(String[] HeadList) {
        Scanner scan = new Scanner(System.in);
        Laptop laptop = null;
        String brand = "", model = "", memory = "", ans = "";
        
        System.out.print("\nEnter the brand  : ");
        brand = scan.nextLine();
        System.out.print("Enter the model  : ");
        model = scan.nextLine();
        System.out.print("Enter the memoryOption  : ");
        memory = scan.nextLine();
        
        //update value to the object/reference variable
        laptop = new Laptop("Laptop",brand,model,memory);
        list.add(laptop);
        
        System.out.print("Did you wish to process the adding(y/n)? ");
        ans = scan.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            updateTextFile(HeadList);
        } else if (ans.equalsIgnoreCase("n")) {
            System.out.println("\n*** The item adding is cancel ***");
        } else {
            System.out.println("\n*** Incorrect option, the adding couldn't process ***");
        }
        exit();
    }
    
    public void UpdateStockAndDelivery(String[] HeadList) {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        Laptop laptop = null;
        String typeOfProd = "", brand = "", model = "";
        System.out.print("Input the type of products: ");
        typeOfProd = scan.nextLine();
        
        if (typeOfProd.equalsIgnoreCase("mobile")) {
            System.out.print("Enter the brand: ");
            brand = scan.nextLine();
            System.out.print("Enter the model: ");
            model = scan.nextLine();
            mobile = searchMobileProducts(brand,model);
            if (mobile != null) {
                System.out.println("\n*** found the device ***");
                setMobileStockAndPrices(mobile);
                updateTextFile(HeadList);
            }
        }
    }
    
    public Mobile searchMobileProducts(String brand, String model) {
        Mobile mobile = null;
        for (Inventory each: list) {
            if (each instanceof Mobile) {
                mobile = (Mobile)each;
                if (brand.equalsIgnoreCase(mobile.getBrand()) && model.equalsIgnoreCase(mobile.getModelMob())) {
                    //mobiles = (Mobile)each;
                    return mobile;
                }
            } 
        }
        return null;
    }
    
    public void setMobileStockAndPrices(Mobile m) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the stock: ");
        int stock = scan.nextInt();
        m.setNumOfStock(stock);
        System.out.print("Enter the prices: ");
        double prices = scan.nextDouble();
        m.setPrices(prices);
    }
    
    public void setLaptopStockAndPrices(Laptop l) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the stock: ");
        int stock = scan.nextInt();
        l.setNumOfStock(stock);
        System.out.print("Enter the prices: ");
        double prices = scan.nextDouble();
        l.setPrices(prices);
    }
    
    public Laptop searchLaptopProducts(String brand, String model) {
        Laptop laptop = null, laptops = null;
        for (Inventory each: list) {
            if (each instanceof Laptop) {
                laptop = (Laptop)each;
                if (brand.equalsIgnoreCase(laptop.getBrand()) && model.equalsIgnoreCase(laptop.getModelLap())) {
                    laptops = (Laptop)each;
                    return laptops;
                }
            } 
        }
        return null;
    }
    
    public void exit() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press enter to go back/exits...");
        String input = scan.nextLine();
    }

    /** main method **/
    public static void main(String[] args) {

    }
}
