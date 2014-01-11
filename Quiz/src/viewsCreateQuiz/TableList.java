package viewsCreateQuiz;

import java.util.ArrayList;
import java.util.Iterator;

public class TableList implements Iterable {
	
	private ArrayList<TableObject> list;
	
	public TableList(){
		list = new ArrayList<TableObject>();
	}
	
	public int getLength(){
		return list.size();
	}
	
	public Object get(int row, int col){
		try{
		return this.list.get(row).get(col);
		}
		catch(IndexOutOfBoundsException ex){
			return "";
		}
	}
	
	public TableObject getRow(int row){
		return list.get(row);
	}
	
	public void add(TableObject o){
		list.add(o);
	}
	
	public void add(Object...objects){
		TableObject o = new TableObject(null, null);
		for(int n = 0; n < objects.length; n++){
			switch(n){
			case 0:
				o.setVraag(objects[n].toString());
				break;
			case 1:
				o.setCategorie(objects[n].toString());
				break;
			case 2:
				o.setMaxScore(Integer.parseInt(objects[n].toString()));
				break;
			}
		}
		list.add(o);
	}
	
	public void remove(int row){
		list.remove(row);
	}
	
	public void set(int row, int col, Object value){
			switch(col){
			case 0:
				this.list.get(row).setVraag(value.toString());
				break;
			case 1:
				this.list.get(row).setCategorie(value.toString());
				break;
			case 2:
				this.list.get(row).setMaxScore(Integer.parseInt(value.toString()));
				break;
			}
	
	}

	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator<TableObject> iterator() {
		return list.iterator();
	}

}
