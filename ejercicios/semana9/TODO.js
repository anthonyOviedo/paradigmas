
class Person {constructor(name,age){this.name = name; this.age = age}}

a = new Person("tony",18)
console.log(a)

const app = (f,x) => f(x)
app(x=>x-1,10)

const comp = (f,g) => x => g(f(x))

const square = x => x**x
const split = x => x/2

var r = comp(square,split)
console.log("suqare:3*3 => split:3/2 = " + r(3))
var q = comp(split,square)
console.log(q(3))   

function sum(a) { 
    let s = 0;
    for (let i=1; i<=a; i++) 
        s += i;
    return s;
}

console.log("sum 1 to 3 = " + sum(3));

function sum2(a) {
    let s = 0;
    for (let e of a){
        s += e;
    }
    return s;
}

console.log("sum2 1 to 3 = " + sum2([1,2,3]));