import java.time.LocalDate;
import java.time.Period;

public class Cat extends Pet {
    private boolean allergic;

    public Cat(String name, double weight, LocalDate dob, boolean allergic) {
        super(name, weight, dob);
        this.allergic = allergic;
    }

    @Override
    double getDose() {
        LocalDate nowDate = LocalDate.now();
        long noOfDays = nowDate.toEpochDay() - this.getDob().toEpochDay();
        long age = (noOfDays /30)/12;
        if (allergic) {
            return 0;
        } else if (age > 3 && this.getWeight() > 0.5) {
            return 7 + (0.61 * this.getWeight());
        } else {
            return 0.81 * this.getWeight();
        }

    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "weight: " + this.getWeight() + " dob: " + this.getDob() + "isAllergic: "+ allergic;
    }

    public boolean getIsAllergic(){
        return allergic;
    }
}
