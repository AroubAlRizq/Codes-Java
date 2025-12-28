
public class TestApplication {
    
    public static void main(String[] args) {
    
    BasicVehicle car = new Car(4,5,2,"Car");
    BasicVehicle bus = new Bus(35,6,4,"Bus", "Bob Smith");
    System.out.print(car.toString());
    System.out.print(bus.toString());
    
    
}
}
