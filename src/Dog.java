import java.time.LocalDate;
import java.time.Period;

public class Dog extends Pet {
    private String breed;
    public Dog(String name, double weight, LocalDate dob,String breed) {
        super(name, weight, dob);
        this.breed = breed;
    }



    
    @Override
    double getDose() {
        LocalDate nowDate = LocalDate.now();
        long noOfDays = nowDate.toEpochDay() - this.getDob().toEpochDay();
        long age = (noOfDays /30)/12;
        double weightInkgs = (this.getWeight()/1000);
       if(age < 3){
            return 0;
        }else if(age>12 && weightInkgs <2){
            return 0.81 * this.getWeight();
        }else{
           return 12 + 0.65 * this.getWeight();
        }

    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "weight: " + this.getWeight() + " dob: " + this.getDob() + "breed: "+ breed;
    }

    public String getBreed(){
        return breed;
    }

}
