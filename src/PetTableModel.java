
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class PetTableModel extends AbstractTableModel{
    	
    private static final String[] colHeader = {"ID", "Name", "Weight(kg)","Age(month)", "D.O.B", "Accumulated Pet (mg)", "Breed", "Allergic"};
    
    private ArrayList<Pet> pets;

    public PetTableModel(ArrayList<Pet> pets, int sortIndex) {
        setPets(pets);
    }

    public void setPets(ArrayList<Pet> pets)  {
        this.pets = pets;
    }

    @Override
    public int getRowCount() {
        return pets.size();		
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        boolean isCat =false;
        Pet thePet = (Pet) pets.get(rowIndex);
        
        if(thePet  instanceof Cat){
            isCat = true;
            Cat cat = (Cat)thePet;
            switch(columnIndex)
            {
                case 0: return cat.getId();
                case 1: return cat.getName();
                case 2: return cat.getWeight();
                case 3: return cat.findAge();
                case 4: return cat.getDob();
                case 5: return cat.getDose();
                case 6: return "-";
                case 7: return cat.getIsAllergic()?"Yes":"No";

                default: return "-";
            }
        }else{
            isCat = false;
            Dog dog = (Dog)thePet;

            switch(columnIndex)
            {
                case 0: return dog.getId();
                case 1: return dog.getName();
                case 2: return dog.getWeight();
                case 3: return dog.findAge();
                case 4: return dog.getDob();
                case 5: return dog.getDose();
                case 6: return dog.getBreed();
                case 7: return "-";

                default: return "-";
            }
        }
       
    }
   
    @Override
    public String getColumnName(int column){
    	return colHeader[column];
    }

}

 
