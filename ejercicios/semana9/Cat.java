public class Cat implements Printable {
    public String name;
    public int age;

    public Cat() {
        this.name = null;
        this.age = 0;
    }
 
    public String name (){
        return name != null ? name : "a uknown cat";
    }

    public int age() {
        return age > 0 ? age : 1;
    }

    public void print() {
        System.out.println("Cat: " + name + ", age: " + age);
    }
}
