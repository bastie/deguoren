/**
 * 
 */
package biz.ritter.德国人;

import biz.ritter.德国人.util.TripleProperties;

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
    props.load(null);
  }
}
