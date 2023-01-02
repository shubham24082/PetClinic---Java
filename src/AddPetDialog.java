
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Checkbox; 

public class AddPetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDialog dialog = this;
	private VetClinic clinic;


	private JTextField petNameTf;
	private JTextField petWeightTf;
	private Checkbox isAllergicCb;
	private JTextField breedTf;

	private JRadioButton rdBtnCat;
	private JRadioButton rdBtnDog;

	private JLabel lblBreed;
	private JLabel lblIsAllergic;
	private JLabel lblType;
	private JComboBox<String> dateCB;
	private JComboBox<String> monthCB;
	private JComboBox<String> yearCB;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPetDialog dialog = new AddPetDialog(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPetDialog(VetClinic clinicRef, boolean modal) {
		clinic = clinicRef;
		
		setTitle("Add Pet");
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPetName = new JLabel("Pet Name:");
			lblPetName.setHorizontalAlignment(SwingConstants.LEFT);
			lblPetName.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			lblPetName.setBounds(55, 50, 80, 20);
			contentPanel.add(lblPetName);
		}
		{
			JLabel lblPetWeight = new JLabel("Weight:");
			lblPetWeight.setHorizontalAlignment(SwingConstants.LEFT);
			lblPetWeight.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			lblPetWeight.setBounds(55, 95, 80, 20);
			contentPanel.add(lblPetWeight);
		}
		{
			JLabel lblPetDob = new JLabel("Dob:");
			lblPetDob.setHorizontalAlignment(SwingConstants.LEFT);
			lblPetDob.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			lblPetDob.setBounds(55, 140, 80, 20);
			contentPanel.add(lblPetDob);
		}
		{
			 lblBreed = new JLabel("Breed:");
			lblBreed.setHorizontalAlignment(SwingConstants.LEFT);
			lblBreed.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			lblBreed.setBounds(55, 185, 80, 20);
			contentPanel.add(lblBreed);
		}
		{
			 lblIsAllergic = new JLabel("Allergic:");
			lblIsAllergic.setHorizontalAlignment(SwingConstants.LEFT);
			lblIsAllergic.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			lblIsAllergic.setBounds(55, 230, 80, 20);
			contentPanel.add(lblIsAllergic);
		}
		
		
		
		petNameTf = new JTextField();
		petNameTf.setBounds(155, 50, 200, 20);
		contentPanel.add(petNameTf);
		petNameTf.setColumns(10);
		
		petWeightTf = new JTextField();
		petWeightTf.setColumns(10);
		petWeightTf.setBounds(155, 95, 200, 20);
		contentPanel.add(petWeightTf);
		
		isAllergicCb = new Checkbox("Yes");    
        isAllergicCb.setBounds(200, 215,  50, 50); 
		isAllergicCb.setEnabled(false);   
		contentPanel.add(isAllergicCb);

		breedTf = new JTextField();
		breedTf.setBounds(155, 185, 200, 20);
		breedTf.setColumns(10);
		contentPanel.add(breedTf);

		lblType = new JLabel("Type:");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblType.setBounds(55, 280, 80, 20);
		contentPanel.add(lblType);

		
		rdBtnDog = new JRadioButton("Dog");
		rdBtnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdBtnCat.setSelected(false);
				lblBreed.setEnabled(true);
				breedTf.setEnabled(true);
				lblIsAllergic.setEnabled(false);
				isAllergicCb.setEnabled(false);
			}
		});

		rdBtnDog.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtnDog.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		rdBtnDog.setBounds(100, 280, 100, 23);
		contentPanel.add(rdBtnDog);
					
		rdBtnCat = new JRadioButton("Cat");
		rdBtnCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdBtnDog.setSelected(false);
				lblIsAllergic.setEnabled(true);
				isAllergicCb.setEnabled(true);
				lblBreed.setEnabled(false);
				breedTf.setEnabled(false);
			}
		});
		rdBtnCat.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtnCat.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		rdBtnCat.setBounds(220, 280, 100, 23);
		contentPanel.add(rdBtnCat);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addButton = new JButton("Add");
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Dog dog;
						boolean isCat = rdBtnCat.isSelected();
						String petName = petNameTf.getText();
			            String petWeight = petWeightTf.getText();
			            LocalDate petDob = validateDate();
						boolean isAllergic = isAllergicCb.getState();
						String breed = breedTf.getText();
		                boolean isEmpty = petName.isEmpty()  || petWeight.isEmpty() || (!isCat && breed.isEmpty() );
						double petWeightDouble = getPetWeight();
			            if(isEmpty)
		                    JOptionPane.showMessageDialog(dialog,"Please fill out all fields.");
			            else {
							if(isCat){
								Cat newCat = new Cat(petName,petWeightDouble,petDob,isAllergic);
								clinic.addPet(newCat);
								JOptionPane.showMessageDialog(dialog, "Pet Added.\n" + newCat.toString());
								dialog.dispose();
							}else{
								Dog newDog = new Dog(petName,petWeightDouble,petDob,breed);
								clinic.addPet(newDog);
								JOptionPane.showMessageDialog(dialog, "Pet Added.\n" + newDog.toString());
								dialog.dispose();
							}

						
							System.out.println("Success");
				        }
					}
				});
				addButton.setActionCommand("OK");
				buttonPane.add(addButton);
				getRootPane().setDefaultButton(addButton);
			}
			{
				JButton cancelButton = new JButton("Back");
				cancelButton.setBounds(0,410,50,100);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		rdBtnDog.setSelected(true);
		
		dateCB = new JComboBox<String>();
		dateCB.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateCB.setBounds(155, 140, 45, 22);
		contentPanel.add(dateCB);
		
		monthCB = new JComboBox<String>();
		monthCB.setModel(new DefaultComboBoxModel<>(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		monthCB.setBounds(210, 140, 50, 22);
		contentPanel.add(monthCB);
		
		yearCB = new JComboBox<String>();
		yearCB.setModel(new DefaultComboBoxModel<>(new String[] {"2022","2021", "2020", "2019", "2018", "2017", "2016", "2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"}));
		yearCB.setBounds(270, 140, 60, 22);
		contentPanel.add(yearCB);
		

	}
	
	public Double getPetWeight() {
		Double weight = null;
	    try {
	    	String weightIn = petWeightTf.getText();
	    	weight = Double.parseDouble(weightIn);
	    } catch (NumberFormatException nfe) {
	  	  JOptionPane.showMessageDialog(dialog,"Weight must be a number / missing");
	      }
		return weight;
	}
	
	public LocalDate validateDate() {
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("d/M/y");
        String month = null;
        switch (monthCB.getSelectedItem().toString()) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;       
        }
        LocalDate sessionDate;
        String date = dateCB.getSelectedItem().toString()+"/"+month+"/"+yearCB.getSelectedItem().toString();
        sessionDate = LocalDate.parse(date, dateformat);
		System.out.println("dateof birth"+sessionDate);
        return sessionDate;
    }
	
}
