package VehicleRentalSystem;

import java.util.ArrayList;

public class VehicleService {
    private int vehicle_ctr=5;
    private ArrayList<Vehicle> vehiclesList = new ArrayList<>();
    {
        vehiclesList.add(new Vehicle(1, VehicleType.BIKE, 10, true));
        vehiclesList.add(new Vehicle(2, VehicleType.SCOOTY, 20, true));
        vehiclesList.add(new Vehicle(3, VehicleType.BIKE, 30, true));
        vehiclesList.add(new Vehicle(4, VehicleType.CAR, 40, true));
    }

    public ArrayList<Vehicle> viewAllVehicles(){
        return new ArrayList<>(vehiclesList);
    }
    public ArrayList<Vehicle> viewAvailableVehicles(){
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v : vehiclesList)
        {
            if(v.availability()) res.add(v);
        }
        return res;
    }
    public Vehicle getVehicleById(int id){
        for(Vehicle v: vehiclesList){
            if(v.getId()==id) return v;
        }
        return null;
    }
    public void addVehicle(String type, int price){
        vehiclesList.add(new Vehicle(vehicle_ctr++, VehicleType.valueOf(type), price, true));
        System.out.println("New Vehicle Added");
    }
    public void updateVehicleType(int vehicle_id,String type ){
        for(Vehicle v : vehiclesList){
            if(v.getId()==vehicle_id){
                v.setType(VehicleType.valueOf(type.toUpperCase()));
                System.out.println("Type updated for vehicle - "+vehicle_id);
                return;
            }
        }
         System.out.println("Vehicle Not found");


    }
    public void updateVehicleRate(int vehicle_id,int rate ){
        for(Vehicle v : vehiclesList){
            if(v.getId()==vehicle_id){
                v.setRate(rate);
                System.out.println("Rate updated for vehicle - "+vehicle_id);
                return;
            }
            
           
        }
         System.out.println("Vehicle Not found");



    }
    public void updateVehicleAvailability(int vehicle_id,boolean availability){
        for(Vehicle v : vehiclesList){
            if(v.getId()==vehicle_id){
                v.setAvailability(availability);
                System.out.println("Availability updated for vehicle - "+vehicle_id);
                return;
            }
            
        }
         System.out.println("Vehicle Not found");


    }
    
}
