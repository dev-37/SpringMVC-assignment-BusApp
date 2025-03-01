package assignment6.dao;

import java.util.List;

import assignment6.model.Bus;

public interface BusDAO {
	public List<Bus> getBuses(String location);

	public List<Bus> getBuses();

	public int addNewBus(Bus bus);
}
