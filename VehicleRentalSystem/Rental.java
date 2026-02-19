package VehicleRentalSystem;

import java.time.LocalDateTime;

public class Rental {
    private int rent_id;
    private int user_id;
    private int vehicle_id;
    private LocalDateTime date;
    private String rental_status;
    private int days;
    private int total;


    public Rental() {
        rent_id=0;
        user_id=0;
        vehicle_id=0;
        date= LocalDateTime.now();
        days=0;
        total=0;
    }

    public Rental(int rent_id, int user_id, int vehicle_id, LocalDateTime date, String rental_status,int days,int total) {
        this.rent_id = rent_id;
        this.user_id = user_id;
        this.vehicle_id = vehicle_id;
        this.date = date;
        this.rental_status = rental_status;
        this.days=days;
        this.total=total;
    }
    public void setTotal(int total){
        this.total=total;
    }
    public int getRentId(){
        return rent_id;
    }
    public int getUserId(){
        return user_id;
    }
    public int getDays(){
        return days;
    }
    public int getTotal(){
        return total;
    } 
    public int getVehicleId(){
        return vehicle_id;
    }
    public void setStatus(String status){
        this.rental_status = status;
    }
    public String toString(){
        return(
            rent_id+"  "+user_id+"  "+vehicle_id+" "+date+" "+rental_status+" "+days+" "+total
        );
    } 
}

