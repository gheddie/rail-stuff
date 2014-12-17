/*
 * Created by JFormDesigner on Tue Dec 16 21:00:53 CET 2014
 */

package de.gravitex.railstuff.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.gravitex.railstuff.*;

/**
 * @author Stefan Schulz
 */
public class MaturityTestFrame extends JFrame {
	
	public MaturityTestFrame() {
		initComponents();
		putListeners();
		setSize(800, 600);
	}

	private void putListeners() {
		btnIncreaseFocus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				increaseFocus();
			}
		});
		btnDecreaseFocus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decreaseFocus();
			}
		});
	}
	
	private void increaseFocus() {
		mp1.increaseFocus();
		mp2.increaseFocus();
		mp3.increaseFocus();
	}
	
	private void decreaseFocus() {
		mp1.decreaseFocus();
		mp2.decreaseFocus();
		mp3.decreaseFocus();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Stefan Schulz
		mp1 = new MaturityPanel();
		mp2 = new MaturityPanel();
		mp3 = new MaturityPanel();
		btnIncreaseFocus = new JButton();
		btnDecreaseFocus = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {69, 65, 65, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
		contentPane.add(mp1, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));
		contentPane.add(mp2, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));
		contentPane.add(mp3, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));

		//---- btnIncreaseFocus ----
		btnIncreaseFocus.setText("+");
		contentPane.add(btnIncreaseFocus, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 5), 0, 0));

		//---- btnDecreaseFocus ----
		btnDecreaseFocus.setText("-");
		contentPane.add(btnDecreaseFocus, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 5), 0, 0));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Stefan Schulz
	private MaturityPanel mp1;
	private MaturityPanel mp2;
	private MaturityPanel mp3;
	private JButton btnIncreaseFocus;
	private JButton btnDecreaseFocus;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
