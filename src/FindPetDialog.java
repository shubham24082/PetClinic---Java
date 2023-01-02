
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

public class FindPetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDialog dialog = this;
	private VetClinic clinic;
	private JTextField petIdTf;

	public static void main(String[] args) {
		try {
			FindPetDialog dialog = new FindPetDialog(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindPetDialog(VetClinic clinicIn, boolean modal) {
		clinic = clinicIn;

		setTitle("Find Pet");
		setBounds(100, 100, 450, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
            // add main label
		JLabel lblMain = new JLabel("Find Pet");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblMain.setBounds(30, 20, 450, 30);
		contentPanel.add(lblMain);
        }
		{
			JLabel lblPetId = new JLabel("Pet ID:");
			lblPetId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblPetId.setBounds(60, 87, 135, 20);
			contentPanel.add(lblPetId);
		}
		{
			petIdTf = new JTextField();
			petIdTf.setColumns(10);
			petIdTf.setBounds(200, 87, 150, 22);
			contentPanel.add(petIdTf);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton findBtn = new JButton("Find");
				findBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Pet foundPet;
						String petIdIn = petIdTf.getText();
						int petId = Integer.parseInt(petIdIn);

						if (petIdIn.isEmpty())
							JOptionPane.showMessageDialog(dialog, "Please enter a petId.");
						else {

							foundPet = clinic.getPets().stream()
									.filter(pet -> petId == pet.getId())
									.findAny()
									.orElse(null);

							if (foundPet == null) {
								JOptionPane.showMessageDialog(dialog, "No pet with that ID found");
							} else {
								if(foundPet instanceof Cat){
									Cat cat = (Cat)foundPet;
									if(cat.getIsAllergic()){
										JOptionPane.showMessageDialog(dialog, "The cat is allergic and cannot be administered with drug!");
									}else{
										AdministerDrugDialog d = new AdministerDrugDialog(clinic, foundPet, true);
										d.setVisible(true);
									}
								}else{

									AdministerDrugDialog d = new AdministerDrugDialog(clinic, foundPet, true);
									d.setVisible(true);
								}
								dialog.dispose();

								}
						}
					}
				});
				findBtn.setActionCommand("OK");
				buttonPane.add(findBtn);
				getRootPane().setDefaultButton(findBtn);
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
