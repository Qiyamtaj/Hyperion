public class RoleInfo {
    /// Attributes

    String name;
    String surname;
    String role;
    String telNum;
    String emailAddress;
    String physicalAddress;

    /// Methods
    public RoleInfo(String role, String name, String surname, String telNum, String emailAddress,
                    String physicalAddress)
    {
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.telNum = telNum;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;
    }


    public String toString(){
        String roleInfo = "Role: " + role;
        roleInfo += "\nFull name: " + name +" "+ surname;
        roleInfo += "\nTell no: " + telNum;
        roleInfo += "\nEmail address: " + emailAddress;
        roleInfo += "\nPhysical address : " + physicalAddress;

        return roleInfo;

    }

}
