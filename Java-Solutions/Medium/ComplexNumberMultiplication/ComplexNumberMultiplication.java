/*
A complex number can be represented as a string on the form "real+imaginaryi" where:
real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

Example 1:
Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Example 2:
Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
*/
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNumber result = ComplexNumber.buildComplexNumber(num1).multiply(ComplexNumber.buildComplexNumber(num2));
        return result.toString();
    }
  
    private static class ComplexNumber {
        private final int real;
        private final int imaginary;
    
        private ComplexNumber(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }
    
        public static ComplexNumber buildComplexNumber(String s) {
            int[] idx = {0};
            int realPart = parseRealPart(s, idx);
            int imaginaryPart = parseImaginaryPart(s, idx);
            return new ComplexNumber(realPart, imaginaryPart);
        }
    
        public ComplexNumber multiply(ComplexNumber anotherNumber) {
            int realPart = this.real * anotherNumber.real + (this.imaginary * anotherNumber.imaginary * -1);
            int imaginaryPart = this.real * anotherNumber.imaginary + this.imaginary * anotherNumber.real;
            return new ComplexNumber(realPart, imaginaryPart);
        }
        public String toString() {
            return this.real + "+" + this.imaginary + "i";
        }
    
        private static int parseRealPart(String s, int[] idx) {
            int realSign = 1;
            if (s.charAt(idx[0]) == '+' || s.charAt(idx[0]) == '-') {
                realSign = s.charAt(idx[0]) == '-' ? -1 : 1;
                idx[0]++;
            }
            int realNum = 0;
            while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
                realNum = realNum * 10 + Character.getNumericValue(s.charAt(idx[0]++));
            }
            realNum *= realSign;
            idx[0]++;
            return realNum;
        }
    
        private static int parseImaginaryPart(String s, int[] idx) {
            int imaginarySign = 1;
            if (idx[0] < s.length() && (s.charAt(idx[0]) == '+' || s.charAt(idx[0]) == '-')) {
                imaginarySign = s.charAt(idx[0]) == '-' ? -1 : 1;
                idx[0]++;
            } 
            int imaginaryNum = 0;
            while (idx[0] < s.length() && s.charAt(idx[0]) != 'i') {
                imaginaryNum = imaginaryNum * 10 + Character.getNumericValue(s.charAt(idx[0]++));
            }
        return imaginarySign * imaginaryNum;
        }
    }
}