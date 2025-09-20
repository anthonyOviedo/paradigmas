// # 0. let versus var en JS
// # Corra este ejemplo y saque conclusiones sobre scope (salga de node después de cada  ejemplo)
// # // Ejemplo A (var)
// # var x = 666
// # if (true){
// #     var x = 0
// # 	console.log("A then", x)
// # } else{
// #      console.log("A else", x)
// # }
// # console.log("A x=", x)
// # // Ejemplo B (let)
// # let x = 666
// # if (true){
// #     var x = 0
// # 	console.log("B then", x)
// # } else{
// #      console.log("B else", x)
// # }
// # console.log("B x=", x)

// # // Ejemplo C (var function)
// # var x = 666
// # function foo(){
// # 	if (false){
// # 		var x = 0
// # 		console.log("C then", x)
// # 	} else{
// # 		 console.log("C else", x)
// # 	}
// # }
// # console.log("C x=", x)

// # 1. Considere estas declaraciones en JS
// # const choose = (p, f, g) => x => p(x) ? f(x) : g(x)
// # const False = x => false
// # const True = x => true
// # const and = (f, g) => x => f(x) && g(x)
// # const not = f => x => !f(x)

// # 2) Dibute el AST la lambda de choose

// # 3) Pruebe las siguientes identidades para todos f, g y x.
// # Nota: Lo puede hacer reduciendo ambos lados de la identidad a la misma expresión usando el cálculo lambda.
// # Pruebe (no es necesario dibujar ASTs en estos ejercicios.)
// # a) choose(True, f, g)(x) = f(x)
// # b) not(True)(x) = False(x)
// # c) not(not(f))(x) = f(x)
// # d) and(f, g)(x) = choose(f, g, False)(x)

// # 4) Considere el siguiente código en Java
// # <S, T, R> Function<S, R> comp(Function<S, T> f, Function<T, R> g){
// #     return (S x) -> g.apply(f.apply(x));
// # }
// # a) Pruebe que compila en Jshell
// # b) Cambie por
// # <S, T, R> Function<S, R> comp(Function<S, T> f, Function<T, R> g){
// #     return x -> g.apply(f.apply(x));
// # }
// # Verfique que igualmente compila
// # ¿Qué feature de Javac permitió que también compile a pesar del cambio
