package de.gravitex.railstuff.tablepanel;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class RssFeedCellEditor extends AbstractCellEditor implements TableCellEditor {
	
  RssFeedCellComponent feedComponent;
 
  public RssFeedCellEditor() {
    feedComponent = new RssFeedCellComponent();
  }
 
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    RssFeed feed = (RssFeed)value;
    feedComponent.updateData(feed, true, table);
    return feedComponent;
  }
 
  public Object getCellEditorValue() {
    return null;
  }
}