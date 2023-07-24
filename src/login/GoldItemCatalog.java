/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sajit
 */
public class GoldItemCatalog {
    static private JFrame frame;
	static private JButton backButton, orderButton;
	static private JTextField textField;
	static private GridBagConstraints gbc;
	private JTable table;
	DefaultTableModel dtm;
	Double[] price;
	Double[] priceMen;
	Double[] priceWomen;
	double totalPrice = 0;
	double p1, p2, p3, p4, p5, p6, p7, p8, p9;
	double d1, d2, d3, d4, d5;
	double de1, de2;

	private JSpinner[] numSpinner;
	static private JLabel[] itemLabel;
	static private JLabel[] itemImage;
	private String[] file;

	private JSpinner[] numSpinnerwomenitem;
	static private JLabel[] womenitemLabel;
	static private JLabel[] womenitemImage;
	private String[] filewomenitem;

	private JSpinner[] numSpinnermenitem;
	static private JLabel[] menitemLabel;
	static private JLabel[] menitemImage;
	private String[] filemenitem;

	private static final int ELEMENTS = 9;
	private static final int WOMENITEM_ELEMENTS = 5;
	private static final int MENITEM_ELEMENTS = 2;

	double total = 0;
	double item1, item2, item3, item4, item5, item6, item7, item8, item9;
	double gitem1, gitem2, gitem3, gitem4, gitem5;
	double pr, pr1;

	double totalForitem;
	double totalForwomenitem;
	double totalFormenitem;

	void createAndShowGUI() throws IOException {
		frame = new JFrame("Main Menu ");
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblItemOrdered = new JLabel("Items Ordered");
		lblItemOrdered.setBounds(529, 11, 81, 14);

		frame.getContentPane().add(lblItemOrdered);

		table = new JTable();
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(475, 31, 1, 1);
		table.setSize(245, 300);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0); 
		table.setShowGrid(false); 
		frame.getContentPane().add(table);
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setBounds(585, 340, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		orderButton = new JButton("Order");
		orderButton.setBounds(500, 385, 89, 23);
		frame.getContentPane().add(orderButton);
		backButton = new JButton("Back");
		backButton.setBounds(610, 385, 89, 23);
		frame.getContentPane().add(backButton);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		addIt(tabbedPane, "GNItems");
		addIt1(tabbedPane, "FORWomen");
		addIt2(tabbedPane, "FORMen");
		tabbedPane.setBounds(18, 11, 450, 450);
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Oder menu = new Oder();
					menu.GItem(header);
					menu.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You not ordered anything yet");
				} else {
					try {
						Oder order = new Oder();
						order.main(header);
						order.setVisible(true);
						setVisible(false);
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}

	void addIt(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); // getting constraints for the specified
										// component
		gbc.insets = new Insets(10, 0, 0, 0);
		itemImage = new JLabel[ELEMENTS];
		itemLabel = new JLabel[ELEMENTS];
		numSpinner = new JSpinner[ELEMENTS];
		file = new String[ELEMENTS];
		price = new Double[ELEMENTS];

		file[0] = new String("");
		file[1] = new String("");
		file[2] = new String("");
		file[3] = new String("");
		file[4] = new String("");
		file[5] = new String("");
		file[6] = new String("");
		file[7] = new String("");
		file[8] = new String("");
		itemLabel[0] = new JLabel("m");
		itemLabel[1] = new JLabel("b");
		itemLabel[2] = new JLabel("c");
		itemLabel[3] = new JLabel("d");
		itemLabel[4] = new JLabel("e");
		itemLabel[5] = new JLabel("f");
		itemLabel[6] = new JLabel("g");
		itemLabel[7] = new JLabel("e");
		itemLabel[8] = new JLabel("f");
		price[0] = 3000.50;
		price[1] = 4000.50;
		price[2] = 3000.70;
		price[3] = 4000.50;
		price[4] = 5000.50;
		price[5] = 4000.00;
		price[6] = 3000.50;
		price[7] = 6000.50;
		price[8] = 6000.50;
		for (int i = 0; i < ELEMENTS; i++) {
			
			System.out.print(file[i]);	
			try {
			
			Image image = ImageIO.read(this.getClass().getResource(file[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); 
			numSpinner[i] = new JSpinner(spnummodel);
			numSpinner[i].addChangeListener(listener);
			itemImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0; 
		for (int i = 0; i < ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(itemImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(itemLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinner[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
	}

	void addIt2(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		menitemImage = new JLabel[MENITEM_ELEMENTS];
		menitemLabel = new JLabel[MENITEM_ELEMENTS];
		numSpinnermenitem = new JSpinner[MENITEM_ELEMENTS];
		priceMen = new Double[MENITEM_ELEMENTS];

		filemenitem = new String[MENITEM_ELEMENTS];
		filemenitem[0] = new String("");
		filemenitem[1] = new String("");

		menitemLabel[0] = new JLabel("Men Item 1");
		menitemLabel[1] = new JLabel("Men Item 2");

		priceMen[0] = 3000.50;
		priceMen[1] = 4000.00;

		for (int i = 0; i < MENITEM_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(filemenitem[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); 
			numSpinnermenitem[i] = new JSpinner(spnummodel);
                    ChangeListener listenerFormenitem = null;
			numSpinnermenitem[i].addChangeListener(listenerFormenitem);
			menitemImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; 
		gbc.insets = new Insets(10, 5, 0, 0);
		for (int i = 0; i < MENITEM_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(menitemImage[i], gbc);
			gbc.gridy++; 
			panel.add(menitemLabel[i], gbc);
			gbc.gridy--; 
			gbc.gridx++; 
			panel.add(numSpinnermenitem[i], gbc);
			gbc.gridx++; 
			tabbedPane.addTab(text, panel);
		}

                
	}

	void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		womenitemImage = new JLabel[WOMENITEM_ELEMENTS];
		womenitemLabel = new JLabel[WOMENITEM_ELEMENTS];
		numSpinnerwomenitem = new JSpinner[WOMENITEM_ELEMENTS];
		priceWomen = new Double[WOMENITEM_ELEMENTS];

		filewomenitem = new String[WOMENITEM_ELEMENTS];
		filewomenitem[0] = new String("");
		filewomenitem[1] = new String("");
		filewomenitem[2] = new String("");
		filewomenitem[3] = new String("");
		filewomenitem[4] = new String("");

		womenitemLabel[0] = new JLabel("");
		womenitemLabel[1] = new JLabel("");
		womenitemLabel[2] = new JLabel("");
		womenitemLabel[3] = new JLabel("");
		womenitemLabel[4] = new JLabel("");

		priceWomen[0] = 30000.50;
		priceWomen[1] = 40000.50;
		priceWomen[2] = 30000.00;
		priceWomen[3] = 50000.00;
		priceWomen[4] = 30000.00;

		for (int i = 0; i < WOMENITEM_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(filewomenitem[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1);
			numSpinnerwomenitem[i] = new JSpinner(spnummodel);
                    ChangeListener listenerForwomenitem = null;
			numSpinnerwomenitem[i].addChangeListener(listenerForwomenitem);
			womenitemImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; 
		gbc.insets = new Insets(10, 5, 0, 0); 
		for (int i = 0; i < WOMENITEM_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(womenitemImage[i], gbc);
			gbc.gridy++; 
			panel.add(womenitemLabel[i], gbc);
			gbc.gridy--;
			gbc.gridx++; 
			panel.add(numSpinnerwomenitem[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);

		}
	}

	ChangeListener listener = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(p1 * quantity, row, 2);
						item1 = p1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Item001")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p2 * quantity, row, 2);
						item2 = p2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item002")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p3 * quantity, row, 2);
						item3 = p3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item003")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p4 * quantity, row, 2);
						item4 = p4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item004")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p5 * quantity, row, 2);
						item5 = p5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item005")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p6 * quantity, row, 2);
						item6 = p6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item006")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p7 * quantity, row, 2);
						item7 = p7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item007")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p8 * quantity, row, 2);
						item8 = p8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Item008")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p9 * quantity, row, 2);
						item9 = p9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForitem = item1 + item2 + item3 + item4 + item5 + item6 + item7 + item8 + item9;
					total = totalForitem + totalForwomenitem + totalFormenitem;
					textField.setText(total + "");
					return;
				}
			}

			for (int i = 0; i < ELEMENTS; i++) {
				if (numSpinner[i] == e.getSource()) {
					totalPrice = price[i];
					switch (itemLabel[i].getText()) {
					case "Item001":
						p1 = 30000.50;
						item1 = p1;
						break;
					case "Item002":
						p2 = 4.50;
						item2 = p2;
						break;
					case "Item003":
						p3 = 3.70;
						item3 = p3;
						break;
					case "Item004":
						p4 = 4.50;
						item4 = p4;
						break;
					case "Item005":
						p5 = 5.50;
						item5 = p5;
						break;
					case "Item006":
						p6 = 4.00;
						item6 = p6;
						break;
					case "Item007":
						p7 = 3.50;
						item7 = p7;
						break;
					case "Item008":
						p8 = 6.50;
						item8 = p8;
						break;
					case "Item0009":
						p9 = 6.50;
						item9 = p9;
						break;
					}
					totalForitem = item1 + item2 + item3 + item4 + item5 + item6 + item7 + item8 + item9;
					total = totalForitem + totalForwomenitem + totalFormenitem;
					textField.setText(total + "");
					dtm.addRow(new Object[] { itemLabel[i].getText(), quantity, totalPrice, numSpinner[i] });
					return;
				}

			}
		}
	};

	ChangeListener listenerForDesserts = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();

			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("item101")) {
						dtm.setValueAt(quantity, row, 1); // obj, row,
						pr = de1 * quantity; // column
						dtm.setValueAt(de1 * quantity, row, 2);
					} else if (dtm.getValueAt(row, 0).equals("item102")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, // column
						dtm.setValueAt(de2 * quantity, row, 2);
						pr1 = de2 * quantity;
					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalFormenitem = pr + pr1;
					total = totalForitem + totalFormenitem + totalForwomenitem;
					textField.setText(total + "");
					return;
				}
			}

			for (int i = 0; i < MENITEM_ELEMENTS; i++) 
				if (numSpinnermenitem[i] == e.getSource()) {
					totalPrice = priceMen[i];
					switch (menitemLabel[i].getText()) {
					case "item101":
						de1 = 2000.50;
						pr = de1;
						break;
					case "item102":
						de2 = 3000.00;
						pr1 = de2;
						break;
					}
					totalFormenitem = pr + pr1;
					total = totalForitem + totalForwomenitem + totalFormenitem;
					textField.setText(total + "");
					dtm.addRow(new Object[] { menitemLabel[i].getText(), quantity, totalPrice, numSpinnermenitem[i] });
					return;
				}

			}
		}

	};

	ChangeListener listenerForwomenitem = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Item2001")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d1 * quantity, row, 2);
						womenitem1 = d1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Item2001")) {
						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(d2 * quantity, row, 2);
						womenitem2 = d2 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Item2002")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d3 * quantity, row, 2);
						womenitem3 = d3 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Item2003")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d4 * quantity, row, 2);
						womenitem4 = d4 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Item2004")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d5 * quantity, row, 2);
						womenitem5 = d5 * quantity;

					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForwomenitem = womenitem1 + womenitem2 + womenitem3 + womenitem4 + womenitem5;
					total = totalForitem + totalForwomenitem + totalFormenitem;
					textField.setText(total + "");

					return;
				}
			}

			for (int i = 0; i < DRINK_ELEMENTS; i++) {
				if (numSpinnerWomen[i] == e.getSource()) {
					totalPrice = priceWomen[i];
					switch (womenitemLabel[i].getText()) {
					case "Item20011":
						d1 = 3.50;
						womenitem1 = d1;
						break;
					case "Item2002":
						d2 = 4.50;
						womenitem2 = d2;
						break;
					case "Item2003":
						d3 = 3.00;
						womenitem3 = d3;
						break;
					case "Item2004":
						d4 = 5.00;
						womenitem4 = d4;
						break;
					case "Item2005":
						d5 = 3.00;
						womenitem5 = d5;
						break;
					}
					totalForwomenitem = womenitem1 + womenitem2 + womenitem3 + womenitem4 + womenitem5;
					total = totalForitem + totalForwomenitem + totalFormenitem;
					textField.setText(total + "");
					dtm.addRow(new Object[] { womenitemLabel[i].getText(), quantity, totalPrice, numSpinnerwomenitem[i] });
					return;
				}

			}

		}
	};

	public void setVisible(boolean b) throws IOException {
	}

}
