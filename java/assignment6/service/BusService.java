package assignment6.service;

import java.util.List;

import assignment6.model.Bus;

public interface BusService {
	public List<Bus> getBus();

	public List<Bus> getBus(String location);

	public void addBus(Bus bus);
	
	
}
