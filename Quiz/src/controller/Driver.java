package controller;

public class Driver {
	public static void main(String[] args) {
		try{
			OpstartController o = new OpstartController();
			o.opstartMenu();
		}
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}

	}// Einde main
}
