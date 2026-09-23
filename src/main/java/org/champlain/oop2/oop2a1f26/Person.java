package org.champlain.oop2.oop2a1f26;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * The class Person represents the possible person trying to purchase a parking
 * pass. It takes in 3 parameters, name, date of birth, and email address.
 * 
 * @author OwenHuxter
 * 
 */
public final class Person {

  /**
   * Holds the name of the person created. Final to be immutable.
   */
  private final String aName;
  /**
   * Holds the date of birth of a person instance
   */
  private final LocalDate aDOB;
  /**
   * Holds the email address of a person instance. Only saved if it matches the
   * regex pattern.
   */
  private final String aEmailAddress;
  /**
   * boolean attribute to be changed when person holds a parking pass
   */
  private boolean aPurchasedParkingPass = false;

  /**
   * The method validateParameters checks if the parameters given are valid
   * compared to the requirements to input. This allows for the constructor to
   * have a clearer objective and not to be cluttered with input validation.
   * 
   * @param pPersonName the person's name, cannot be null or blank
   * @param pDOB the person's date of birth, cannot be null, in the future, or
   * before 1909/8/21
   * @param pEmailAddress the person's email address, cannot be null or blank,
   * must match regex pattern
   * @return returns true if all parameters are valid, otherwise
   * @throws IllegalArgumentException when any of the parameters are invalid,
   * with a message to explain what is
   */
  public boolean validateParamaters(String pPersonName, LocalDate pDOB, String pEmailAddress) {
    if (pPersonName == null || pPersonName.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or blank.");
    }
    if (pDOB == null || pDOB.isAfter(LocalDate.now()) ||
    // This is the oldest person currently alive; if you're older, let's call
    // guinness
        pDOB.isBefore(LocalDate.of(1909, 8, 21))) {
      throw new IllegalArgumentException("Date of birth cannot be null,\n in the future, or before 1909/8/21.");
    }
    if (pEmailAddress == null || pEmailAddress.isBlank()) {
      throw new IllegalArgumentException("Email address cannot be null or blank.");
    } else if (!isValidEmail(pEmailAddress)) {
      throw new IllegalArgumentException("Invalid email address format.");
    }
    return true;
  }

  /**
   * Constructor for the Person class. It takes in 3 parameters types String,
   * LocalDate and String. Then Validates the paramaters in a called method.
   * 
   * @param pPersonName Value to be assigned to the attribute {@link #aName}
   * @param pDOB Value to be assigned to the attribute {@link #aDOB}
   * @param pEmailAddress Value to be assigned to the attribute
   * {@link #aEmailAddress}
   * @throws IllegalArgumentException if any of the parameters are invalid and
   * it makes through the validateParameters' method's exception check.
   */
  public Person(String pPersonName, LocalDate pDOB, String pEmailAddress) {
    if (!validateParamaters(pPersonName, pDOB, pEmailAddress)) {
      throw new IllegalArgumentException("Failed to validate parameters.");
    }

    this.aName = pPersonName;
    this.aDOB = pDOB;
    this.aEmailAddress = pEmailAddress;
  }

  /**
   * isValidEmail checks if the email address follows a regex pattern; if not
   * valid, it will return false, which will throw an IllegalArgumentException
   * in the validateParameters method.
   * 
   * @param pEmailAddress the email address to be checked against the regex
   * pattern
   * @return true if the given email address matches the regex pattern,
   * otherwise false.
   */
  private boolean isValidEmail(String pEmailAddress) {
    final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    return EMAIL_PATTERN.matcher(pEmailAddress).matches();
  }

  /**
   * checks if the attribute {@link #aPurchasedParkingPass} is true or false,
   * and then returns a boolean value.
   * 
   * @return the boolean value of the attribute {@link #aPurchasedParkingPass}
   */
  public boolean isPurchasedParkingPass() {
    return aPurchasedParkingPass;
  }

  /**
   * purchaseParkingPass sets the attribute {@link #aPurchasedParkingPass} to
   * true, then returns the value of aPurchasedParkingPass.
   * 
   * @return the value of aPurchasedParkingPass, which is now true.
   */
  public boolean purchaseParkingPass() {
    this.aPurchasedParkingPass = true;
    return aPurchasedParkingPass;
  }

  /**
   * getName returns the value of the attribute {@link #aName}.
   * 
   * @return the String value of the attribute {@link #aName}
   */
  public String getName() {
    return this.aName;
  }

  /**
   * getDOB returns the value of the attribute {@link #aDOB}.
   * 
   * @return returns the value of the attribute {@link #aDOB}.
   */
  public LocalDate getDOB() {
    return this.aDOB;
  }

  /**
   * getEmailAddress returns the value of the attribute {@link #aEmailAddress}.
   * 
   * @return returns the value of the attribute {@link #aEmailAddress}.
   */
  public String getEmailAddress() {
    return this.aEmailAddress;
  }

  /**
   * Overrides the toString method in order to return legible values into the
   * alert window which allows for the user to see what values were saved.
   * 
   * @return a string representation of the inputted values of the person
   * instance.
   */
  @Override
  public String toString() {
    return "Person{" + aName + '\'' + ", " + aDOB + ", " + aEmailAddress + '\'' + '}';
  }
}
