package app.dao;

import app.models.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TicketMapper implements RowMapper<Ticket> {

  @Override
  public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {

    Ticket ticket = new Ticket();

    ticket.setId(resultSet.getInt("id"));
    ticket.setDate(resultSet.getString("date"));
    ticket.setTime(resultSet.getString("time"));
    ticket.setFlightNumber(resultSet.getInt("flight_number"));
    ticket.setStatus(resultSet.getString("status"));

    return ticket;
  }
}
