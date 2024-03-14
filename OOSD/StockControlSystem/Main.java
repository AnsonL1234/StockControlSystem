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

    // 6. customer menu option 1 - display all the mobile that is for sale
    public void cusrtomerOption1() {
        Mobile mobile = null;
        System.out.println("==========================");
        System.out.println("**** Mobile Sales List ***");
        for (Inventory each: list) {
            mobile = (Mobile) each;
        }
        if (mobile != null) {
            System.out.println("\n==========================");
            try {
                BufferedReader reader = new BufferedReader (new FileReader(this.finalFile));
                String line = "";
                while ((line == reader.readLine())) {
                    System.out.println(reader.readLine());
                    reader.close(); //close the reader
                }   
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\n*** No stock on list ***\n");
        }
        System.out.println("*********** End **********");
        System.out.println("==========================");
        exit();
    }

    // 7. customer menu option 2 - display all the laptop that is for sale
    public void cusrtomerOption2() {
        Laptop laptop = null;
        System.out.println("==========================");
        System.out.println("**** Laptop Sales List ***");
        for (Inventory each: list) {
            laptop = (Laptop) each;
        }
        if (laptop != null) {
            System.out.println("\n==========================");
            try {
                BufferedReader reader = new BufferedReader (new FileReader(this.finalFile));
                String line = "";
                while ((line == reader.readLine())) {
                    System.out.println(reader.readLine());
                    reader.close(); //close the reader
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\n*** No stock on list ***\n");
        }
        System.out.println("*********** End **********");
        System.out.println("==========================");
        exit();
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
                askStaffMenuOption();
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

    public void askStaffMenuOption() {
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
                case 1:staffMenuOption1();break;
                case 4:mainMenu();break;
            }
        } while ((staffOption != 4) || !isValidStaffOption);
        System.out.println("==========================");
    }
    /** 11. menu option 2 - end here **/
    
    /** 12. staff menu option 1**/
    public void staffMenuOption1() {
        Scanner scan = new Scanner(System.in);
        Mobile mobile = null;
        String brand = "", model = "", memoryOption = "";
        System.out.print("Enter the brand: ");
        brand = scan.nextLine();
        System.out.print("Enter the model: ");
        model = scan.nextLine();
        System.out.print("Enter the memoryOption: ");
        memoryOption = scan.nextLine();
        mobile = new Mobile("Mobile",brand,model,memoryOption);
        list.add(mobile);
        
        String[] header = {"Type of Products","Brand","Model","Memory"};//put them in order
        String separator = ",";
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.finalFile))){
            
            String[] line = {mobile.getTyOfMob(), mobile.getBrand(), mobile.getModelMob(), mobile.getMemoryOp()};
            writer.println(String.join(separator,header)); 
            //do {
                writer.println(String.join(separator,line));
            //}while (xy == 'y');
            writer.close(); //close the writer
        }catch(IOException e) {
            e.printStackTrace();
        } 
    }
    
    public void staffMenuIOption2() {
        Scanner scan = new Scanner(System.in);
        Laptop laptop = null;
        String brand = "", model = "", memory = "";
        System.out.print("Enter the brand: ");
        brand = scan.nextLine();
        System.out.print("Enter the model: ");
        model = scan.nextLine();
        System.out.print("Enter the memoryOption: ");
        memory = scan.nextLine();
        laptop = new Laptop("Laptop",brand,model,memory);
        list.add(laptop);
        
        String[] HeadList = {"Type of Products","Brand","Model","Memory"};
        String splite = ",";
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.finalFile))) {
            String[] item = {laptop.getTyOfLap(),laptop.getBrand(),laptop.getModelLap(),laptop.getMemoryOp()};
            writer.println(String.join(splite,HeadList)); //seprate the head title data by ", " in order
            writer.println(String.join(splite,item)); //seprate the actual value data by ", " in order
        }catch (IOException e) {
            e.printStackTrace();
        }
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
