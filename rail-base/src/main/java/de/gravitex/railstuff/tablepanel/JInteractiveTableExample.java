package de.gravitex.railstuff.tablepanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JInteractiveTableExample extends JFrame {

	public JInteractiveTableExample() {
		
		super("Interactive Table Cell Example");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);

		List<RssFeed> feeds = new ArrayList<RssFeed>();
		feeds.add(new RssFeed("pekalicious", "http://feeds2.feedburner.com/pekalicious", new Article[] { new Article("Title1", "http://title1.com", "Content 1"),
				new Article("Title2", "http://title2.com", "Content 2"), new Article("Title3", "http://title3.com", "Content 3"), new Article("Title4", "http://title4.com", "Content 4"), }));
		feeds.add(new RssFeed("Various Thoughts on Photography", "http://various-photography-thoughts.blogspot.com/feeds/posts/default", new Article[] {
				new Article("Title1", "http://title1.com", "Content 1"), new Article("Title2", "http://title2.com", "Content 2"), new Article("Title3", "http://title3.com", "Content 3"),
				new Article("Title4", "http://title4.com", "Content 4"), }));

		JTable table = new JTable(new RssFeedTableModel(feeds));
		table.setDefaultRenderer(RssFeed.class, new RssFeedCellRenderer());
		table.setDefaultEditor(RssFeed.class, new RssFeedCellEditor());
		table.setRowHeight(60);
		
		add(new JScrollPane(table));
	}
	
	//---
	
	public static void main(String[] args) {
		new JInteractiveTableExample().setVisible(true);
	}
}