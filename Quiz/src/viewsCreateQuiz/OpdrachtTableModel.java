package viewsCreateQuiz;

import javax.swing.table.AbstractTableModel;

public class OpdrachtTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	OpdrachtList ol;
	private String [] kolomNamen = {"Vraag", "Categorie"};
	
	public OpdrachtTableModel(OpdrachtList ol){
		this.ol = ol;
	}

    public String getColumnName(int col) {
    	return kolomNamen[col];
    }
	
	@Override
	public int getColumnCount() {
		return kolomNamen.length;
	}

	@Override
	public int getRowCount() {
		return ol.getLength();
	}
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return ol.getField(arg0, arg1);
	}
	
	public String [] getKolomNamen() {
		return kolomNamen;
	}

	public void setKolomNamen(String [] kolomNamen) {
		this.kolomNamen = kolomNamen;
	}
	
	public void addMaxScoreToKolomNamen(){
		String nieuweKolomNamen [] = {"Vraag", "Categorie", "Max Score"};
		this.kolomNamen = nieuweKolomNamen;
	}
	
    public boolean isCellEditable(int row, int col) {
    	if(col == 2){
    		return true;
    	}
        return false;
        
    }
	
}
