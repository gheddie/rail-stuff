package de.gravitex.railstuff.tablepanel;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RssFeedCellRenderer implements TableCellRenderer{
	
  RssFeedCellComponent feedComponent;
 
  public RssFeedCellRenderer() {
    feedComponent = new RssFeedCellComponent();
  }
 
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    RssFeed feed = (RssFeed)value;
 
    feedComponent.updateData(feed, isSelected, table);
    return feedComponent;
  }
}