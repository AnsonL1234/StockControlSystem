
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
    private String deviceModel;
    private String memoryOp;
    
    public Laptop() {
        this.tyOfProduct = "";
        this.brand = "";
        this.deviceModel = "";
        this.memoryOp = "";
    }
    
    public Laptop(String tOL, String b, String mL, String mO, int nOS, double p) {
        super(nOS,p);
        this.tyOfProduct = tOL;
        this.brand = b;
        this.deviceModel = mL;
        this.memoryOp = mO;
    }
    
    public Laptop(String tOL, String b, String devM, String mO) {
        this.tyOfProduct = tOL;
        this.brand = b;
        this.deviceModel = devM;
        this.memoryOp = mO;
    }
    
    public String getTyOfProducts() {
        return this.tyOfProduct;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public String getDeviceModel() {
        return this.deviceModel;
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
    
    public void setDeviceModel(String devM) {
        this.deviceModel = devM;
    }
    
    public void setMemoryOp(String mmrOp) {
        this.memoryOp = mmrOp;
    }
    
    public String toString() {
        return 
        "Products : " + this.tyOfProduct +
        "\nBrand    : " + this.brand + 
        "\nModel    : " + this.deviceModel +
        "\nMemory   : " + this.memoryOp;
    }
    
    public String toStockString() {
        return 
        "Products : " + this.tyOfProduct +
        "\nBrand    : " + this.brand + 
        "\nModel    : " + this.deviceModel +
        "\nMemory   : " + this.memoryOp +
        super.toString();
    }
}
