package jmh;
import aone.DataSet;
import aone.DataSetSolution;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class UAttributeValues {

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @Warmup(iterations = 1)
  @Fork(value = 2, warmups = 1)
//  @Measurement(iterations = 2)
  public String[] ourImplementationWeatherNominal() throws Exception {
    DataSet dataSet = new DataSet(DataSet.WEATHERNOMINAL);
    String[] uniqueAtributes = dataSet.getUniqueAttributeValues("outlook");

    return uniqueAtributes;
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @Warmup(iterations = 1)
  @Fork(value = 2, warmups = 1)
  public String[] solutionImplementationWeatherNominal() throws Exception {
    DataSetSolution dataSetSolution = new DataSetSolution(DataSetSolution.WEATHERNOMINAL);
    String[] uniqueAtributes = dataSetSolution.getUniqueAttributeValues("outlook");

    return uniqueAtributes;
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @Warmup(iterations = 1)
  @Fork(value = 2, warmups = 1)
  public String[] ourImplementationLarge() throws Exception {
    DataSet dataSet = new DataSet(DataSet.LARGE);
    String[] uniqueAtributes = dataSet.getUniqueAttributeValues("other_parties");

    return uniqueAtributes;
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @Warmup(iterations = 1)
  @Fork(value = 2, warmups = 1)
  public String[] solutionImplementationLarge() throws Exception {
    DataSetSolution dataSetSolution = new DataSetSolution(DataSetSolution.LARGE);
    String[] uniqueAtributes = dataSetSolution.getUniqueAttributeValues("other_parties");

    return uniqueAtributes;
  }
}
