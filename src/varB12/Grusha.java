package varB12;

public class Grusha  extends Food {
    public Grusha() {
        super("Груша");
    }

    public double calculateCalories() {
        return 10000;
    }

    public void consume() {
        System.out.println(this + " Калорийности " + calculateCalories() + " съеден");
    }
}
