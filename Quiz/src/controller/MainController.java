package controller;

import views.*;
import model.*;

public class MainController {

	private Quiz _quiz;
	private Vraag _vraag;
	private MainWindow mainWin;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MainController(MainWindow view,Quiz quiz,Vraag vraag)
	{
		this._quiz = quiz;
		this._vraag = vraag;
		this.mainWin = view;
	}

}
