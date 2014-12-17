package de.gravitex.railstuff.tablepanel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RssFeedTableModel extends AbstractTableModel {
	
  List feeds;
 
  public RssFeedTableModel(List feeds) {
    this.feeds = feeds;
  }
 
  public Class getColumnClass(int columnIndex) { return RssFeed.class; }
    public int getColumnCount() { return 1; }
    public String getColumnName(int columnIndex) { return "Feed"; }
    public int getRowCount() { return (feeds == null) ? 0 : feeds.size(); }
    public Object getValueAt(int rowIndex, int columnIndex) { return (feeds == null) ? null : feeds.get(rowIndex); }
    public boolean isCellEditable(int columnIndex, int rowIndex) { return true; }
}