package test;

public class ComplexNumber {
  private double a;
  private double b;

  public ComplexNumber(double inA, double inB) {
    a = inA;
    b = inB;
  }

  public String toString() {
    return a + " + " + b + "i";
  }
}
