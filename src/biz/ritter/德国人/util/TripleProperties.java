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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Völlig bescheuerte Implementation eines Dreierpakets an Schlüssel-Wert-Wert 
 * Zuordnung
 * 
 * @author Sͬeͥbͭaͭsͤtͬian
 * @version 0.3
 */
public class TripleProperties<E> {

  /**
   * Interne Verwaltung
   */
  private HashMap<E, TripleProperty> propertyContainer = new HashMap<E, TripleProperty>();
  
  /**
   * Lädt entsprechende Property-Dateien
   * @param newInput auszuwertender InputStream
   * @throws IOException wenn der InputStream nicht existiert
   */
  public void load (InputStream newInput) throws IOException {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(newInput, "utf-8"));
  
      final char COMMENT_LINE_IDENTIFIER = '#';
      String nextLine = null;
      while (null != (nextLine = br.readLine())) {
        nextLine = nextLine.trim();
        if (nextLine.length()>0) {
          if (nextLine.charAt(0) != COMMENT_LINE_IDENTIFIER) {
            int firstEqualChar = nextLine.indexOf("=");
            int secondEqualChar = nextLine.indexOf("=", firstEqualChar+1);
            String key = nextLine.substring(0,firstEqualChar++).trim();
            String firstValue = nextLine.substring(firstEqualChar, secondEqualChar++).trim();
            String secondValue = nextLine.substring(secondEqualChar).trim();
            
            this.put(key, firstValue, secondValue);
          }
        }
      }
    }
    catch (Exception throwAsIOException) {
      throw new IOException(throwAsIOException);
    }
  }
  
  /**
   * Leert die Properties
   */
  public void clear () {
    this.propertyContainer = new HashMap<E, TripleProperty>();
  }
  
  /**
   * Eine Sammlung der Schlüsselwerte
   * @return Schlüsselwerte
   */
  public Set<E> keySet () {
    return this.propertyContainer.keySet();
  }
  
  /**
   * Fügt eine neue Property dem internen Container hinzu
   * @param newProperty die neu hinzuzufügende Property
   * @return TripleProperties die neu gefüllte Liste
   * @pattern Fluent
   */
  protected TripleProperties<E> put (TripleProperty newProperty) {
    this.propertyContainer.put((E)newProperty.getKey(), newProperty); //FIXME - Casting nach E ist grenzwertig
    return this;
  }
  
  /**
   * Liefert ein TripleProperty Objekt, welches unter dem übergebenen
   * Schlüssel gespeichert ist.
   * @param key Schlüssel
   * @return TripleProperty Objekt
   */
  public TripleProperty get (E key) {
    return this.propertyContainer.get(key);
  }
  
  /**
   * Fügt eine neue Property hinzu
   * @param key Schlüssel
   * @param firstValue erster Wert
   * @param secondValue zweiter Wert
   * @return TripleProperties die neue gefüllte Liste
   * @pattern Fluent
   */
  public TripleProperties<E> put (String key, String firstValue, String secondValue) {
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
  public TripleProperties<E> list (PrintStream outputStream) {
    outputStream.println("-- listing properties --");
    Iterator<E> keyIterator = this.propertyContainer.keySet().iterator();
    while (keyIterator.hasNext()) {
      E key = keyIterator.next();
      TripleProperty property = this.propertyContainer.get(key);
      outputStream.println(property.toString());
    }
    return this;
  }
  /**
   * Gibt die Liste der TripleProperties aus
   * @param writer Writer wohin die Ausgabe erfolgen soll
   * @return TripleProperties
   * @pattern Fluent
   */
  public TripleProperties<E> list (PrintWriter writer) {
    writer.println("-- listing properties --");
    Iterator<E> keyIterator = this.propertyContainer.keySet().iterator();
    while (keyIterator.hasNext()) {
      E key = keyIterator.next();
      TripleProperty property = this.propertyContainer.get(key);
      writer.println(property.toString());
    }
    return this;
  }

}
