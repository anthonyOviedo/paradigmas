
import ExprVisitor from '../generated/ExprVisitor.js'
import { Program, Num , BinaryOp, UnaryOp, PASS } from './ast/ast.mjs'

export default class AstBuilder extends ExprVisitor {
  
  // prog: stat* EOF
  visitProg(ctx) {
    const stmts = ctx.stat().map(stat => this.visit(stat))
    return new Program(...stmts.filter(x => x !== null))
  }

  // printExpr: expr NEWLINE
  visitPrintExpr(ctx) {
    return this.visit(ctx.expr()); 
  }

  // blank: NEWLINE
  visitBlank() {
    return PASS
  }

  // unaryMinus: '-' expr
  visitUnaryMinus(ctx) {
    return new UnaryOp('-', this.visit(ctx.expr()))
  }

  // MulDiv: expr op=('*'|'/') expr
  visitMulDiv(ctx) {
    const left = this.visit(ctx.expr(0))
    const right = this.visit(ctx.expr(1))
    return new BinaryOp(ctx.op.text, left, right)
  }

  // AddSub: expr op=('+'|'-') expr
  visitAddSub(ctx) {
    const left = this.visit(ctx.expr(0))
    const right = this.visit(ctx.expr(1))
    return new BinaryOp(ctx.op.text, left, right)
  }

  // int: INT
  visitInt(ctx) {
    return new Num(Number(ctx.getText()))
  }

  // parens: '(' expr ')'
  visitParens(ctx) {
    return this.visit(ctx.expr())
  }
}
