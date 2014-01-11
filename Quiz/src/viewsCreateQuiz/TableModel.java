package viewsCreateQuiz;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel  {
	
	private static final long serialVersionUID = 1L;
	
	private TableList tableList;
	private String [] columnNames;
	private ArrayList<Integer> editableCells;
	
	public TableModel(TableList tableList){
		this.setList(tableList);
		this.editableCells = new ArrayList<Integer>();
	}
	
	public void setList(TableList tableList){
		this.tableList = tableList;
	}
	
	public void setColumnNames(String... columnNames){
		this.columnNames = columnNames;
	}
	
    public String getColumnName(int col) {
    	return this.columnNames[col];
    }

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.tableList.getLength();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableList.get(rowIndex, columnIndex);
	}
	
	public void setEditableColumn(int col, boolean b){
		editableCells.add(col);
	}
	
    public boolean isCellEditable(int row, int col) {
    	if(editableCells.contains(col)){
    		return true;
    	}
        return false;
    }
    
    public void setValueAt(Object value, int row, int col)
    {
    	tableList.set(row,col,value);
        fireTableCellUpdated(row, col);
    }

}
