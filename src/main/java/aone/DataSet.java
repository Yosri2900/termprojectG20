package aone;

import java.io.File;
import java.util.Scanner;

/**
 * The class enables loading a dataset from a file (CSV format) and deriving
 * some important characteristics of the data
 */
public class DataSet {

  private final String CREDITINFO = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\credit-info.csv";
  private final String CREDITINFOWITHCOMMAS = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\credit-info-with-commas.csv";
  private final String LARGE = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\large.csv";
  private final String MISSINGVALUES = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\missing-values.csv";
  private final String WEATHERNOMINAL = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-nominal.csv";
  private final String WEATHERNUMERIC = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-numeric.csv";
  private final String WEATHERWITHSPACES = "C:\\Users\\yosri\\Desktop\\seg3103\\term_project\\decisiontree\\src\\main\\java\\aone\\weather-with-spaces.csv";


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

  /**
   * Instance variable for storing datapoints
   */
  private String[][] matrix;

  /**
   * Constructs a dataset by loading a CSV file
   *
   * @param strFilename is the name of the file
   */
  public DataSet(String strFilename) throws Exception {

    // WRITE YOUR CODE HERE!
    calculateDimensions(strFilename);

    attributeNames = new String[numColumns];

    matrix = new String[numRows][numColumns];

    instantiateFromFile(strFilename);

  }

  /**
   * Returns the name of the attribute at a given column index
   *
   * @param column is the column index
   * @return attribute name at index (null if the index is out of range)
   */
  public String getAttributeName(int column) {
    // WRITE YOUR CODE HERE!
    // Note: Remember to handle out-of-range values!

    // Remove the following null return after you implement this method
    return null;
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
    // WRITE YOUR CODE HERE!
    // Note: Remember to handle out-of-range values!

    // Remove the following null return after you implement this method
    return null;

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
    return null;
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
    return null;
  }

  /**
   * <b>main</b> of the application. The method first reads from the standard
   * input the name of the CSV file to process. Next, it creates an instance of
   * DataSet. Finally, it prints to the standard output the metadata of the
   * instance of the DataSet just created.
   *
   * @param args command lines parameters (not used in the body of the method)
   */
  public static void main(String[] args) throws Exception {

    System.out.print("Please enter the name of the CSV file to read: ");

    Scanner scanner = new Scanner(System.in);

    String strFilename = scanner.nextLine();

    DataSet dataset = new DataSet(strFilename);

    System.out.print(dataset.metadataToString());

  }

  private void calculateDimensions(String strFilename) throws Exception {

    Scanner scanner = new Scanner(new File(strFilename));

    while (scanner.hasNext()) {
      String str = scanner.nextLine();
    }

    scanner.close();

  }

  private void instantiateFromFile(String strFilename) throws Exception {
    Scanner scanner = new Scanner(new File(strFilename));

    while (scanner.hasNext()) {
      String str = scanner.nextLine();

    }

    scanner.close();
  }

}