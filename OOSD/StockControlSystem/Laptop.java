
/**
 * Write a description of class Laptop here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public class Laptop extends Inventory
{
    private String tyOfLap;
    private String brand;
    private String modelLap;
    private int memoryOp;
    
    public Laptop() {
        this.tyOfLap = "";
        this.brand = "";
    }
    
    public Laptop(String nP, int nOS, double p, String tOL, String b) {
        super(nP,nOS,p);
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
    
    public int addStock() {
        return this.numOfStock;
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
