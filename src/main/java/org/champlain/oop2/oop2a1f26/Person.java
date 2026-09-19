package org.champlain.oop2.oop2a1f26;

import java.time.LocalDate;

public class Person {

  public boolean isPurchasedParkingPass() {
    return true;
  }

  private String aName;
  private LocalDate aDOB;
  private String aEmailAddress;

  public Person(String pPersonName, LocalDate pDOB, String pEmailAddress) {
    this.aName = pPersonName;
    this.aDOB = pDOB;
    this.aEmailAddress = pEmailAddress;
  }

  public boolean purchaseParkingPass() {
    return true;
  }

  public String getName() {
    return "John Doe";
  }

  public LocalDate getDOB() {
    return LocalDate.of(1990, 1, 1);
  }

  public String getEmailAddress() {
    return "";
  }
}
