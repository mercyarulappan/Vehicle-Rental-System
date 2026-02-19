package VehicleRentalSystem;

import java.util.ArrayList;

public class UserService {
    static int customer_id=1;
    static ArrayList<User> userlist = new ArrayList<>();
    static {
        userlist.add(new User(123, "admin", "admin@gmail.com", 25, Role.valueOf("ADMIN")));  
    }
    void register(String name,String mailId,int age){
        userlist.add(new User(customer_id++, name, mailId, age, Role.valueOf("CUSTOMER")));
        System.out.println("Your Unique id is "+(customer_id-1));
    }
    public ArrayList<User> showAllBookings(){
        return (new ArrayList<>(userlist));
    }
    

    
}
