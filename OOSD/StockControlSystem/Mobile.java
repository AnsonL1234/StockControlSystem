
/**
 * Write a description of class Mobile here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public class Mobile extends Inventory
{
    private String tyOfProducts;
    private String brand;
    private String deviceModel;
    private String memoryOp;
    
    public Mobile() {
        this.tyOfProducts = "";
        this.brand = "";
        this.deviceModel = "";
        this.memoryOp = "";
    }
    
    public Mobile(String tOP, String b, String medM, String mmrOp, int nOS, double p) {
        super(nOS,p);
        this.tyOfProducts = tOP;
        this.brand = b;
        this.deviceModel =medM;
        this.memoryOp =mmrOp;
    }
    
    public Mobile(String tOP, String b, String devM, String mmrOp) {
        this.tyOfProducts = tOP;
        this.brand = b;
        this.deviceModel =devM;
        this.memoryOp =mmrOp;
    }
    
    public String getTyOfProducts() {
        return this.tyOfProducts;
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
    
    public void setTyOfMob(String tOP) {
        this.tyOfProducts = tOP;
    }
    
    public void setBrand(String b) {
        this.brand = b;
    }
    
    public void setDeviceModel(String devM) {
        this.deviceModel = devM;
    }
    
    public void setMemoryOP(String mmrOp) {
        this.memoryOp = mmrOp;
    }
    
    public String toString() {
        return 
        "Products : " + this.tyOfProducts +
        "\nBrand    : " + this.brand + 
        "\nModel    : " + this.deviceModel +
        "\nMemory   : " + this.memoryOp;
    }
    
    public String toStockString() {
        return 
        "Products : " + this.tyOfProducts +
        "\nBrand    : " + this.brand + 
        "\nModel    : " + this.deviceModel +
        "\nMemory   : " + this.memoryOp + 
        super.toString();
    }
}
