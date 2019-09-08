package com.menudev.serviceMontor;

import com.menudev.serviceMontor.Monitor;
import com.menudev.serviceMontor.ServiceType;
import com.menudev.serviceMontor.observers.ServiceCallerImpl;
import com.menudev.serviceMontor.service.Observer;
import com.menudev.serviceMontor.service.Subject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void test () {
		assertTrue(true);
	}

	/**
	 * create simple observer with a ServiceType and get it is status.
	 */
//	public void testMonitorService_singleUser() {
//		// Observable monitor
//		Subject subject = new Monitor();
//		Observer serviceObserver = new ServiceCallerImpl();
//		// add a observer to monitor
//		subject.addCaller(serviceObserver);
//		// change the status of the service
//		subject.notifiyCallers(new ServiceType(80, "localhost"));
//		// the change should be available to
//		//assertEquals("localhost", serviceObserver.getServiceType().getHost());
//
//	}
	//create ServiceType should give the status
	//remove ServiceType should give the status
	//when it is polling on every frequecny it should gives you the status

	/**
	 * when the status change on monitor the subscribe caller get the update
	 */
	public void testMonitorService_sameProperties() {
		// Observable monitor
		Subject subject = new Monitor();
		Observer caller = new ServiceCallerImpl(subject);
		// add a observer to monitor
		
		System.out.println("first call ");
		//subject.setStatus(new ServiceType(80, "localhost"));
		//assertEquals("Service : localhost port : 80", subject.setStatus(new ServiceType(80, "localhost")));
		
				
	}
	
	

}
