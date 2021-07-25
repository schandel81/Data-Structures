interface Profession {
    public void getProfession();
}
class Engineer implements Profession {
    @Override
    public void getProfession() {
        System.out.println("Engineer");
    }
}
class Doctor implements Profession {
    @Override
    public void getProfession() {
        System.out.println("Doctor");
    }
}
public class Factory {
    void getProfession(String prof) {
        if(prof.equalsIgnoreCase("Doctor")) {
            Profession d = new Doctor();
            d.getProfession();
        }
        else if(prof.equalsIgnoreCase("Engineer")) {
            Profession d = new Doctor();
            d.getProfession();
        }
    }
}
class Test {
    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.getProfession("doctor");
    }
}