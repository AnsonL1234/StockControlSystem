import java.io.*;
/**
 * Write a description of class Inventory here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
 */
public abstract class Inventory implements Serializable
{
    private String nameProducts;
    protected int numOfStock;
    protected double prices;

    
    public Inventory() {
        this.nameProducts = "";
        this.numOfStock = 0;
        this.prices = 0;
    }
    
    public Inventory(String nP, int nOS, double p){
        this.nameProducts = nP;
        this.numOfStock = nOS;
        this.prices = p;
    }
    
    public String getNameProduct() {
        return this.nameProducts;
    }
    
    public int getNumOfStock() {
        return this.numOfStock;
    }
    
    public double getPrices() {
       return this.prices; 
    }
    
    public void setNameProduct(String nP) {
        this.nameProducts = nP;
    }

    public void setNumOfStock(int nOS) {
        this.numOfStock = nOS;
    }
    
    public void setPrices(double p) {
        this.prices = p;
    }
    
    //public abstract int addStock();
    
    //public abstract double calculateTax();
    
    public String toString() {
        return "Stock: " + this.numOfStock + "\nPrices: " + this.prices;
    }
}
