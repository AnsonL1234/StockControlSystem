
/**
 * Write a description of class Mobile here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public class Mobile extends Inventory
{
    private String tyOfMob;
    private String brand;
    private String modelMob;
    private String memoryOp;
    
    public Mobile() {
        this.tyOfMob = "";
        this.brand = "";
        this.modelMob = "";
        this.memoryOp = "";
    }
    
    public Mobile(String tOM, String b, String medM, String mmrOp, int nOS, double p) {
        super(nOS,p);
        this.tyOfMob = tOM;
        this.brand = b;
        this.modelMob =medM;
        this.memoryOp =mmrOp;
    }
    
    public Mobile(String tOM, String b, String medM, String mmrOp) {
        this.tyOfMob = tOM;
        this.brand = b;
        this.modelMob =medM;
        this.memoryOp =mmrOp;
    }
    
    public String getTyOfMob() {
        return this.tyOfMob;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public String getModelMob() {
        return this.modelMob;
    }
    
    public String getMemoryOp() {
        return this.memoryOp;
    }
    
    public void setTyOfMob(String tOM) {
        this.tyOfMob = tOM;
    }
    
    public void setBrand(String b) {
        this.brand = b;
    }
    
    public String toString() {
        return "Type of Mobile: " + this.tyOfMob +
        "\nBrand: " + this.brand + 
        "\n\nStock and Prices Detail...\n\n" + super.toString();
    }
}
