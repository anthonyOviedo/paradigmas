class A {
    private int x = 111;
    public class B {
        private int x = 777;
        public void foo() {
	        System.out.println(new A().x); // imprime la x de una nueva instancia de la clase A. 
            // System.out.println(x); //imprime la X local./
        }
    }
}
public class Test{
	public static void main(String... args){
		A outerA = new A();
		var b = outerA.new B();// Se necesita crear un b tal que
		b.foo();    // b.foo() imprima 111 no 777
	}
}