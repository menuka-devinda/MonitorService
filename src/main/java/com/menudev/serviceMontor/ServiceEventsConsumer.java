package com.menudev.serviceMontor;

import java.util.concurrent.BlockingQueue;

public class ServiceEventsConsumer implements Runnable {

	private BlockingQueue<ServiceType> bolockingQueue;
	private ServiceType serviceType;
	private Monitor monitor;

	public ServiceEventsConsumer(BlockingQueue<ServiceType> bolockingQueue,Monitor monitor) {
		this.bolockingQueue = bolockingQueue;
		this.monitor=monitor;
	}

	@Override
	public void run() {
		System.out.println("out consumer");

		while (!Thread.currentThread().isInterrupted()) {
			try {
				this.serviceType = bolockingQueue.take();
				//System.out.println("service type " + serviceType.getHost() + " status " + serviceType.connectStatus());
				// max size that a service can be polled
				monitor.setStatus(serviceType);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("inturpted consumer");
				e.printStackTrace();
			}
		}
	}

	public ServiceType changeServiceStatus() {
		return serviceType;
	}

}
