package controller;

public class Driver {
	public static void main(String[] args) {
		try{
			OpstartController o = new OpstartController();
			o.opstartMenu();
		}
		catch(NullPointerException ex){
			System.out.println("(NullPointerException) Message: " + ex.getMessage());
		}
		catch(Exception ex){
			System.out.println("(Exception) Message: " + ex.getMessage());
		}
		
	}//Einde main
}//Einde Class
