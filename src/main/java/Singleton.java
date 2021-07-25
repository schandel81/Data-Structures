public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
    public void display() {
        //Some other method
    }
}
