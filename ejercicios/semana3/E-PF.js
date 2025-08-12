// Ejericio programacion funcional Antony Oviedo 8/8/25 



// 1) Escriba una función en JS choose(p, f, g) 
// que retorne una función de x que retorna f(x) si p(x) es verdadero y 
// retorna g(x) en caso contrario

const choose = (p, f, g) => x => p(x) ? f(x) : g(x)

var a = choose(x => x > 0, x => x**2, x => x + 1)(5) // retorna 25 // a mano
//            (x => x > 0, x => x**2, x => x + 1)
//.           (     p,          f,         g    ) => x => f(x) ? p(x) : g(x)
//.                                              f(x => x**2)  ?  p(x>0) : g(x+1)
//.                                                         x  ?  (5>0) : (5+1)
//.                                                         x => 5**2  ?  5>0 : 5+1
//.                                                         x => 5**2
//.                                                         25 => 5**2


var b = choose(x => x > 0, x => x**2, x => x + 1)(-5) 
console.log("choose: "+ choose)
console.log("A: "+ a )
console.log("B: "+ b )


// 2) Escriba id la función identidad: es decir, para cualquier x se cumple id(x) = x.
const id = x => x
console.log("ID: "+ id)
console.log("C: "+id("perro"))


// 3) Escriba una función repeat(n, f) que retorne una función de x que calcula f^n(x) = f(f(...f(x)...)) 
// donde f está aplicada n veces sobre x (este ejercicios es "peludillo")
// Ejemplos
// repeat(0, id)(666) // retorna 666
// repeat(5, x => 2 * x)(1) // retorna 32

const repeat = (n,f) => n === 0 ?  f : x=>repeat(n-1,f)(x) 

var d = repeat(5, x => 2 * x)(1) // retorna 32
console.log("REPEAT: "+ repeat)
console.log("D: "+d)


