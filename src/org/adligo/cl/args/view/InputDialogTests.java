package org.adligo.cl.args.view;

import org.adligo.cl.CL_InvokerNames;
import org.adligo.cl.MockConsoleInputReader;
import org.adligo.cl.view.InputDialog;
import org.adligo.i.adi.MockOutErrInvoker;
import org.adligo.i.adi.client.InvokerNames;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.adig.client.GRegistry;
import org.adligo.tests.ATest;

public class InputDialogTests extends ATest {

	public void testInputDialog() {
		MockOutErrInvoker outInvoker = new MockOutErrInvoker();
		Registry.addOrReplaceInvoker(InvokerNames.OUT, outInvoker);
		GRegistry.addOrReplaceInvoker(CL_InvokerNames.CONSOLE_INPUT_READER,
				MockConsoleInputReader.INSTANCE);
		
		InputDialog dialog = new InputDialog();
		dialog.setMessage("did you test it?");
		MockConsoleInputReader.INSTANCE.setNextInput("no");
		
		dialog.show();
		assertEquals(1,outInvoker.getMessages().size());
		assertEquals("did you test it?",outInvoker.getMessages().get(0) );
		assertEquals("no", dialog.getInput());
		
		outInvoker.getMessages().clear();
		MockConsoleInputReader.INSTANCE.setNextInput("ok a little");
		dialog.show();
		assertEquals(1,outInvoker.getMessages().size());
		assertEquals("did you test it?",outInvoker.getMessages().get(0) );
		assertEquals("ok a little", dialog.getInput());
	}
}
