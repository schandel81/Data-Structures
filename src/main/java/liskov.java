interface Vehicle {
    public void startEngine();
}
class Car implements Vehicle {
    public void startEngine() {
        System.out.println("Car Engine started");
    }
}
class Bicycle implements Vehicle {
    public void startEngine() {
        try {
            throw new Exception("No Engine");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class liskov {
}
