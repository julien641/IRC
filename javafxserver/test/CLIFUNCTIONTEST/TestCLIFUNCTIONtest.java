/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIFUNCTIONTEST;

import Commands.CLIFUNCTION;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

/**
 *
 * @author julien
 */
public class TestCLIFUNCTIONtest {

	public TestCLIFUNCTIONtest() {
	}

	@BeforeAll
	public static void setUpClass() {
	}

	@AfterAll
	public static void tearDownClass() {
	}

	@BeforeEach
	public void setup() {
	}

	@AfterEach
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	/**
	 *
	 */
	@Test
	public void testisvalidport() {
		System.out.println("dafga");

		/*
		Cannot be a characters
		between 49152 and 65535
		
		System.out.println("dafga");
		 */
		assertFalse(CLIFUNCTION.isvalidport(1000));
		assertFalse(CLIFUNCTION.isvalidport(49151));
		assertFalse(CLIFUNCTION.isvalidport(65536));
		assertFalse(CLIFUNCTION.isvalidport(-50000));

		assertTrue(CLIFUNCTION.isvalidport(55555));
		assertTrue(CLIFUNCTION.isvalidport(49152));
		assertTrue(CLIFUNCTION.isvalidport(65535));
		assertTrue(CLIFUNCTION.isvalidport(50000));

	}

	@Test
	public void testlocate() {
		assertEquals(CLIFUNCTION.locate("start -p 45346".split(" "), "-p"), 1);

	}

	@Test
	public void testgetnumberargument() {
		assertEquals(CLIFUNCTION.getnumberargument("start -p 55554".split(" "), "-p"), 55554);
		assertEquals(CLIFUNCTION.getnumberargument("start -p".split(" "), "-p"), -2);
		assertEquals(CLIFUNCTION.getnumberargument("start -p dfaa".split(" "), "-p"), -2);
		assertEquals(CLIFUNCTION.getnumberargument("start -p 1.4".split(" "), "-p"), -2);
		assertEquals(CLIFUNCTION.getnumberargument("start 64532".split(" "), "-p"), -1);
		assertEquals(CLIFUNCTION.getnumberargument("start".split(" "), "-p"), -1);
	}
}
