/**
 * Copyright 2017 Sebastian Ritter
 *
 * Lizenziert unter der EUPL, nur Version 1.1 ("Lizenz");
 * 
 * Sie dürfen dieses Werk ausschließlich gemäß
 * dieser Lizenz nutzen.
 * Eine Kopie der Lizenz finden Sie hier:
 *
 * http://ec.europa.eu/idabc/eupl5
 * 
 * Sofern nicht durch anwendbare Rechtsvorschriften
 * gefordert oder in schriftlicher Form vereinbart, wird
 * die unter der Lizenz verbreitete Software "so wie sie
 * ist", OHNE JEGLICHE GEWÄHRLEISTUNG ODER BEDINGUNGEN -
 * ausdrücklich oder stillschweigend - verbreitet.
 * Die sprachspezifischen Genehmigungen und Beschränkungen
 * unter der Lizenz sind dem Lizenztext zu entnehmen.
 */
package biz.ritter.德国人;

import biz.ritter.德国人.util.TripleProperties;

import java.io.InputStream;

/**
 * Startklasse für die Anwendung.
 * 
 * @author Sͬeͥbͭaͭsͤtͬian
 */
public class 德国人 implements Runnable {

  /**
   * Einsprungspunkt für die Anwendung
   * 
   * @param args Anwendungsparameter
   */
  public static void main (final String... args) {
    try {
      new 德国人().setzeAnwendungsparameter(args).starteAnwendung();
    }
    catch (Throwable defaultErrorHandling) {
      
    }
  }

  /**
   * Setzt anwendungsspezifische Parameter.
   * @param args Anwendungsparameter
   * @return Instanz
   * @pattern FluentInterface
   */
  public 德国人 setzeAnwendungsparameter (final String... args) {
    return this;
  }
  
  /**
   * Startet die Anwendung.
   * @return Instanz
   * @pattern FluentInterface
   */
  public 德国人 starteAnwendung () {
    this.run();
    return this;
  }
  
  /**
   * Technische Startmethode für die Anwendung.
   * @see #starteAnwendung()
   */
  public void run () {
    TripleProperties props = new TripleProperties();
    try {
      props.load(this.getClass().getResourceAsStream("/biz/ritter/res/中文字/Sammlung.properties"));
      props.list(System.out);
    }
    catch(Throwable notSoGood) {
      notSoGood.printStackTrace();
    }
  }
}
