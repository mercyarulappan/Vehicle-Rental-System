package VehicleRentalSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentalService {
    private int rent_id=0;
    Session session = new Session();
    ArrayList<Rental> bookinglist = new ArrayList<>();
    VehicleService vs;
    UserService us;
    public RentalService(VehicleService vs,UserService us){
        this.vs = vs;
        this.us = us;
    }
    public void bookVehicle(int vehicle_id,int days){
        Vehicle v = vs.getVehicleById(vehicle_id);
        if(v==null){
            System.out.println("Vehicle not found...Enter available vehicle id");
            return;
        }
        if(!v.availability()){
            System.out.println("Vehicle is not available for now!! Choose other");
            return;
        }
        int user_id = us.getCurrentUser().getUserId();
        if(us.getUserById(user_id)==null){
            System.out.println("User Not Registered.");
            return;
        }
        session.currentUser = us.getCurrentUser();
        int total = days*v.getPrice();
        v.setAvailability(false);
        bookinglist.add(new Rental(rent_id++, user_id, vehicle_id,LocalDateTime.now(),"BOOKED", days,total));
        System.out.println("Vehicle Rented");
        System.out.println("Total: " + total);
        
    }
    public ArrayList<Rental> myBookings(){
        ArrayList<Rental> res = new ArrayList<>();
        for(Rental r: bookinglist){
            if(r.getUserId() == session.currentUser.getUserId()) res.add(r);
        }
        return res;
    }
    public ArrayList<Rental> viewAllBookings(){
        return new ArrayList<>(bookinglist);
    }
    public void returnVehicle(int vehicle_id){
        Vehicle v = vs.getVehicleById(vehicle_id);
        if(v!=null && !v.availability()){
            v.setAvailability(true);
            for(Rental r : bookinglist){
                if(r.getVehicleId()==vehicle_id && r.getUserId()==session.currentUser.getUserId())
                    r.setStatus("RETURNED");
            }
            System.out.println("Vehicle Returned!");
        }
        else{
            System.out.println("Not found");
        }
    }
}
