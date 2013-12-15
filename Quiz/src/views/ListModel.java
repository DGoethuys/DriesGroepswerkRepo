package views;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.AbstractListModel;

public class ListModel<T> extends AbstractListModel<T>{
	private static final long serialVersionUID = 1L;
	
	private HashSet<T> list;
	
	public HashSet<T> getHashSet(){
		return list;
	}
	
	private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
	
    public ListModel(){
    	list = new HashSet<T>();
    }
    
    public ListModel(HashSet<T> array){
    	list = array;
    }

    public int getSize(){
        return list.size();
    }

    public T getElementAt(int index){
        ArrayList<T> tArrayList = new ArrayList<T>();
    	for(T t : list){
    		tArrayList.add(t);
    	}
    	return tArrayList.get(index);
    }
    
    public void removeElementAt(int index){
        list.remove(index);
    }

    public void addElement(T t){
    	list.add(t);
    }
    
    public ArrayList<T> getAsArrayList(){
        ArrayList<T> tArrayList = new ArrayList<T>();
    	for(T t : list){
    		tArrayList.add(t);
    	}
        return tArrayList;
    }
    
    public void setList(HashSet<T> array){
        this.list = array;
    }
    
    public void setList(ArrayList<T> array){
        HashSet<T> tHashSet = new HashSet<T>();
    	for(T t : array){
    		tHashSet.add(t);
    	}
        this.list = tHashSet;
    }
    
    //public void sort(){
    //    Collections.sort(opdrachten);
    //}
}