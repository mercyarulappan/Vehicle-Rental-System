package VehicleRentalSystem;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();
    static VehicleService vehicleService = new VehicleService();
    static RentalService rentalService = new RentalService(vehicleService,userService);
    
    public static void main(String[] args) {
        

        System.out.println("Welcome to Vehicle Rental System!");
         while (true) { 
        System.out.println("Select the role:");
        System.out.println("1.Admin\n2.Customer\n3.Exit");
        int input = sc.nextInt();
       
            switch(input){
                case 1: adminMenu();
                        break;
                case 2: customerMenu();
                        break;
                case 3: 
                System.out.println("Exitted");
                return;
            }
        
        }

    }
    static void adminMenu(){
        while(true){
        System.out.println("1.Add Vehicle");
        System.out.println("2.UpdateVehicle");
        System.out.println("3.View Customers");
        System.out.println("4.View All bookings");
        System.out.println("5.View All Vehicles");
        System.out.println("6.Back");
        int input = sc.nextInt();
        switch(input){
            case 1:
                System.out.println("Enter the Vehicle type:(BIKE,SCOOTY,CAR) ");
                String type = sc.next().toUpperCase();
                if(!(type.equals("BIKE")|| type.equals("SCOOTY")||type.equals("CAR")))
                {
                    System.out.println("Enter valid type");
                    break;
                }
                System.out.println("Enter the rate:");
                int rate = sc.nextInt();
                vehicleService.addVehicle(type, rate);
                break;
            case 2:
                updateVehicles();
                break;
            case 3:
                if(userService.userlist.size()<2) System.out.println("No one regitered yet");
                else{
                System.out.println("Customers are....");
                userService.showAllBookings().forEach(booking->System.out.println(booking));
                }
                break;
            case 4:
                if(rentalService.bookinglist.isEmpty()) System.out.println("No one booked");
                else rentalService.viewAllBookings().forEach(booking->System.out.println(booking));
                break;
            case 5:
                vehicleService.viewAllVehicles().forEach(vehicle->System.out.println(vehicle));
                System.out.println("Available vehicles:");
                break;
            case 6: 
            System.out.println("Going to menu page");
            return;
        }
    }


    }
    static void customerMenu(){
        while(true){
        System.out.println("1.Register");
        System.out.println("2.View available vehicles");
        System.out.println("3.View all vehicles");
        System.out.println("4.RentVehicle");
        System.out.println("5.ReturnVehicle");
        System.out.println("6.ViewMyBookings");
        System.out.println("7.Exit");
        int input = sc.nextInt();
        switch(input){
            case 1:
                System.out.println("Enter you name: ");
                 String name = sc.next();
                System.out.println("Enter your mail id: ");
                String mailId = sc.next();
                System.out.println("Enter you age: ");
                int age = sc.nextInt();
                userService.register(name, mailId, age);
                System.out.println("Registered Successfully!");
                break;
            case 2:
                
                System.out.println("Available vehicles are...");
                vehicleService.viewAvailableVehicles().forEach(availableVehicles->System.out.println(availableVehicles));
                break;
            case 3:
                System.out.println("All vehicles list:");
                vehicleService.viewAllVehicles().forEach(vehicle->System.out.println(vehicle));
                break;
            case 4:
                if(Session.currentUser==null) {System.out.println("Register first to rent vehicle");return;}
                System.out.println("Enter vehicle id you want to book:");
                int veh_id = sc.nextInt();
                System.out.println("Enter the days: ");
                int days = sc.nextInt();
                rentalService.bookVehicle(veh_id, days);
                break;
            case 5:
                if(Session.currentUser==null) {System.out.println("Register first to return vehicle");return;}
                if(rentalService.bookinglist.isEmpty()) System.out.println("Not rented yet");
                else{
                System.out.println("Enter the vehicle id: ");
                int v_id = sc.nextInt();
                rentalService.returnVehicle(v_id);
                }
                break;
            case 6:
                if(Session.currentUser==null) {System.out.println("Register first to see bookings"); return;}
                if(rentalService.bookinglist.isEmpty()) System.out.println("Not rented yet");
                else{
                System.out.println("My Bookings:");
                rentalService.myBookings().forEach(mybooks->System.out.println(mybooks));
                }
                break;
            case 7: 
            System.out.println("Going to menu page");
            return;

            
        }
    }
    }


static void updateVehicles(){
    while(true){
    System.out.println("Enter vehicle id: ");
    int vehicle_id = sc.nextInt();
    System.out.println("Enter the status/feature to update of an vehicle: ");
    System.out.println("1.Type\n2.Rate\n3.Availability\n");
    int inpuString = sc.nextInt();
    switch (inpuString) {
        case 1:
            System.out.println("Enter type to change");
            String new_type = sc.next();
            vehicleService.updateVehicleType(vehicle_id, new_type);
            return;
        case 2:
            System.out.println("Enter new rate");
            int new_rate = sc.nextInt();
            vehicleService.updateVehicleRate(vehicle_id, new_rate);
            return;
        case 3:
            System.out.println("1.Available\n2.Not Available");
            int avail_num = sc.nextInt();
            availabilitychange(avail_num, vehicle_id);
            return;
        default:
            System.out.println("Enter valid one to update");
            return;
    }
    }

}
static void availabilitychange(int num,int vehicle_id){
    if(num==1) vehicleService.updateVehicleAvailability(vehicle_id, true);
    else if(num==2) vehicleService.updateVehicleAvailability(vehicle_id, false);
    else {
        System.out.println("Enter valid num");
        return;
    }
}
}
