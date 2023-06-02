package lambda;

public class LambdaEx4 {

	public static void main(String[] args) {
		
		Lambda4 lambda = (x, y) -> x > y ? x : y;
		System.out.println(lambda.max(150, 100));
		
		//
		Lambda5 lambdaN = (x, y) -> x < y ? x : y; 
		System.out.println(lambdaN.min(150, 70));
		

	}

}
