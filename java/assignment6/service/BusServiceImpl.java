package assignment6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment6.dao.BusDAO;
import assignment6.model.Bus;

@Service
public class BusServiceImpl implements BusService {
	@Autowired
	BusDAO busDao;

	@Override
	public List<Bus> getBus() {
		// TODO Auto-generated method stub
		return busDao.getBuses();

	}

	@Override
	public void addBus(Bus bus) {
		// TODO Auto-generated method stub
		busDao.addNewBus(bus);

	}

	@Override
	public List<Bus> getBus(String location) {
		// TODO Auto-generated method stub
		return busDao.getBuses(location);
	}

}
