import {Num, Operation, Id ,Operator,BinaryOperation, UnaryOperation} from './ast.mjs'
function main (){
    console.log("test0: "+test_0())
    console.log("test1: "+test_1())
    console.log("test2: "+test_2())
    console.log("test3: "+test_3())

}
function test_0(){
    const n = new Num(666)
    console.log(n.value)
}
function test_1(){
    const plus = new Operator("+")
    const add = new Operation(plus, new Num(333), new Num(666), new Num(999))
    console.log(add.toString())
}


function test_2(){
    const ab= new Id("a")
    const abb = new Id("a")

    const add2 = new BinaryOperation (new Operator("=="),ab, abb)
    console.log(add2.toString())
}

function test_3(){
    const b = new Num(3)
    const c = new Num(4)

    const x = new Operator("+")
    

    const suma = new BinaryOperation (x,c,b)
    

    console.log(suma.toString())
}

main()