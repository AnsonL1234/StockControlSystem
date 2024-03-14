
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
        boolean isValidPassword = ((this.password.length() < 12) || (this.password.matches("[a-zA-Z]{6}\\d{6}")))?false:true;
        return isValidPassword = false;
    }
    
    //validate the password type
    public boolean isCorrectID() {
        boolean isValidID = ((this.staffID.length() < 8) || (this.password.matches("[A-Z]{1}\\d{7}")))?false:true;
        return isValidID = false;
    }
    
    public String toString() {
        return "Name: " + this.staffName + "\nStaff ID: " +this.staffID;
    }
}

