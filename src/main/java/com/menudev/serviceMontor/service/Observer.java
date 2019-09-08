package com.menudev.serviceMontor.service;

import java.util.List;
import java.util.Map;

import com.menudev.serviceMontor.Monitor;
import com.menudev.serviceMontor.ServiceType;

//subscriber can decide the service and frequency
public interface Observer {

	public void update(Monitor monitor, ServiceType serviceType2);
	//public Map<Observer, List<ServiceType>> getObserverWithServicesMap();

}
