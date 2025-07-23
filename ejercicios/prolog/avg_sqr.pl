% square(+X, -Y)  Y es el cuadrado de X
square(X, Y) :- Y is X * X.

% avg_sqr(+Lista, -Promedio)
avg_sqr(L, Avg) :-
    L \= [],                          % aseguramos lista no vacía
    maplist(square, L, Squares),      % aplica square a cada elemento-es acaso mapList ya una funcion dentro de swipl, entra la funcion, la lista, y devuelve otra lista
    sum_list(Squares, Sum),           % suma los cuadrados - es acaso sum_list una funcion de prolog ? 
    length(L, Len),                   % es lenght una funcion de prolog tambien ? 
    Avg is Sum / Len.                 % literal definr la variable de retorno como return_var is result_var
