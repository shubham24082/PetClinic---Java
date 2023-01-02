
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class ListPetsDialog extends JDialog implements ActionListener {
	private JDialog dialog = this;

	private JPanel contentPane;
	private VetClinic clinic;
	private PetTableModel ftm;
	private JTable petTable;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPetsDialog frame = new ListPetsDialog(null, true);
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListPetsDialog(VetClinic clinicIn, boolean modal) {
		clinic = clinicIn;

		setTitle("Pet List");
		setBounds(100, 100, 780, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMain = new JLabel("Registered Pet");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setBounds(30, 20, 450, 30);
		contentPane.add(lblMain);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 700, 350);
		contentPane.add(scrollPane);

		petTable = new JTable();
		petTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] { "ID", "Name", "Weight(kg)", "Age(month)", "D.O.B", "Accumulated Pet (mg)", "Breed",
						"Allergic" }));
		scrollPane.setViewportView(petTable);

	
	

		JButton sortByDose = new JButton("Sort By Total Dose");
		sortByDose.setBackground(Color.WHITE);
		sortByDose.setBounds(60, 440, 150, 40);
		sortByDose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ArrayList<Pet> pets = clinic.getPets();
				pets.sort((a, b) ->{
					return (int)(a.getDose()-b.getDose());
				});
				setupTableModels(pets);

			}

		});
		contentPane.add(sortByDose);

		JButton sortByDob = new JButton("Sort By Date of Birth");
		sortByDob.setBackground(Color.WHITE);
		sortByDob.setBounds(220, 440, 150, 40);
		sortByDob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ArrayList<Pet> pets = clinic.getPets();
				pets.sort((a, b) -> a.getDob().compareTo(b.getDob()));
				setupTableModels(pets);
			}

		});
		contentPane.add(sortByDob);

		JButton sortByOrder = new JButton("Sort By Original Order");
		sortByOrder.setBackground(Color.WHITE);
		sortByOrder.setBounds(380, 440, 150, 40);
		sortByOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ArrayList<Pet> pets = clinic.getPets();
				setupTableModels(pets);
			}

		});
		contentPane.add(sortByOrder);

		JButton backBtn = new JButton("Back");
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(10, 500, 100, 40);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dialog.dispose();
			}

		});
		contentPane.add(backBtn);

		setupTableModels(clinic.getPets());
	}

	public void setupTableModels(ArrayList<Pet> pets) {
		ftm = new PetTableModel(pets, 0);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		petTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        petTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		petTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        petTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		petTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        petTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		petTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        petTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		
		petTable.setRowHeight(30);

		petTable.setModel(ftm);
		petTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.out.println(e.getSource());

	}
}
