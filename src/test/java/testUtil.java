import aone.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

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
}
