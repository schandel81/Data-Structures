import java.util.HashMap;
import java.util.Map;

interface Prof {

    public void getProfession();
}
class Doctor1 implements Prof {
    @Override
    public void getProfession() {
        System.out.println("Doctor1");
    }
}
class Engineer1 implements Prof {
    @Override
    public void getProfession() {
        System.out.println("Engineer1");
    }
}
class ProfessionCache {
    Map<String, Prof> map = new HashMap<>();
    void loadCahce() {
        map.put("Doctor", new Doctor1());
        map.put("Engineer", new Engineer1());
    }

    Prof getProfession(String prof) {
        switch (prof) {
            case "Doctor":
                return map.get("Doctor");
            case "Engineer":
                return map.get("Engineer");
            default:
                return null;
        }
    }
}

public class Prototype {
    public static void main(String [] args) {
        ProfessionCache pfc = new ProfessionCache();
        pfc.loadCahce();
        pfc.getProfession("Engineer").getProfession();
    }
}
