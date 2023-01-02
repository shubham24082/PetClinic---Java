
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministerDrugDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDialog dialog = this;
	private VetClinic clinic;
    private Pet pet;
	private JTextField drugNameTf;

	
	public static void main(String[] args) {
		try {
			AdministerDrugDialog dialog = new AdministerDrugDialog(null,null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AdministerDrugDialog(VetClinic clinicIn,Pet petIn, boolean modal) {
		clinic = clinicIn;
        pet =petIn;
		setTitle("Administer Dosage");
		setBounds(10, 20, 435, 265);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

        {
            // add main label
		JLabel lblMain = new JLabel("Administer Dosage");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblMain.setBounds(30, 20, 450, 30);
		contentPanel.add(lblMain);
        }
	
        {
			JLabel lblPetId = new JLabel("Required Dosage(mg):");
			lblPetId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblPetId.setBounds(50, 82, 145, 20);
			contentPanel.add(lblPetId);
		}
        {
			JLabel lblPetId = new JLabel(Double.toString(pet.getDose()));
			lblPetId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblPetId.setBounds(200, 85, 135, 20);
			contentPanel.add(lblPetId);
		}
		{
			JLabel lblPetId = new JLabel("PetId:");
			lblPetId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblPetId.setBounds(50, 112, 135, 20);
			contentPanel.add(lblPetId);
		}
        {
			JLabel lblPetIdValue = new JLabel(Integer.toString(pet.getId()));
			lblPetIdValue.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblPetIdValue.setBounds(100, 112, 135, 20);
			contentPanel.add(lblPetIdValue);
		}
        {
			JLabel lblNewLabel = new JLabel("Name of drug:");
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblNewLabel.setBounds(50, 132, 135, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			drugNameTf = new JTextField();
			drugNameTf.setBounds(190, 132, 150, 22);
			contentPanel.add(drugNameTf);
			drugNameTf.setColumns(10);
		}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bookButton = new JButton("Ok");
				bookButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String drugName = drugNameTf.getText();
		                boolean isEmpty = drugName.isEmpty();
			            if(isEmpty)
		                    JOptionPane.showMessageDialog(dialog,"Please fill out all fields.");
			            else {
                            Dose newDose = new Dose(drugName,pet.getDose());
                            pet.addDose(newDose);
							ListPetsDialog d = new ListPetsDialog(clinic, true);
							d.setVisible(true);
                            dialog.dispose();
                        }
			            
					}
					
				});
				bookButton.setActionCommand("OK");
				buttonPane.add(bookButton);
				getRootPane().setDefaultButton(bookButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
