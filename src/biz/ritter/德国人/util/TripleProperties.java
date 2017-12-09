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
 * @author Sͬeͥbͭaͭsͤtͬian
 *
 */
public class TripleProperties {

  private HashMap<String, TripleProperty> propertyContainer = new HashMap<String, TripleProperty>();
  
  public void load (InputStream ignored) {
    this.put("德国人", "dé guó rén", "Deutscher")
    .put("人", "rén", "Mensch")
    .list(System.out);
  }
  
  protected TripleProperties put (TripleProperty newProperty) {
    this.propertyContainer.put(newProperty.getKey(), newProperty);
    return this;
  }
  
  public TripleProperties put (String key, String firstValue, String secondValue) {
    this.put(new TripleProperty(new String [] {key,firstValue,secondValue}));
    return this;
  }
  
  private final int MAX_LIST_PRINT_LENGTH = 79;
  private final int LIST_PRINT_TEXT_LENGTH = MAX_LIST_PRINT_LENGTH-"...".length();
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
