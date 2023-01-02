
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.lang.Object;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VetClinicGUI extends JFrame {

	private JPanel contentPane;
	public static VetClinic vetClinic;
	private JFrame frame = this;

	public static void main(String[] args) {
		try {
			VetClinicGUI frame = new VetClinicGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public VetClinicGUI() {
		VetClinic clinic = new VetClinic("VetClinic");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 600;
		setContentPane(contentPane);
		setLayout(null);

		// add main label
		JLabel lblNewLabel = new JLabel(clinic.getName() + " Main Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(30, 20, 450, 30);
		contentPane.add(lblNewLabel);

		// add button to add pet
		JButton addPetBtn = new JButton("Add Pet");
		addPetBtn.setBackground(Color.WHITE);
		addPetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPetDialog d = new AddPetDialog(clinic, true);
				d.setVisible(true);
			}
		});
		addPetBtn.setBounds(60, 80, 350, 25);
		contentPane.add(addPetBtn, c);

		// add button to add pet
		JButton btnListPets = new JButton("List Pets");
		btnListPets.setBackground(Color.WHITE);
		btnListPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPetsDialog d = new
				ListPetsDialog(clinic, true);
				d.setVisible(true);
			}
		});
		btnListPets.setBounds(60, 115, 350, 25);
		contentPane.add(btnListPets);


		// add button to administer drug
		JButton drugBtn = new JButton("Administer Drug");
		drugBtn.setBackground(Color.WHITE);
		drugBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindPetDialog d = new
				FindPetDialog(clinic, true);
				d.setVisible(true);
			}
		});
		drugBtn.setBounds(60, 150, 350, 25);
		contentPane.add(drugBtn);
	}
}
