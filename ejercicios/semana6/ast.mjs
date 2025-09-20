// ES6 

import { Visitable } from "./visitbale.mjs";

export class Node extends Visitable {
    constructor(head, ...children){ // var args in c++
        this.head = head;
        this.children = children
    }
}
class AstPrintVisitor{
    visit(node){
        if (!node) return
        if (node instanceof Num){
            console.log(node.value)
            return 
        }
        if (node instanceof Id){
            console.log(node.name)
            return 
        }
        if (node instanceof UnaryOperation){
            console.log(node.operator.name )
            return 
        }
        if (node instanceof BinaryOperation){
            console.log(node.value)
            return 
        }
    }

}
export class Num extends Node {
    constructor(value){
        super(value)
    }
    get value(){
        return this.head
    }

    toString(){
        return `${this.value}`
    }

}

export class Id extends Node {
    constructor(name){
        super(name)
    }
    get value(){
        return this.head
    }
    
    toString(){
        return `${this.value}`
    }
}

export class Operator extends Id {
    constructor(op){
        super(op)
    }
    get value(){
        return this.head
    }
    
    toString(){
        return `${this.value}`
    }
}

export class Operation extends Node {   
    constructor(op, ... args){
        super(op, ... args)
    }
    
    get operator(){
        return this.head
    }
    get args(){ 
        return this.children
    }

    toString(){ 
        return [this.args.map(x => x.toString())]
                        .join(", ")
    }

}

export class UnaryOperation extends Operation{
    constructor(oper, ...expr){
        super(oper, ...expr)
    }
    toString(){
        return `${this.oper} ${this.args[1]}`
    }

}

export class BinaryOperation extends Operation {
    constructor(oper, l,r){
        super(oper, l,r)
    }

    get left(){
        return this.l
    }

    get right (){
        return this.r
    }

    toString(){
        return `(${this.oper}  ${this.l}  ${this.r})`
    }

}