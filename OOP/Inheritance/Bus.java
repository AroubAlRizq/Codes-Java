

public class Bus extends BasicVehicle {
    
    private String driver;
    
    Bus(int wheels, int seats, int doors, String type, String driver){
        super(wheels, seats, doors,type);
        this.driver = driver;
    }
    public void setDriverName(String name){
        driver = name;
    }
    
    public String getDriverName(){
        return driver;
    }
    
    @Override
    public String toString(){
         return "\n"+super.toString()  + "\nDriver Name : " + driver + "\n";
    }
}
