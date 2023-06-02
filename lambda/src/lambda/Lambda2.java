package lambda;

// 람다식은 어디에 포함해서 쓸 것인가? 
// @FunctionalInterface : 필수 요소는 아니지만, 하나의 추상 메소드만 정의되도록 컴파일 단계에서 처리
// 메소드 여러개면 오류남 
@FunctionalInterface
public interface Lambda2 {
	public void method();
	// public void method2();
}
