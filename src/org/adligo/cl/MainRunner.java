package org.adligo.cl;

import org.adligo.cl.view.ParsedInputDialog;
import org.adligo.cl.view.parsers.IntegerInputParser;
import org.adligo.jse.util.JSECommonInit;


public class MainRunner {
	
	static {
		JSECommonInit.callLogDebug(MainRunner.class.getName());
	}
	
	public static void main(String [] args) {
		
		ParsedInputDialog inputDialog = new ParsedInputDialog();
		inputDialog.setMessage("how many carrots did you want?");
		inputDialog.setErrorMessage("I didn't understand please try a number like 22.");
		inputDialog.setParser(new IntegerInputParser());
		inputDialog.show();
		
		Integer number = (Integer) inputDialog.getParsed();
		if (number != null) {
			System.out.println(" you said " + number);
		}
	}
}
