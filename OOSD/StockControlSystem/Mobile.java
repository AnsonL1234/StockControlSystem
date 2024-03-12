
/**
 * Write a description of class Mobile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mobile extends Inventory
{
    private String tyOfMob;
    private String brand;
    
    public Mobile() {
        this.tyOfMob = "";
        this.brand = "";
    }
    
    public Mobile(int nOS, double p, String tOM, String b) {
        super(nOS,p);
        this.tyOfMob = tOM;
        this.brand = b;
    }
    
    public String getTyOfMob() {
        return this.tyOfMob;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public void setTyOfMob(String tOM) {
        this.tyOfMob = tOM;
    }
    
    public void setBrand(String b) {
        this.brand = b;
    }
    
    public double calculateTax() {
        return this.prices += (1 * 0.23);
    }
    
    public String toString() {
        return "Type of Mobile: " + this.tyOfMob +
        "\nBrand: " + this.brand + 
        "\nStock and Prices Detail...\n" + super.toString();
    }
}
