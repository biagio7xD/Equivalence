import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n\nWrite two comma-separated lists of real numbers\n");
    System.out.println("Write the first list of real numbers: \t(number1,number2,...,numberN)");
    String firstList = scanner.nextLine();
    System.out.println("Write the second list of real numbers: \tnumber1,number2,...,numberN");
    String secondList = scanner.nextLine();
    scanner.close();
    double[] firstParsedMultisetOfDoubles = determineDoubleMultiset(firstList);
    double[] secondParsedMultisetOfDoubles = determineDoubleMultiset(secondList);
    BagOfReals firstBagOfReals = new BagOfReals(firstParsedMultisetOfDoubles);
    BagOfReals secondBagOfReals = new BagOfReals(secondParsedMultisetOfDoubles);
    System.out.println(
        String.format("The two multisets {value (occurrence)}:\n1. %s\n2. %s", firstBagOfReals, secondBagOfReals));
    System.out.println(firstBagOfReals.equals(secondBagOfReals) ? "Are equivalent" : "Are not equivalent");
  }

  private static double[] determineDoubleMultiset(String listOfReals) {
    if (listOfReals.isEmpty()) {
      double[] listOfDoubles = new double[0];
      return listOfDoubles;
    } else {
      String[] items = listOfReals.trim().split(",");
      int numberOfItems = items.length;
      double[] listOfDoubles = new double[numberOfItems];
      for (int i = 0; i < numberOfItems; i++) {
        listOfDoubles[i] = Double.parseDouble(items[i]);
      }
      return listOfDoubles;
    }
  }
}
