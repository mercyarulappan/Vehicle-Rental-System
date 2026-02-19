package VehicleRentalSystem;

import java.util.ArrayList;

public class UserService {
    static int customer_id=1;
    
     ArrayList<User> userlist = new ArrayList<>();
    {
        userlist.add(new User(123, "admin", "admin@gmail.com", 25, Role.valueOf("ADMIN")));  
    }
    void register(String name,String mailId,int age){
        User user = new User(customer_id++, name, mailId, age, Role.valueOf("CUSTOMER"));

        userlist.add(user);

        Session.currentUser = user;
        System.out.println("Your Unique id is "+(customer_id-1));
    }
    public User getCurrentUser(){
        return Session.currentUser;
    }
    public ArrayList<User> showAllBookings(){
        if(userlist.size()<2){
            System.out.println("Not rented yet");
        }
        ArrayList<User> res = new ArrayList<>();
        for(User u: userlist){
            if(u.getRole().equals(Role.valueOf("CUSTOMER")))
                res.add(u);
        }
        return res;
    }
    
    public User getUserById(int user_id){
        for(User u: userlist){
            if(u.getUserId()==user_id) return u;
        }
        return null;

    }
    

    
}
