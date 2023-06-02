package lambda;

public class LambdaEx3 {

	public static void main(String[] args) {
		// Lambda2 인터페이스를 사용하고 싶다면?
		// 1) 구현 클래스 작성 - ex) 클래스명 implements Lambda2 
		// 2) 익명 구현 클래스 작성
//		Lambda2 lambda = new Lambda2() {			
//			@Override
//			public void method() {
//				System.out.println("익명 구현 클래스");				
//			}
//		};
//		lambda.method();
		
		// 이걸 함수식으로 바꾸면
		Lambda3 lambda = (x) -> System.out.println("익명 구현 클래스");
		lambda.method(100);
		
		
		lambda = (x) -> {
			int i = 10;
			System.out.println(i * x);			
		};
		lambda.method(100);
		

	}

}
