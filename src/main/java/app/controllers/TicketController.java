package app.controllers;

import app.dao.TicketDAO;
import app.models.Ticket;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")

public class TicketController {

  private final TicketDAO ticketDAO;

  @Autowired
  public TicketController(TicketDAO ticketDAO) {
    this.ticketDAO = ticketDAO;
  }

  @GetMapping("/main")
  public String getMainPage() {

    return "pages/main";
  }

  @GetMapping("/info/{id}")
  public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute("ticket", ticketDAO.show(id));
    return "pages/info";
  }

  @GetMapping("/show")
  public String enterID(@ModelAttribute("ticket") Ticket ticket) {

    return "pages/show";
  }

  @GetMapping("/new")
  public String newTicket(@ModelAttribute("ticket") Ticket ticket) {

    return "pages/new";
  }

  @PostMapping ()
  public String create(@ModelAttribute("ticket") @Valid Ticket ticket, BindingResult result) {
    if(result.hasErrors()){
      return "pages/new";
    }
    ticketDAO.save(ticket);
    return "redirect:/pages/info/"+ticket.getId();
  }

}
