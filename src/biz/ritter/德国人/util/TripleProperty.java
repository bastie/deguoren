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

/**
 * Eine Propertyklasse, welche zur Verarbeitung von Dreierbeziehungen, wie 
 * diese z.B. bei asiatischen Sprachen Verwendung findet.
 * 
 * <p/><strong>Beispiel:</strong>
 * <table border='1'><tr><td>Chinesische Wörter / Zeichen</td>
 * <td>Lateinische &quot;Ausspracheschrift&quot;</td>
 * <td>Deutsche Wörter / Zeichen</td></tr>
 * <tr><td>德国人</td><td>dé guó rén</td><td>Deutsch (er Mensch)</td></tr>
 * </table>
 * 
 * @author Sͬeͥbͭaͭsͤtͬian
 * @version 2.0 (Sichtbarkeit public)
 */
public class TripleProperty {

  /**
   * Der Schlüssel
   */
  private String key;
  /**
   * Der erste zugeordnete Wert
   */
  private String firstValue;
  /**
   * Der zweite zugeordnete Wert
   */
  private String secondValue;
  
  /**
   * Erzeugt eine neue TripleProperty anhand der Übergabe
   * @param keyValueValue Array mit dem Schlüssel und zwei zuzuorndenen Werten
   */
  public TripleProperty (String... keyValueValue) {
    this.setProperty(keyValueValue);
  }

  /**
   * Setzt eine Property
   * @param keyValueValue Array mit dem Schlüssel und zwei zuzuorndenen Werten
   */
  public void setProperty(String... keyValueValue) {
    if (null != keyValueValue) {
      for (int i = 0; i < keyValueValue.length; i++) {
        switch (i) {
        case 0: key = keyValueValue [0].intern(); break;
        case 1: firstValue = keyValueValue [1].intern(); break;
        case 2: secondValue = keyValueValue [2].intern(); break;
        default: // ignore
          break;
        }
      }
    } 
  }
  /**
   * Setzt eine Property
   * @param newKey Schlüssel
   * @param newFirstValue erster Wert
   * @param newSecondValue zweiter Wert
   */
  public void setProperty(String newKey, String newFirstValue, String newSecondValue) {
    this.key = newKey.intern();
    this.firstValue = newFirstValue.intern();
    this.secondValue = newSecondValue.intern();
  }
  /**
   * Liefert den ersten Wert der Property
   * @return Wert Nummer 1
   */
  public String getFirstValue () {
    return this.firstValue;
  }
  /**
   * Liefert den zweiten Wert der Property
   * @return Wert Nummer 2
   */
  public String getSecondValue() {
    return this.secondValue;
  }
  /**
   * Liefert den Schlüssel
   * @return
   */
  public String getKey () {
    return this.key;
  }

  /**
   * Interne Konstante wie breit die Ausgabe sein soll.
   */
  private final int MAX_LIST_PRINT_LENGTH = 79;
  /**
   * Interne Konstante, wo die Ausgabe abgebrochen werden soll
   */
  private final int LIST_PRINT_TEXT_LENGTH = MAX_LIST_PRINT_LENGTH-"...".length();
  
  @Override
  public String toString() {
    String firstValue = this.getFirstValue();
    String secondValue = this.getSecondValue();
    String propertyPrintLine = key+"="+firstValue+"="+secondValue;
    if (MAX_LIST_PRINT_LENGTH < propertyPrintLine.length()) {
      propertyPrintLine = propertyPrintLine.substring(0,LIST_PRINT_TEXT_LENGTH) + "...";
    }
    return propertyPrintLine;
  }
}
