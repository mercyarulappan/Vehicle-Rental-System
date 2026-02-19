package VehicleRentalSystem;

public class Vehicle {
    private int vehicle_id;
    private VehicleType vehicleType;
    private int price_per_hr;
    private boolean isAvailable;

    public Vehicle() {
        vehicle_id=0;
        vehicleType=null;
        price_per_hr=10;
        isAvailable=true;

    }
    
    Vehicle(int id, VehicleType type, int price, boolean isAvailable){
        vehicle_id=id;
        vehicleType=type;
        price_per_hr=price;
        this.isAvailable=isAvailable;
    }
    public int getId(){
        return vehicle_id;
    }
    public VehicleType getType(){
        return vehicleType;
    }
    public int getPrice(){
        return price_per_hr;
    }
    public boolean availability(){
        return isAvailable;
    }
    public void setAvailability(boolean avail){
        this.isAvailable = avail;
    }
    public void setType(VehicleType type){
        this.vehicleType=type;
    }
    public void setRate(int rate){
        this.price_per_hr=rate;
    }

    @Override
    public String toString(){
        return(
            vehicle_id+"   "+vehicleType+"  "+price_per_hr+"  "+(isAvailable?"Available now":"Not available now")
        );
    }

    





    
}
