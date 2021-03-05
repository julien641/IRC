/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIFUNCTIONTEST;

import Commands.start;
import java.io.ByteArrayInputStream;
import javafxchatserver.Javafxchatserver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julien
 */
public class TestCLI {

	static Javafxchatserver server;

	public TestCLI() {
	}

	@BeforeClass
	public static void setUpClass() {

	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		System.setIn(new ByteArrayInputStream("\n".getBytes()));

		server = new Javafxchatserver();

	}

	@After
	public void tearDown() {

	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	@Test
	public void start() {
		start x = new start(server, "start");
		x.run();
		assertNotNull(server.getServer());
		assertNotNull(server.getThread());
		assertTrue(server.getThread().isAlive());
		assertEquals(server.getServer().getPort(), 55555);
		server.setRunning(false);
		server.getServer().setRunning(false);
		System.out.println("finished");
	}

	@Test
	public void startp55554() {
		start x = new start(server, "start -p 55554");
		x.run();
		assertNotNull(server.getServer());
		assertNotNull(server.getThread());
		assertTrue(server.getThread().isAlive());
		assertEquals(server.getServer().getPort(), 55554);
		server.setRunning(false);
		server.getServer().setRunning(false);
		System.out.println("finished");
	}

	@Test
	public void error() {
		start x = new start(server, "start -p");
		x.run();
		assertNull(server.getServer());
		assertNull(server.getThread());
		System.out.println("finished");
	}
}
