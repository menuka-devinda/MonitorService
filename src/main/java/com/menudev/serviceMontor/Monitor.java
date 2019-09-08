package com.menudev.serviceMontor;

import java.util.ArrayList;
import java.util.List;

import com.menudev.serviceMontor.observers.ServicMobileCaller;
import com.menudev.serviceMontor.observers.ServiceCallerImpl;
import com.menudev.serviceMontor.service.Observer;
import com.menudev.serviceMontor.service.Subject;

public class Monitor implements Subject {

	private final List<Observer> observers = new ArrayList<>();

	public Monitor() {
	}

	@Override
	public void addCaller(Observer serviceObserver) {
		observers.add(serviceObserver);
	}

	@Override
	public void removeCaller(Observer serviceObserver) {
		observers.remove(serviceObserver);
	}

	@Override
	public void notifiyCallers(ServiceType serviceType) {

		observers.forEach(obs -> {

			if (obs instanceof ServiceCallerImpl) {
				((ServiceCallerImpl) obs).getServiceTypeAndFrequencymap().forEach((k, v) -> {
					if (k.equals(serviceType)) {
						obs.update(this, serviceType);
					}
				});
			}
			
			if (obs instanceof ServicMobileCaller) {
				((ServicMobileCaller) obs).getServiceTypeAndFrequencymap().forEach((k, v) -> {
					if (k.equals(serviceType)) {
						obs.update(this, serviceType);
					}
				});
			}
		});
	}

	@Override
	public void setStatus(ServiceType serviceType) {

		notifiyCallers(serviceType);

	}

}
