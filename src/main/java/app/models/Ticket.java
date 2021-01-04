package app.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Ticket {
  private static int COUNT;
  private int id;
  @NotEmpty(message = "Date should not be empty")
  private String date;
  @NotEmpty(message = "Time should not be empty")
  private String time;

  @Min(value = 1, message = "Flight number is wrong.")
  private int flightNumber;
  private String status = "processed";

  public Ticket() {
   this.id = ++COUNT;
  }

  public Ticket(int id, String date, String time, int flightNumber) {

    this.id = id;
    this.date = date;
    this.time = time;
    this.flightNumber = flightNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}