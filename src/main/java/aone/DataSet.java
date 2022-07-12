package aone;

import java.io.File;
import java.util.*;

/**
 * The class enables loading a dataset from a file (CSV format) and deriving
 * some important characteristics of the data
 */
public class DataSet {

  public static final String CREDITINFO = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\credit-info.csv";
  public static final String CREDITINFOWITHCOMMAS = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\credit-info-with-commas.csv";
  public static final String LARGE = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\large.csv";
  public static final String MISSINGVALUES = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\missing-values.csv";
  public static final String WEATHERNOMINAL = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-nominal.csv";
  public static final String WEATHERNUMERIC = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-numeric.csv";
  public static final String WEATHERWITHSPACES = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-with-spaces.csv";

  /**
   * The delimiter that separates attribute names and attribute values
   */
  private static final char DELIMITER = ',';

  /**
   * Character allowing escape sequences containing the delimiter
   */
  private static final char QUOTE_MARK = '\'';

  /**
   * Instance variable for storing the number of attributes (columns)
   */
  private int numColumns;

  /**
   * Instance variable for storing the number of datapoints (data rows)
   */
  private int numRows;

  /**
   * Instance variable for storing attribute names
   */
  private String[] attributeNames;

  private String[][] matrix;
  /**
   * Constructs a dataset by loading a CSV file
   *
   * @param strFilename is the name of the file
   */
  public DataSet(String strFilename) throws Exception {

    // WRITE YOUR CODE HERE!
    calculateDimensions(strFilename);
    this.attributeNames = new String[numColumns];
    this.matrix = new String[numRows][numColumns];
    instantiateFromFile(strFilename);

  }

  /**
   * Returns the name of the attribute at a given column index
   *
   * @param column is the column index
   * @return attribute name at index (null if the index is out of range)
   */
  public String getAttributeName(int column) {

    if (column < 0 || column >= numColumns)
      return null;


    return this.attributeNames[column];
  }

  /**
   * Returns the value of a given column for a given row (datapoint)
   *
   * @param row    is the row (datapoint) index
   * @param column is the column index
   * @return the value of the attribute at column for the datapoint at row (null
   *         if either row or column are out of range)
   */
  public String getAttributeValue(int row, int column) {
    if (row < 0 || row >= getNumberOfDatapoints())
      return null;

    if (column < 0 || column >= getNumberOfAttributes())
      return null;

    return matrix[row][column];
  }

  /**
   * Returns the number of attributes
   *
   * @return number of attributes
   */
  public int getNumberOfAttributes() {
    return numColumns;
  }

  /**
   * Returns the number of datapoints
   *
   * @return number of datapoints
   */
  public int getNumberOfDatapoints() {
    return numRows;
  }

  /**
   * Returns a reference to an array containing the unique values that an
   * attribute can assume in the dataset
   *
   * @param attributeName is the name of the attribute whose unique values must be
   *                      returned
   * @return String[] reference to the unique values of the attribute with the
   *         given name
   */
  public String[] getUniqueAttributeValues(String attributeName) {

    // WRITE YOUR CODE HERE!

    // Hint: You can first implement getUniqueAttributeValues(int column), below,
    // and then make use of that private method here!

    // Remove the following null return after you implement this method and
    // return an appropriate array reference instead

    if (attributeName == null) {
      return null;
    }

    for (int i = 0; i < attributeNames.length; i++) {
      if (attributeName.equals(attributeNames[i])) {
        return getUniqueAttributeValues(i);
      }
    }
    return null;

  }

  /**
   * Returns a reference to an array containing the unique values that the
   * attribute at a certain column can assume in the dataset
   *
   * @param column is the index (staring from zero) for the attribute whose unique
   *               values must be returned
   * @return String[] reference to the unique values of the attribute at the given
   *         column
   */
  private String[] getUniqueAttributeValues(int column) {

    // WRITE YOUR CODE HERE!

    // Remove the following null return after you implement this method and
    // return an appropriate array reference instead
    Set<String> set = new HashSet<>();
    for (String[] strings : this.matrix) {
      set.add(strings[column]);
    }

    return set.toArray(String[]::new);

  }

  /**
   * Returns in form of an explanatory string some important characteristics
   * of the dataset. These characteristics are: the number of attributes, the
   * number of datapoints and the unique values that each attribute can assume
   *
   * @return String containing the characteristics (metadata)
   */
  public String metadataToString() {

    // Hint: You can combine multiple lines by appending
    // a (platform-dependent) separator to the end of each line.
    // To obtain the (platform-dependent) separator, you can use
    // the following command.
    StringBuilder buffer = new StringBuilder();
    String separator = System.getProperty("line.separator");

    // WRITE YOUR CODE HERE!

    // Hint: You need to call getUniqueAttributeValues() for
    // each attribute (via either attribute name or attribute column) and
    // then concatenate the string representations of the arrays returned by
    // getUniqueAttributeValues(). To get the string representations for
    // these arrays, you can use the methods provided in the Util class.
    // For nominal attributes use: Util.nominalArrayToString()
    // For numeric attributes use: Util.numericArrayToString()

    // Remove the following null return after you implement this method
    buffer.append("Number of attributes: ").append(numColumns).append(separator);
    buffer.append("Number of datapoints: ").append(numRows).append(separator).append(separator);
    buffer.append("* * * Attribute value sets * * *").append(separator);

    for (int i = 0; i < attributeNames.length; i++) {
      buffer.append(i).append(1).append(") ").append(attributeNames[i]);
      String[] values = getUniqueAttributeValues(i);
      if (Util.isArrayNumeric(values)) {
        buffer.append(" (numeric): ");
        buffer.append(Util.numericArrayToString(values));
        buffer.append(separator);
      } else {
        buffer.append(" (nominal): ");
        buffer.append(Util.nominalArrayToString(values));
        buffer.append(separator);
      }
    }

    return buffer.toString();
  }

  /**
   * <b>main</b> of the application. The method first reads from the standard
   * input the name of the CSV file to process. Next, it creates an instance of
   * DataSet. Finally, it prints to the standard output the metadata of the
   * instance of the DataSet just created.
   *
   * @param args command lines parameters (not used in the body of the method)
   */
//  public static void main(String[] args) throws Exception {
//    DataSet dataset2 = new DataSet(WEATHERNUMERIC);
//  }

  /**
   * This method should set the numColumns and numRows instance variables
   * The method is incomplete; you need to complete it.
   * @param strFilename is the name of the dataset file
   */
  private void calculateDimensions(String strFilename) throws Exception {

    Scanner scanner = new Scanner(new File(strFilename));

    boolean firstLine = true;

    while (scanner.hasNext()) {
      String str = scanner.nextLine();

      if (!str.trim().isEmpty()) {
        if (firstLine) {
          numColumns = countColumns(str);
          firstLine = false;
        } else {
          numRows++;
        }
      }
    }

    scanner.close();
  }
  /**
   * This method should load the attribute names into the attributeNames[]
   * instance variable and load the datapoints into the matrix instance variable.
   * The method is incomplete; you need to complete it.
   * @param strFilename is the name of the file to read
   */
  private void instantiateFromFile(String strFilename) throws Exception {
    Scanner scanner = new Scanner(new File(strFilename));

    boolean firstLine = true;

    int rowNum = 0;

    while (scanner.hasNext()) {
      String str = scanner.nextLine();

      if (!str.trim().isEmpty()) {

        if (firstLine) {
          firstLine = false;
          populateAttributeNames(str);

        } else {
          populateRow(str, rowNum++);
        }
      }
    }
    scanner.close();
  }

  private void populateRow(String str, int currentRow) {

    if (str == null || str.isEmpty()) {
      return;
    }

    StringBuffer buffer = new StringBuffer();

    boolean isInQuote = false;

    int position = 0;

    char[] chars = str.toCharArray();
    char ch;

    for (char aChar : chars) {

      ch = aChar;

      if (isInQuote) {
        if (ch == QUOTE_MARK) {
          isInQuote = false;
        } else {
          buffer.append(ch);
        }

      } else if (ch == QUOTE_MARK) {
        isInQuote = true;
      } else if (ch == DELIMITER) {
        matrix[currentRow][position++] = buffer.toString().trim();
        buffer.delete(0, buffer.length());
      } else {
        buffer.append(ch);
      }
    }

    if (buffer.toString().trim().length() > 0) { // deal with last attribute value
      matrix[currentRow][position++] = buffer.toString().trim();
    } else if (chars[chars.length - 1] == ',') {// deal with potentially missing last attribute value
      matrix[currentRow][position++] = "";
    }
  }

  private static int countColumns(String str) {

    int count = 0;

    if (str == null || str.isEmpty()) {
      return count;
    }

    char[] chars = str.toCharArray();
    boolean isInQuote = false;
    char ch;

    for (char aChar : chars) {
      ch = aChar;

      if (isInQuote) {
        if (ch == QUOTE_MARK) {
          isInQuote = false;
        }
      } else if (ch == QUOTE_MARK) {
        isInQuote = true;
      } else if (ch == DELIMITER) {
        count++;
      }
    }

    return count + 1;
  }
  private void populateAttributeNames(String str) {

    if (str == null || str.isEmpty()) {
      return;
    }

    StringBuilder buffer = new StringBuilder();

    boolean isInQuote = false;

    int position = 0;

    char[] chars = str.toCharArray();
    char ch;

    for (char aChar : chars) {

      ch = aChar;

      if (isInQuote) {
        if (ch == QUOTE_MARK) {
          isInQuote = false;
        } else {
          buffer.append(ch);
        }

      } else if (ch == QUOTE_MARK) {
        isInQuote = true;
      } else if (ch == DELIMITER) {
        attributeNames[position++] = buffer.toString().trim();
        buffer.delete(0, buffer.length());
      } else {
        buffer.append(ch);
      }
    }

    if (buffer.toString().trim().length() > 0) { // deal with last attribute name
      attributeNames[position++] = buffer.toString().trim();
    }
  }

}