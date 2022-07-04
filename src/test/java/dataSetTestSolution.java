import aone.DataSetSolution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class dataSetTestSolution {

  @Test
  public void testWeatherConstructor() {
    DataSetSolution ds;
    try {
      ds = new DataSetSolution("weather-nominal.csv");
    } catch (Exception e) {
      fail("Should not have thrown any exception!");
    }
  }

  @Test
  public void testCreditWithoutCommasConstructor() {
    DataSetSolution ds;
    try {
      ds = new DataSetSolution("credit-info.csv");
    } catch (Exception e) {
      fail("Should not have thrown an exception!");
    }
  }

  @Test
  public void testCreditWithCommasConstructor() {
    DataSetSolution ds;
    try {
      ds = new DataSetSolution("credit-info-with-commas.csv");
    } catch (Exception e) {
      fail("Should not have thrown an exception!");
    }
  }

  @Test
  public void testWeatherDimensions() throws Exception {
    DataSetSolution ds = new DataSetSolution("weather-nominal.csv");
    assertEquals(5, ds.getNumberOfAttributes());
    assertEquals(14, ds.getNumberOfDatapoints());

  }


  @Test
  public void testCreditWithoutCommasDimensions() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");
    assertEquals(21, ds.getNumberOfAttributes());
    assertEquals(1000, ds.getNumberOfDatapoints());

  }

  @Test
  public void testCreditWithCommasDimensions() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");
    assertEquals(21, ds.getNumberOfAttributes());
    assertEquals(1000, ds.getNumberOfDatapoints());
  }

  @Test
  public void testWeatherSpotChecks() throws Exception {
    DataSetSolution ds = new DataSetSolution("weather-nominal.csv");

    String attr1 = ds.getAttributeName(0);
    String attr2 = ds.getAttributeName(3);
    String attr3 = ds.getAttributeName(5);

    assertEquals("outlook", attr1);
    assertEquals("windy", attr2);
    assertEquals(null, attr3);

    String val1 = ds.getAttributeValue(4, 1);
    String val2 = ds.getAttributeValue(13, 2);
    String val3 = ds.getAttributeValue(14, 1);

    assertEquals("cool", val1);
    assertEquals("high", val2);
    assertEquals(null, val3);

  }

  @Test
  public void testCreditWithoutCommasSpotChecks() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");

    String attr1 = ds.getAttributeName(8);
    String attr2 = ds.getAttributeName(15);
    String attr3 = ds.getAttributeName(21);

    assertEquals("personal_status", attr1);
    assertEquals("existing_credits", attr2);
    assertEquals(null, attr3);

    String val1 = ds.getAttributeValue(400, 12);
    String val2 = ds.getAttributeValue(500, 4);
    String val3 = ds.getAttributeValue(100, 21);

    assertEquals("39", val1);
    assertEquals("3123", val2);
    assertEquals(null, val3);

  }

  @Test
  public void testCreditWithCommasSpotChecks() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");

    String attr1 = ds.getAttributeName(8);
    String attr2 = ds.getAttributeName(15);
    String attr3 = ds.getAttributeName(21);

    assertEquals("gender, status", attr1);
    assertEquals("existing_credits", attr2);
    assertEquals(null, attr3);

    String val1 = ds.getAttributeValue(400, 12);
    String val2 = ds.getAttributeValue(500, 4);
    String val3 = ds.getAttributeValue(100, 21);

    assertEquals("39", val1);
    assertEquals("3123", val2);
    assertEquals(null, val3);
  }

  @Test
  public void testWeatherUniqueValues1() throws Exception {
    DataSetSolution ds = new DataSetSolution("weather-nominal.csv");
    String[] array = ds.getUniqueAttributeValues("outlook");
    assertEquals(3, array.length);
  }

  @Test
  public void testWeatherUniqueValues2() throws Exception {
    DataSetSolution ds = new DataSetSolution("weather-nominal.csv");
    String[] array = ds.getUniqueAttributeValues("humidity");
    assertEquals(2, array.length);
  }

  @Test
  public void testWeatherUniqueValues3() throws Exception {
    DataSetSolution ds = new DataSetSolution("weather-nominal.csv");
    String[] array = ds.getUniqueAttributeValues("temperature");
    assertEquals(3, array.length);
  }


  @Test
  public void testCreditWithoutCommasUniqueValues1() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");
    String[] array = ds.getUniqueAttributeValues("personal_status");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues2() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");
    String[] array = ds.getUniqueAttributeValues("credit_history");
    assertEquals(5, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues3() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");
    String[] array = ds.getUniqueAttributeValues("job");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues4() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");
    String[] array = ds.getUniqueAttributeValues("age");
    assertEquals(53, array.length);
  }

  @Test
  public void testCreditWithoutCommasUniqueValues5() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info.csv");
    String[] array = ds.getUniqueAttributeValues("credit_amount");
    assertEquals(921, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues1() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");
    String[] array = ds.getUniqueAttributeValues("gender, status");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues2() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");
    String[] array = ds.getUniqueAttributeValues("credit_history");
    assertEquals(5, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues3() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");
    String[] array = ds.getUniqueAttributeValues("job");
    assertEquals(4, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues4() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");
    String[] array = ds.getUniqueAttributeValues("age");
    assertEquals(53, array.length);
  }

  @Test
  public void testCreditWithCommasUniqueValues5() throws Exception {
    DataSetSolution ds = new DataSetSolution("credit-info-with-commas.csv");
    String[] array = ds.getUniqueAttributeValues("credit_amount");
    assertEquals(921, array.length);
  }

  @Test
  public void testLarge() throws Exception {
    DataSetSolution ds = new DataSetSolution("large.csv");
    String[] array = ds.getUniqueAttributeValues("credit_amount");
    assertEquals(921, array.length);

    array = ds.getUniqueAttributeValues("job");
    assertEquals(4, array.length);

    array = ds.getUniqueAttributeValues("credit_history");
    assertEquals(5, array.length);
  }

  @Test
  public void testMissingValues() throws Exception {
    DataSetSolution ds = new DataSetSolution("missing-values.csv");
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
    DataSetSolution ds = new DataSetSolution("weather-with-spaces.csv");
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
