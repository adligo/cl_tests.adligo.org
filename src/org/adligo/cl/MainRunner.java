package org.adligo.cl;

import java.util.Map;

import org.adligo.cl.args.ArgParser;
import org.adligo.cl.view.InputDialog;
import org.adligo.cl.view.ParsedInputDialog;
import org.adligo.cl.view.parsers.IntegerInputParser;
import org.adligo.i.adig.client.GRegistry;
import org.adligo.i.adig.client.I_GInvoker;
import org.adligo.i.log.client.LogPlatform;
import org.adligo.j2se.util.J2SEPlatform;


public class MainRunner {
	
	static {
		try {
			J2SEPlatform.init();
			LogPlatform.init();
			CLRegistry.setup();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	public static void main(String [] args) {
		Map<String,String> cla = ArgParser.parse(args);
		
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
