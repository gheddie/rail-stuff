package de.gravitex.railstuff.tablepanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class RssFeedCellComponent extends JPanel {
	
	RssFeed feed;

	JButton showButton;
	JLabel text;

	public RssFeedCellComponent() {
		showButton = new JButton("View Articles");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Reading " + feed.name);
			}
		});

		text = new JLabel();
		add(text);
		add(showButton);
	}

	public void updateData(RssFeed feed, boolean isSelected, JTable table) {
		this.feed = feed;

		text.setText("<strong>" + feed.name + "</strong>" + feed.url + "Articles " + feed.articles.length + "");
		if (isSelected) {
			setBackground(table.getSelectionBackground());
		} else {
			setBackground(table.getSelectionForeground());
		}
	}
}