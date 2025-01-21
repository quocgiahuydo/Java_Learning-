
@FunctionalInterface
interface FizzBuzzFunc {
    boolean evaluate(int num);
}

public class FizzBuzz {

    public static String fizzBuzz(FizzBuzzFunc func1, FizzBuzzFunc func2, int num) {
        boolean fizz = func1.evaluate(num);  // Evaluate with the first function (Fizz condition)
        boolean buzz = func2.evaluate(num);  // Evaluate with the second function (Buzz condition)
        
        // Check the conditions based on the results of the evaluations
        if (fizz && buzz) {
            return "FizzBuzz";  // Both conditions are true
        } else if (fizz) {
            return "Fizz";  // Only the first condition is true
        } else if (buzz) {
            return "Buzz";  // Only the second condition is true
        } else {
            return "";  // Neither condition is true
        }
    }

    public static void main(String[] args) {
        // Example usage
        FizzBuzzFunc fizzFunc = (num) -> num % 3 == 0;  // Check if divisible by 3
        FizzBuzzFunc buzzFunc = (num) -> num % 5 == 0;  // Check if divisible by 5
        
        // Test the fizzBuzz method
        for (int i = 1; i <= 100; i++) {
            String result = fizzBuzz(fizzFunc, buzzFunc, i);
            if (!result.isEmpty()) {
                System.out.println(result);  // Print Fizz, Buzz, or FizzBuzz
            } else {
                System.out.println(i);  // Print the number if it's not divisible by 3 or 5
            }
        }
    }
}
