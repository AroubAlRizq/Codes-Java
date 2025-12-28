


public abstract class BasicVehicle implements Vehicle {
  private int noOfSeats;
  private int noOfWheels;
  private int noOfDoors;
  private String type;
  
   BasicVehicle(int wheels, int seats, int doors, String type){
        
       this.noOfWheels = wheels;
       this.noOfSeats = seats;
       this.noOfDoors = doors;
       this.type = type;
    }
 
   public int getnoOfDoors(){
       return noOfDoors;
   }
   
  @Override
   public int getNoOfseats(){
       return noOfSeats;
   }
   
  @Override
   public int getNoOfWheels(){
       return noOfWheels;
   }
   
   @Override
   public String getType(){
       return type;
   }
   
  @Override
   public String toString(){
       
       return "Type: " + type + "\nNumber of Wheels : " + noOfWheels + "\nNumber of Seats : " + noOfSeats + "\nNumber of Doors : " + noOfDoors;
   }
}
