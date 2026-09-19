package org.champlain.oop2.oop2a1f26;

import java.time.LocalDate;

public final class Person {

  private final String aName;
  private final LocalDate aDOB;
  private final String aEmailAddress;
  private boolean aPurchasedParkingPass = false;

  public Person(String pPersonName, LocalDate pDOB, String pEmailAddress) {
    this.aName = pPersonName;
    this.aDOB = pDOB;
    this.aEmailAddress = pEmailAddress;
  }

  public boolean isPurchasedParkingPass() {
    return aPurchasedParkingPass;
  }

  public boolean purchaseParkingPass() {
    this.aPurchasedParkingPass = true;
    return aPurchasedParkingPass;
  }

  public String getName() {
    return this.aName;
  }

  public LocalDate getDOB() {
    return this.aDOB;
  }

  public String getEmailAddress() {
    return this.aEmailAddress;
  }
}
