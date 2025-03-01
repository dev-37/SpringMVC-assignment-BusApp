package assignment6.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import assignment6.model.Bus;

@Repository
public class BusDAOImpl implements BusDAO {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Bus> getBuses() {
		// TODO Auto-generated method stub

		return template.query("select * from buses", new RowMapper<Bus>() {
			public Bus mapRow(ResultSet rs, int row) throws SQLException {
				return new Bus(rs.getString("bus_name"), rs.getString("location"), rs.getInt("ticket_price"));
			}
		});

	}

	@Override
	public List<Bus> getBuses(String location) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM buses WHERE location = ?";
		return template.query(sql, new RowMapper<Bus>() {
			public Bus mapRow(ResultSet rs, int row) throws SQLException {
				return new Bus(rs.getString("bus_name"), rs.getString("location"), rs.getInt("ticket_price"));
			}
		}, location);
	}

	@Override
	public int addNewBus(Bus bus) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO buses(bus_name, location, ticket_price) VALUES (?, ?, ?)";
		return template.update(sql, bus.getBus_name(), bus.getLocation(), bus.getTicket_price());
	}
}
