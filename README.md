> MiniHaskell
MHS is a language that is
    * Functional
    * Has functions
    * Has state
    * Static typed
    * Object Oriented

TODO: Implements subtraction, multiplication and division.
-> Implements AND/OR

TODO: Implements support to function
-> Function application
Function Name(String), Arguments (List of strings, without a type), Evaluation of Expression (Body: Expression)
Class function declation (DO NOT EXTENDS Expression)

-> Application of Function (extends expression)
Function Name(String), CurrentNames: List[Expression] 

Create New Env that associates id to function declaration

-> If/Then/Else is an expression
CANNOT HAVE IF WITHOUT ANY OTHER COMPONENT

If implements recursion, it becomes turing complete


Geradores de Parser => Bison, BNFC, ANTLR
LEMBRAR DO PADRAO DE PROJETO INTERPRETER
-> AST: Abstract Syntax Tree
Garante modularidade, mas é comprometida qunado são incluídas novas operações na árvore

PADRAO DE PROJETO VISITON
Nova árvore com novas operações, no entanto fica mais dificil de incluir elementos sintáticos

Aplicação de função preciso associar cada um dos argumentos formais aos argumentos atuais 
Inc x = x + 1
Inc 4 (valor de x associado a 4)

Implementar parser
Correção para usar escopo estático (Construção de uma pilha)
QUANTO MAIS EXEMPLOS MELHOR

Primeira semana de Julho (Minihaskell e imdb)
