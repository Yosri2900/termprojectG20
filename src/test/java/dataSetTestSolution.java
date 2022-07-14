import aone.DataSetSolution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class dataSetTestSolution {

  private final String CREDITINFO = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\credit-info.csv";
  private final String CREDITINFOWITHCOMMAS = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\credit-info-with-commas.csv";
  private final String LARGE = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\large.csv";
  private final String MISSINGVALUES = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\missing-values.csv";
  private final String WEATHERNOMINAL = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-nominal.csv";
  private final String WEATHERNUMERIC = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-numeric.csv";
  private final String WEATHERWITHSPACES = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-with-spaces.csv";

  @Test
  public void testWeatherConstructor() {
    DataSetSolution ds;
    try {
      ds = new DataSetSolution(WEATHERNOMINAL);
    } catch (Exception e) {
      fail("Should not have thrown any exception!");
    }
  }

  @Test
  public void testCreditWithoutCommasConstructor() {
    DataSetSolution ds;
    try {
      ds = new DataSetSolution(CREDITINFO);
    } catch (Exception e) {
      fail("Should not have thrown an exception!");
    }
  }

  @Test
  public void testCreditWithCommasConstructor() {
    DataSetSolution ds;
    try {
      ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    } catch (Exception e) {
      fail("Should not have thrown an exception!");
    }
  }

  @Test
  public void testWeatherDimensions() throws Exception {
    DataSetSolution ds = new DataSetSolution(WEATHERNOMINAL);
    assertEquals(5, ds.getNumberOfAttributes());
    assertEquals(14, ds.getNumberOfDatapoints());

  }


  @Test
  public void testCreditWithoutCommasDimensions() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);
    assertEquals(21, ds.getNumberOfAttributes());
    assertEquals(1000, ds.getNumberOfDatapoints());

  }

  @Test
  public void testCreditWithCommasDimensions() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    assertEquals(21, ds.getNumberOfAttributes());
    assertEquals(1000, ds.getNumberOfDatapoints());
  }

  @Test
  public void testWeatherSpotChecks() throws Exception {
    DataSetSolution ds = new DataSetSolution(WEATHERNOMINAL);

    String attr1 = ds.getAttributeName(0);
    String attr2 = ds.getAttributeName(3);
    String attr3 = ds.getAttributeName(5);

    assertEquals("outlook", attr1);
    assertEquals("windy", attr2);
    assertNull(attr3);

    String val1 = ds.getAttributeValue(4, 1);
    String val2 = ds.getAttributeValue(13, 2);
    String val3 = ds.getAttributeValue(14, 1);

    assertEquals("cool", val1);
    assertEquals("high", val2);
    assertNull(val3);

  }

  @Test
  public void testCreditWithoutCommasSpotChecks() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);

    String attr1 = ds.getAttributeName(8);
    String attr2 = ds.getAttributeName(15);
    String attr3 = ds.getAttributeName(21);

    assertEquals("personal_status", attr1);
    assertEquals("existing_credits", attr2);
    assertNull(attr3);

    String val1 = ds.getAttributeValue(400, 12);
    String val2 = ds.getAttributeValue(500, 4);
    String val3 = ds.getAttributeValue(100, 21);

    assertEquals("39", val1);
    assertEquals("3123", val2);
    assertNull(val3);

  }

  @Test
  public void testCreditWithCommasSpotChecks() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);

    String attr1 = ds.getAttributeName(8);
    String attr2 = ds.getAttributeName(15);
    String attr3 = ds.getAttributeName(21);

    assertEquals("gender, status", attr1);
    assertEquals("existing_credits", attr2);
    assertNull(attr3);

    String val1 = ds.getAttributeValue(400, 12);
    String val2 = ds.getAttributeValue(500, 4);
    String val3 = ds.getAttributeValue(100, 21);

    assertEquals("39", val1);
    assertEquals("3123", val2);
    assertNull(val3);
  }

  @Test
  public void testWeatherUniqueValues1() throws Exception {
    DataSetSolution ds = new DataSetSolution(WEATHERNOMINAL);
    String[] array = ds.getUniqueAttributeValues("outlook");
    assertEquals(3, array.length);
  }

  @Test
  public void testWeatherUniqueValues2() throws Exception {
    DataSetSolution ds = new DataSetSolution(WEATHERNOMINAL);
    String[] array = ds.getUniqueAttributeValues("humidity");
    assertEquals(2, array.length);
  }

  @Test
  public void testWeatherUniqueValues3() throws Exception {
    DataSetSolution ds = new DataSetSolution(WEATHERNOMINAL);
    String[] array = ds.getUniqueAttributeValues("temperature");
    assertEquals(3, array.length);
  }


  @Test
  public void testCreditWithoutCommasUniqueValues1() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);
    String[] array = ds.getUniqueAttributeValues("personal_status");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues2() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);
    String[] array = ds.getUniqueAttributeValues("credit_history");
    assertEquals(5, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues3() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);
    String[] array = ds.getUniqueAttributeValues("job");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues4() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);
    String[] array = ds.getUniqueAttributeValues("age");
    assertEquals(53, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues5() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFO);
    String[] array = ds.getUniqueAttributeValues("credit_amount");
    assertEquals(921, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues1() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    String[] array = ds.getUniqueAttributeValues("gender, status");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues2() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    String[] array = ds.getUniqueAttributeValues("credit_history");
    assertEquals(5, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues3() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    String[] array = ds.getUniqueAttributeValues("job");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues4() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    String[] array = ds.getUniqueAttributeValues("age");
    assertEquals(53, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues5() throws Exception {
    DataSetSolution ds = new DataSetSolution(CREDITINFOWITHCOMMAS);
    String[] array = ds.getUniqueAttributeValues("credit_amount");
    assertEquals(921, array.length);
  }

  @Test
  public void testLarge() throws Exception {
    DataSetSolution ds = new DataSetSolution(LARGE);
    String[] array = ds.getUniqueAttributeValues("credit_amount");
    assertEquals(921, array.length);

    array = ds.getUniqueAttributeValues("job");
    assertEquals(4, array.length);

    array = ds.getUniqueAttributeValues("credit_history");
    assertEquals(5, array.length);
  }

  @Test
  public void testMissingValues() throws Exception {
    DataSetSolution ds = new DataSetSolution(MISSINGVALUES);
    String[] array = ds.getUniqueAttributeValues("outlook");
    assertEquals(4, array.length);
    array = ds.getUniqueAttributeValues("temperature");
    assertEquals(12, array.length);
    array = ds.getUniqueAttributeValues("humidity");
    assertEquals(10, array.length);
    array = ds.getUniqueAttributeValues("windy");
    assertEquals(3, array.length);
    array = ds.getUniqueAttributeValues("play");
    assertEquals(3, array.length);
  }

  @Test
  public void testwithSpaces() throws Exception {
    DataSetSolution ds = new DataSetSolution(WEATHERWITHSPACES);
    String[] array = ds.getUniqueAttributeValues("outlook");
    assertEquals(3, array.length);
    array = ds.getUniqueAttributeValues("temperature");
    assertEquals(12, array.length);
    array = ds.getUniqueAttributeValues("humidity");
    assertEquals(10, array.length);
    array = ds.getUniqueAttributeValues("windy");
    assertEquals(2, array.length);
    array = ds.getUniqueAttributeValues("play");
    assertEquals(2, array.length);
  }

}
