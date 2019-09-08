package com.menudev.serviceMontor.observers;

import java.util.HashMap;
import java.util.Map;

import com.menudev.serviceMontor.Monitor;
import com.menudev.serviceMontor.ServiceType;
import com.menudev.serviceMontor.service.Observer;
import com.menudev.serviceMontor.service.Subject;

public class ServicMobileCaller implements Observer {
	
	private Subject subject;
	private ServiceType serviceType;
	private Map<ServiceType, Long > serviceTypeAndFrequencymap;

	public ServicMobileCaller(Subject subject) {
		serviceTypeAndFrequencymap = new HashMap<>();
		
		
		serviceTypeAndFrequencymap.put(new ServiceType(8080, "mmqacf11"),2000l);
		
		if (subject instanceof Monitor) {
			this.subject = subject;
			subject.addCaller(this);
		}

	}


	public Map<ServiceType, Long> getServiceTypeAndFrequencymap() {
		return serviceTypeAndFrequencymap;
	}


	public void setServiceTypeAndFrequencymap(Map<ServiceType, Long> serviceTypeAndFrequencymap) {
		this.serviceTypeAndFrequencymap = serviceTypeAndFrequencymap;
	}


	@Override
	public void update(Monitor monitor, ServiceType serviceType2) {
		this.serviceType = serviceType2;
		display();
	}

	private void display() {
		System.out.println("Display Service Mobile : " + serviceType.getHost() + " port : " + serviceType.getPort()
				+ " status : " + serviceType.connectStatus().getValue());
	}

}