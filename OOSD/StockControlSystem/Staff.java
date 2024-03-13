
/**
 * Write a description of class Staff here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Staff extends Inventory
{
    private String staffName;
    private String staffID;
    private String password;
    
    public Staff() {
        this.staffName = "";
        this.password = "";
    }
    
    public Staff(String sN, String staffID, String pas) {
        this.staffName = sN;
        this.password = pas;
    }
    
    public String getStaffName() {
        return this.staffName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setStaffNaame(String sN) {
        this.staffName = sN;
    }
    
    public void setPassword(String pas) {
        this.password = pas;
    }
    
    public String toString() {
        return "Name: " + this.staffName + "\nStaff ID: " +this.staffID;
    }
}
