package org.champlain.oop2.oop2a1f26;

import java.time.LocalDate;
import java.util.regex.Pattern;

public final class Person {

  private final String aName;
  private final LocalDate aDOB;
  private final String aEmailAddress;
  private boolean aPurchasedParkingPass = false;

  public Person(String pPersonName, LocalDate pDOB, String pEmailAddress) {
    if (pPersonName == null || pPersonName.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or blank.");
    }
    if (
      pDOB == null ||
      pDOB.isAfter(LocalDate.now()) ||
      //This is the oldest person currently alive, if your older, lets call guinness
      pDOB.isBefore(LocalDate.of(1909, 8, 21))
    ) {
      throw new IllegalArgumentException(
        "Date of birth cannot be null,\n in the future, or before 1909/8/21."
      );
    }
    if (pEmailAddress == null || pEmailAddress.isBlank()) {
      throw new IllegalArgumentException(
        "Email address cannot be null or blank."
      );
    } else if (!isValidEmail(pEmailAddress)) {
      throw new IllegalArgumentException("Invalid email address format.");
    }
    this.aName = pPersonName;
    this.aDOB = pDOB;
    this.aEmailAddress = pEmailAddress;
  }

  private boolean isValidEmail(String pEmailAddress) {
    final Pattern EMAIL_PATTERN = Pattern.compile(
      "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );
    return EMAIL_PATTERN.matcher(pEmailAddress).matches();
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
