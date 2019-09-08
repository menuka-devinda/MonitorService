package com.menudev.serviceMontor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ServiceEventsProducer implements Runnable {

	private BlockingQueue<ServiceType> blockingQueue;

	public ServiceEventsProducer(BlockingQueue<ServiceType> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("out producer");
		while (!Thread.currentThread().isInterrupted()) {
			//System.out.println("in producer");

			try {
				this.blockingQueue.put(getServicetypeWithRandomStaus());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Producer is stopped !");
				e.printStackTrace();
			}
		}
	}

	private ServiceType getServicetypeWithRandomStaus() {

		ServiceType serviceType = getAvailableServices().get(new Random().nextInt(4));
		//synchronized (serviceType) {
			int val = new Random().nextInt(5000);
			//System.out.println("val " + val + " modulor " + val % 2);
			serviceType.setStatus(val % 5 == 0 ? ServiceStatus.ServiceDown : ServiceStatus.ServiceUp);
			//System.out.println("xxx"+serviceType.connectStatus() + " "+serviceType.getHost());
		//}

		return serviceType;
	}

	private List<ServiceType> getAvailableServices() {
		List<ServiceType> serviceTypes = new ArrayList<>();
		serviceTypes.add(new ServiceType(80, "localhost"));
		serviceTypes.add(new ServiceType(8080, "mmqacf11"));
		serviceTypes.add(new ServiceType(25, "smtp"));
		serviceTypes.add(new ServiceType(459, "mmstagecf1101"));

		return serviceTypes;
	}
}
