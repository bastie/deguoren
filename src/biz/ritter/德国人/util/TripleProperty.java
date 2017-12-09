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
 *
 */
class TripleProperty {

  private String key;
  private String firstValue;
  private String secondValue;
  
  public TripleProperty (String... keyValueValue) {
    this.setProperty(keyValueValue);
  }

  public void setProperty(String... keyValueValue) {
    if (null != keyValueValue) {
      for (int i = 0; i < keyValueValue.length; i++) {
        switch (i) {
        case 0: key = keyValueValue [0]; break;
        case 1: firstValue = keyValueValue [1]; break;
        case 2: secondValue = keyValueValue [2]; break;
        default: // ignore
          break;
        }
      }
    } 
  }
  public void setProperty(String newKey, String newFirstValue, String newSecondValue) {
    this.key = newKey.intern();
    this.firstValue = newFirstValue.intern();
    this.secondValue = newSecondValue.intern();
  }
  public String getFirstValue () {
    return this.firstValue;
  }
  public String getSecondValue() {
    return this.secondValue;
  }
  public String getKey () {
    return this.key;
  }
}
