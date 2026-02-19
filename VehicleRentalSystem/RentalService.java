package VehicleRentalSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentalService {
    private int rent_id=0;
    static private int currentUser=0;
    static ArrayList<Rental> bookinglist = new ArrayList<>();
    public void bookVehicle(int user_id,int vehicle_id,int days){
        Vehicle v = VehicleService.getVehicleById(vehicle_id);
        if(v==null){
            System.out.println("Vehicle not found...Enter available vehicle id");
            return;
        }
        if(!v.availability()){
            System.out.println("Vehicle is not available for now!! Choose other");
            return;
        }
        currentUser = user_id;
        int total = days*v.getPrice();
        v.setAvailability(false);
        bookinglist.add(new Rental(rent_id++, user_id, vehicle_id,LocalDateTime.now(),"BOOKED", days,total));
        System.out.println("Vehicle Rented");
        System.out.println("Total: " + total);
        
    }
    public ArrayList<Rental> myBookings(){
        System.out.println(currentUser);
        ArrayList<Rental> res = new ArrayList<>();
        for(Rental r: bookinglist){
            if(r.getUserId() == currentUser) res.add(r);
        }
        return res;
    }
    public void returnVehicle(int vehicle_id){
        Vehicle v = VehicleService.getVehicleById(vehicle_id);
        if(v!=null && !v.availability()){
            v.setAvailability(true);
            for(Rental r : bookinglist){
                if(r.getVehicleId()==vehicle_id && r.getUserId()==currentUser)
                    r.setStatus("RETURNED");
            }
            System.out.println("Vehicle Returned!");
        }
        else{
            System.out.println("Not found");
        }
    }
}
