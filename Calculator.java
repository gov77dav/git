public class Calculator {
    public static double calculator(double number1, char operator, double number2) {
        double answer = 0;
        
        try 
        {
        	switch (operator) 
        	{
            case '+':
                answer = number1 + number2;
                break;
            case '-':
                answer = number1 - number2;
                break;
            case '*':
                answer = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    answer = number1 / number2;
                } else {
                    answer = 0; 
                }
                break;
            default:
                System.out.println("Please enter a valid operator");
        	}
        }
        
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        return answer;
    }

    public static void main(String[] args) {
        
        System.out.println(calculator(2, '+', 2)); 
        System.out.println(calculator(2, '*', 2)); 
        System.out.println(calculator(4, '/', 2)); 
        System.out.println(calculator(5, '/', 0));
    }
}
