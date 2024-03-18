
    /**
 * Write a description of class Staff here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Staff 
{
    private String staffName;
    private String staffID;
    private String password;
    
    public Staff() {
        this.staffName = "";
        this.staffID = "";
        this.password = "";
    }
    
    public Staff(String sN, String sID, String pas) {
        this.staffName = sN;
        this.staffID = sID;
        this.password = pas;
    }
    
    public String getStaffName() {
        return this.staffName;
    }
    
    public String getStaffID() {
        return this.staffID;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setStaffName(String sN) {
        this.staffName = sN;
    }
    
    public void setStaffID(String sID) {
        this.staffID = sID;
    }
    
    public void setPassword(String pas) {
        this.password = pas;
    }
    
    //validate the password type
    public boolean isCorrectPassword() {
        boolean isValidPassword = true;
        if (this.password.length() <= 6 || this.password.length() >= 10) 
            isValidPassword = false;
        else if (this.password.charAt(0) != 'A' && this.password.charAt(0) != 'Z')
            isValidPassword = false;
        return isValidPassword;
    }
    
    public String toString() {
        return "Name: " + this.staffName + "\nStaff ID: " +this.staffID;
    }
}

