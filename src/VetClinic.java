import java.io.Serializable;
import java.util.ArrayList;


public class VetClinic implements Serializable {
    private String name;
    private ArrayList<Pet> pets;
	
    public VetClinic(String name) {
		this.pets = new ArrayList<Pet>();
        this.name = name;
    }
    

    public String getName(){
        return name;
    }

    public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

    public int totalPets(){
        return pets.size();
    }

    public void addPet(Pet newPet){
        this.pets.add(newPet);
    }
    
    public Pet searchPet(int petID){
       Pet foundPet = pets.stream()
       .filter(pet -> petID==pet.getId())
       .findAny()
       .orElse(null);
       return foundPet;
    }


    
}
