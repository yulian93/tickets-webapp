package app.dao;

import app.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TicketDAO {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public TicketDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Ticket show(int id) {
    return jdbcTemplate.query("SELECT * FROM all_tickets WHERE id=?", new Object[]{id}, new TicketMapper())
        .stream().findAny().orElse(null);
  }

  public void save(Ticket ticket) {
    jdbcTemplate.update("INSERT all_tickets VALUES (?,?,?,?,?)", ticket.getId(),
         ticket.getDate(), ticket.getTime(), ticket.getFlightNumber(), ticket.getStatus());
  }
}

