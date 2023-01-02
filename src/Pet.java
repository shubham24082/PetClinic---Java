import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public abstract class Pet {
    private int petID;
    private String name;
    private double weight;
    private LocalDate dob;
    private List<Dose> doses;

    public Pet(String name, double weight, LocalDate dob) {
        this.name = name;
        this.weight = weight;
        this.dob = dob;

        Random r = new Random();
        this.petID = r.nextInt(1000 - 10) + 10;
        this.doses = new ArrayList<Dose>();
    }

    public int findAge() {
        LocalDate nowDate = LocalDate.now();
        long noOfDays = nowDate.toEpochDay() - dob.toEpochDay();
        int noOfMonths = (int) (noOfDays/30);
        System.out.println("month diff is "+noOfMonths);
        return noOfMonths;
    }

    public void addDose(Dose newDose) {
        this.doses.add(newDose);
    }

    abstract double getDose();
    
    public double getAccumulatedDose() {
        double totalDoseInMg = doses.stream()
                .mapToDouble(dose -> dose.getDoseInMg())
                .sum(); // sum all doses mg and return
        return Math.round(totalDoseInMg);
    }

    public int getId(){
        return petID;
    }

    // accesors for name field
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    // accesors for weight field
    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    // accesors for dob field
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate newDob) {
        this.dob = newDob;
    }


    @Override
    public String toString() {
        return "Name: " + name + "weight: " + weight + " dob: " + dob;
    }

}
