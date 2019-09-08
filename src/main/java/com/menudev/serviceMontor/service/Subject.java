package com.menudev.serviceMontor.service;

import com.menudev.serviceMontor.ServiceType;

public interface Subject {

	void addCaller(Observer serviceObserver);

	void removeCaller(Observer serviceObserver);

	void notifiyCallers(ServiceType serviceType);

	void setStatus(ServiceType serviceType);
}
