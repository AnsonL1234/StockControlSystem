import java.io.*;
/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Inventory implements Serializable
{
    protected int numOfStock;
    protected double prices;
    
    public Inventory() {
        this.numOfStock = 0;
        this.prices = 0;
    }
    
    public Inventory(int nOS, double p){
        this.numOfStock = nOS;
        this.prices = p;
    }
    
    public int getNumOfStock() {
        return this.numOfStock;
    }
    
    public double getPrices() {
       return this.prices; 
    }

    public void setNumOfStock(int nOS) {
        this.numOfStock = nOS;
    }
    
    public void setPrices(double p) {
        this.prices = p;
    }
    
    public abstract double calculateTax();
    
    public String toString() {
        return "Stock: " + this.numOfStock + "\nPrices: " + this.prices;
    }
}
