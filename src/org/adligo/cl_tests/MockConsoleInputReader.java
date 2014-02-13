package org.adligo.cl_tests;

import org.adligo.i.adig.shared.BaseGInvoker;
import org.adligo.i.adig.shared.I_GInvoker;

public class MockConsoleInputReader extends BaseGInvoker implements I_GInvoker<Object, String> {
	public static final MockConsoleInputReader INSTANCE = new MockConsoleInputReader();
	private String nextInput;
	
	private MockConsoleInputReader() {
		super(Object.class, String.class);
	}

	@Override
	public String invoke(Object valueObject) {
		return nextInput;
	}

	public String getNextInput() {
		return nextInput;
	}

	public void setNextInput(String nextInput) {
		this.nextInput = nextInput;
	}
	
	
}
