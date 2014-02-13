package org.adligo.cl_tests.args;

import java.util.Map;

import org.adligo.cl.args.ArgParser;
import org.adligo.tests.ATest;

public class ArgParserTests extends ATest {

	public void testArgParser() {
		Map<String,String> cla = ArgParser.parse(
				new String [] {"-help","-threads='123'","-mojos=0"});
		assertEquals("", cla.get("-help"));
		assertEquals("123", cla.get("-threads"));
		//-mojos didn't have quotes
		assertEquals("", cla.get("-mojos"));
	}
}
