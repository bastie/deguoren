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
package biz.ritter.德国人.util;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Völlig bescheuerte Implementation eines Dreierpakets an Schlüssel-Wert-Wert 
 * Zuordnung
 * 
 * @author Sͬeͥbͭaͭsͤtͬian
 *
 */
public class TripleProperties {

  /**
   * Interne Verwaltung
   */
  private HashMap<String, TripleProperty> propertyContainer = new HashMap<String, TripleProperty>();
  
  /**
   * Lädt (irgendwann) entsprechende Property-Dateien
   * @param ignored irgendwann mal auszuwertender InputStream
   */
  public void load (InputStream ignored) {
    this.put("德国人", "dé guó rén", "Deutscher")
    .put("人", "rén", "Mensch")
    .list(System.out);
  }
  
  /**
   * Fügt eine neue Property dem internen Container hinzu
   * @param newProperty die neu hinzuzufügende Property
   * @return TripleProperties die neu gefüllte Liste
   * @pattern Fluent
   */
  protected TripleProperties put (TripleProperty newProperty) {
    this.propertyContainer.put(newProperty.getKey(), newProperty);
    return this;
  }
  
  /**
   * Fügt eine neue Property hinzu
   * @param key Schlüssel
   * @param firstValue erster Wert
   * @param secondValue zweiter Wert
   * @return TripleProperties die neue gefüllte Liste
   * @pattern Fluent
   */
  public TripleProperties put (String key, String firstValue, String secondValue) {
    this.put(new TripleProperty(new String [] {key,firstValue,secondValue}));
    return this;
  }
  
  /**
   * Interne Konstante wie breit die Ausgabe sein soll.
   */
  private final int MAX_LIST_PRINT_LENGTH = 79;
  /**
   * Interne Konstante, wo die Ausgabe abgebrochen werden soll
   */
  private final int LIST_PRINT_TEXT_LENGTH = MAX_LIST_PRINT_LENGTH-"...".length();
  /**
   * Gibt die Liste der TripleProperties aus
   * @param outputStream Stream wohin die Ausgabe erfolgen soll
   * @return TripleProperties
   * @pattern Fluent
   */
  public TripleProperties list (PrintStream outputStream) {
    outputStream.println("-- listing properties --");
    Iterator<String> keyIterator = this.propertyContainer.keySet().iterator();
    while (keyIterator.hasNext()) {
      String key = keyIterator.next();
      String firstValue = this.propertyContainer.get(key).getFirstValue();
      String secondValue = this.propertyContainer.get(key).getSecondValue();
      String propertyPrintLine = key+"="+firstValue+"="+secondValue;
      if (MAX_LIST_PRINT_LENGTH < propertyPrintLine.length()) {
        propertyPrintLine = propertyPrintLine.substring(0,LIST_PRINT_TEXT_LENGTH) + "...";
      }
      outputStream.println(propertyPrintLine);
    }
    return this;
  }
  /**
   * Gibt die Liste der TripleProperties aus
   * @param writer Writer wohin die Ausgabe erfolgen soll
   * @return TripleProperties
   * @pattern Fluent
   */
  public TripleProperties list (PrintWriter writer) {
    writer.println("-- listing properties --");
    Iterator<String> keyIterator = this.propertyContainer.keySet().iterator();
    while (keyIterator.hasNext()) {
      String key = keyIterator.next();
      String firstValue = this.propertyContainer.get(key).getFirstValue();
      String secondValue = this.propertyContainer.get(key).getSecondValue();
      String propertyPrintLine = key+"="+firstValue+"="+secondValue;
      if (MAX_LIST_PRINT_LENGTH < propertyPrintLine.length()) {
        propertyPrintLine = propertyPrintLine.substring(0,LIST_PRINT_TEXT_LENGTH) + "...";
      }
      writer.println(propertyPrintLine);
    }
    return this;
  }

}
