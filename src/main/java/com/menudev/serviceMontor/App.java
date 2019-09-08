package com.menudev.serviceMontor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.menudev.serviceMontor.observers.ServicMobileCaller;
import com.menudev.serviceMontor.observers.ServiceCallerImpl;

/**
 * Hello world!
 *
 */
public class App {
	private BlockingQueue<ServiceType> blockingQueue = new LinkedBlockingQueue<ServiceType>(5);
	private Monitor monitor = new Monitor();
	private ServiceEventsProducer serviceEventsProducer = new ServiceEventsProducer(blockingQueue);
	private ServiceEventsConsumer serviceEventConsumer = new ServiceEventsConsumer(blockingQueue,monitor);
	//private static Monitor monitor;

	public static void main(String[] args) {
		App app = new App();
		app.intitiate();
	
		System.out.println("Hello World!");
		
	}


	private void intitiate() {
		new ServiceCallerImpl(monitor);
		new ServicMobileCaller(monitor);
		Thread t1 = new Thread(serviceEventsProducer);
		Thread t2 = new Thread(serviceEventConsumer);
		t1.start();
		t2.start();
		// add a observer to monitor
		System.out.println("first call "); 
	}

}
