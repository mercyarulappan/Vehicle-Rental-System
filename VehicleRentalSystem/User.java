package VehicleRentalSystem;

public class User {
    private int user_id;
    private String name;
    private String mailId;
    private int age;
    private Role role;

    public User(int user_id, String name, String mailId, int age, Role role) {
        this.user_id = user_id;
        this.name = name;
        this.mailId = mailId;
        this.age = age;
        this.role = role;
    }
    public int getUserId() 
    {
        return user_id;
    }
    public Role getRole(){
        return role;
    }
    @Override
    public String toString(){
        return(
            "User id: "+user_id+"\nName: "+name+
            "\n--------------------------------------"
        );
    }
 
}
enum Role{
    ADMIN,
    CUSTOMER
}

