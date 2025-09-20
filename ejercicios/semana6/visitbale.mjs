export class Visitable {
    accept(visitor){
        return visitor.visit(this,...args)       
    }
}