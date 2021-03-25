import java.util.Arrays;

public class BagOfReals {
  private final double[] values;

  public BagOfReals(double... values) {
    this.values = values;
    Arrays.sort(this.values);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    BagOfReals otherBag = (BagOfReals) obj;
    if (this.values.length != otherBag.values.length) {
      return false;
    }
    return Arrays.equals(this.values, otherBag.values);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("{ ");

    int frequency = 1;
    double lastValue = values[0];
    for (int i = 1; i < values.length; i++) {
      if (values[i] != lastValue) {
        builder.append(String.format("%s (%d) %s", lastValue, frequency, ", "));
        frequency = 1;
        lastValue = values[i];
      } else {
        frequency++;
      }
    }
    builder.append(String.format("%s (%d) }", values[values.length - 1], frequency));
    return builder.toString();
  }
}