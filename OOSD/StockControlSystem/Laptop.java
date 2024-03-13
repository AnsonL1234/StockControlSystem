
/**
 * Write a description of class Laptop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Laptop extends Inventory
{
    private String tyOfLap;
    private String brand;
    
    public Laptop() {
        this.tyOfLap = "";
        this.brand = "";
    }
    
    public Laptop(int nOS, double p, String tOL, String b) {
        super(nOS,p);
        this.tyOfLap = tOL;
        this.brand = b;
    }
    
    public String getTyOfLap() {
        return this.tyOfLap;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public void setTyOfMob(String tOL) {
        this.tyOfLap = tOL;
    }
    
    public void setBrand(String b) {
        this.brand = b;
    }
    
    public double calculateTax() {
        return this.prices += (1 * 0.23);
    }
    
    public String toString() {
        return "Type of Mobile: " + this.tyOfLap +
        "\nBrand: " + this.brand + 
        "\nStock and Prices Detail...\n" + super.toString();
    }
}
