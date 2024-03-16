
/**
 * Write a description of class Laptop here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public class Laptop extends Inventory
{
    private String tyOfProduct;
    private String brand;
    private String modelLap;
    private String memoryOp;
    
    public Laptop() {
        this.tyOfProduct = "";
        this.brand = "";
        this.modelLap = "";
        this.memoryOp = "";
    }
    
    public Laptop(String tOL, String b, String mL, String mO, int nOS, double p) {
        super(nOS,p);
        this.tyOfProduct = tOL;
        this.brand = b;
        this.modelLap = mL;
        this.memoryOp = mO;
    }
    
    public Laptop(String tOL, String b, String mL, String mO) {
        this.tyOfProduct = tOL;
        this.brand = b;
        this.modelLap = mL;
        this.memoryOp = mO;
    }
    
    public String getTyOfLap() {
        return this.tyOfProduct;
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
        this.tyOfProduct = tOL;
    }
    
    public void setBrand(String b) {
        this.brand = b;
    }
    
    public String toString() {
        return 
        "Products : " + this.tyOfProduct +
        "\nBrand    : " + this.brand + 
        "\nModel    : " + this.modelLap +
        "\nMemory   : " + this.memoryOp;
    }
    
    public String toStockString() {
        return 
        "Products : " + this.tyOfProduct +
        "\nBrand    : " + this.brand + 
        "\nModel    : " + this.modelLap +
        "\nMemory   : " + this.memoryOp +
        super.toString();
    }
}
