interface calculate<T> {
    public double calculateOperation(T a, T b, Character operation);
}

class calculateAddSubOperation implements calculate {

    @Override
    public double calculateOperation(Object a, Object b, Character e) {
        Integer c = (Integer)a;
        Integer d = (Integer)b;
        switch (e) {
            case '+':
                return c + d;
            case '-':
                return c - d;
            default:
                return 0;
        }
    }
}

class calculateDivMulOperation implements calculate {
    @Override
    public double calculateOperation(Object a, Object b, Character e) {
        switch (e) {
            case '*':
                return (Integer)a * (Integer)b;
            case '/':
                return (Integer)a / (Integer)b;
            default:
                return 0;
        }
    }
}
public class OpenToExtension {

}
