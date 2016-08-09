package packt;

public class Chapter6Examples {

    public static void main(String[] args) {
        Employee employee = new Employee();
//        System.out.println(employee.dob);
        System.out.println(largest(12, -12, 45, 4, 345, 23, 49));
        System.out.println(largest(-43, -12, -705, -48, -3));

	OverloadingDemo demo = new OverloadingDemo();
	int num = demo.max(45, 98, 2);
//	num  = demo.max(45L, 98L, 2L);		// assignment issue
	float result = demo.max(45L, 98L, 2L);
//	num = demo.max(45, 98, 2L);       // assignment issue
	result = demo.max(45, 98, 2L);
	result = demo.max(45.0f, 0.056f);
//	result = demo.max(45.0, 0.056f);  // Overload problem
    }   
    
    private static int largest(int... numbers) {
        int currentLargest = numbers[0];
        for (int number : numbers) {
            if (number > currentLargest) {
                currentLargest = number;
            }
        }
        return currentLargest;
    }
}
