import aone.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.junit.Assert.*;

public class testUtil {

  @Test
  public void testIsNumeric01() {
    String content = "outlook\ttemperature\thumidity\twindy\tclass\n";
    assertFalse(Util.isNumeric(content));
  }

  @Test
  public void testIsNumeric02() {
    String content = "outlook\\444humidity\\4windy\\4class\\4";
    assertFalse(Util.isNumeric(content));
  }

  @Test
  public void testIsNumeric03() {
    String content = null;
    assertFalse(Util.isNumeric(content));
  }

  @Test
  public void testIsNumeric04() {
    String content = "12334456546";
    assertTrue(Util.isNumeric(content));
  }

  @Test
  public void testIsNumeric05() {
    String content = "";
    assertFalse(Util.isNumeric(content));
  }

  @Test
  public void testIsNumeric06() {
    String content = "1233-4456-546";
    assertFalse(Util.isNumeric(content));
  }

  @Test
  public void testIsArrayNumeric01() {
    String[] content = new String[]{};
    assertFalse(Util.isArrayNumeric(content));
  }

  @Test
  public void testIsArrayNumeric02() {
    String[] content = null;
    assertFalse(Util.isArrayNumeric(content));
  }

  @Test
  public void testIsArrayNumeric03() {
    String[] content = new String[]{"1", "2", "3", "..."};
    assertFalse(Util.isArrayNumeric(content));
  }

  @Test
  public void testIsArrayNumeric04() {
    String[] content = new String[]{"1", "2", "3", "4", "5"};
    assertTrue(Util.isArrayNumeric(content));
  }
  
  
  @Test
  public void testnominalArrayToString01() {
    String[] content = new String[]{"a", "b", "c", "d", "e"};
    assertEquals("['a', 'b', 'c', 'd', 'e']", Util.nominalArrayToString(content));
  }
  
  @Test
  public void testnominalArrayToString02() {
    String[] content = new String[]{"boom", "Hello", "World", "$qmwd12@!#%", ""};
    assertEquals("['boom', 'Hello', 'World', '$qmwd12@!#%', '']", Util.nominalArrayToString(content));
  }
  
  @Test
  public void testnominalArrayToString03() {
    assertEquals(null, Util.nominalArrayToString(null));
  }
  
  @Test
  public void testnominalArrayToString04() {
    String[] content = new String[]{""};
    assertEquals("['']", Util.nominalArrayToString(content));
  }
  
  @Test
  public void testnominalArrayToString05() {
    String[] content = new String[]{"word"};
    assertEquals("['word']", Util.nominalArrayToString(content));
  }
  
  @Test
  public void testnumericArrayToString01() {
	Util obj = new Util();
    String[] content = new String[]{"12", "100", "", "32", "0"};
    assertEquals("[12, 100, , 32, 0]", obj.numericArrayToString(content));
  }
  
  @Test
  public void testnumericArrayToString02() {
    String[] content = new String[]{"1"};
    assertEquals("[1]", Util.numericArrayToString(content));
  }
  
  @Test
  public void testnumericArrayToString03() {
    String[] content = new String[]{""};
    assertEquals("[]", Util.numericArrayToString(content));
  }
  
  @Test
  public void testnumericArrayToString04() {
    assertEquals(null, Util.numericArrayToString(null));
  }
}
