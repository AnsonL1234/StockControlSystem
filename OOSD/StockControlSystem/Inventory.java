import java.io.*;
/**
 * Write a description of class Inventory here.
 *
 * @Student Name: Anson Ling Guang Cheng
 * @Student Number: D22124534
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
    
    public String toString() {
        return 
        "\nStock    : " + this.numOfStock + 
        "\nPrices   : " + this.prices;
    }
    
    public abstract String toStockString();
}
