import java.time.LocalDate;

public class Dose {
    private String nameOfDrug;
    private LocalDate date;
    private double doseInMilliGrams;

    public Dose(String nameOfDrug, double doseQuantity) {
        this.nameOfDrug = nameOfDrug;
        this.date = LocalDate.now();
        this.doseInMilliGrams = doseQuantity;
    }

    public String getDrugName() {
        return nameOfDrug;
    }

    public void setDrugName(String nameOfDrug) {
        this.nameOfDrug = nameOfDrug;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    public double getDoseInMg() {
        return doseInMilliGrams;
    }

    public void setDoseInMg(double newDoseInMilliGrams) {
        this.doseInMilliGrams = newDoseInMilliGrams;
    }

    @Override
    public String toString() {
        return "Name: " + nameOfDrug + "Date: " + date + " mg: " + doseInMilliGrams;
    }

}
