
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
    private String memoryOp;
    
    public Laptop() {
        this.tyOfLap = "";
        this.brand = "";
        this.modelLap = "";
        this.memoryOp = "";
    }
    
    public Laptop(String nP, int nOS, double p, String tOL, String b, String mL, String mO) {
        super(nP,nOS,p);
        this.tyOfLap = tOL;
        this.brand = b;
        this.modelLap = mL;
        this.memoryOp = mO;
    }
    
    public Laptop(String tOL, String b, String mL, String mO) {
        this.tyOfLap = tOL;
        this.brand = b;
        this.modelLap = mL;
        this.memoryOp = mO;
    }
    
    public String getTyOfLap() {
        return this.tyOfLap;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public String getModelLap() {
        return this.modelLap;
    }
    
    public String getMemoryOp() {
        return this.memoryOp;
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
