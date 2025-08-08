package semana3;

class Ejercicios2 {
    private int x = 666;

    public static class B {
        private int x = 999;
        public void foo() {
            System.out.println(x);  
        }
    }

    public static void main(String[] args) {
        B b = new B();   
        b.foo();
    }
}
