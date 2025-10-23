%- size(+L, +N) N is the length of the list L

size([], 0).
size([_ | R], N) :-
    size(R, NR),
	N is 1 + NR
.

add_list([], 0).
add_list([F | R], N) :-
    add_list(R, NR),
	N is F + NR
.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% person_get_name(+P, -N) : N is the name of person P
% where P = person(Name, Age, Gender)
% and Name = name(First, Last)
person_get_name(person(Name, _, _), Name).

person_get_firstname(person(name(First, _), _, _), First).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%- first(+L, -F): F is the first element of list L
first([F | _], F).
second([_, S | _], S). % second([_ | [S | _] ], S)
:- 
    writeln('*** Examples ***'),
	%
	writeln('*** size of list ***'),
	L = [[1], 2, [3]],
	size(L, N),
	writeln([L, N]),
	%
	writeln('*** Add list ***'),
	M = [10, 20, -10],
	add_list(M, SM),
	writeln([M, SM])
.

test_case_person :-
   L = [
     person(name(alex, perez), 24, male),
	 person(name(ana, salis), 20, female),
	 person(name(jafeth, soto), 45, male)
   ],
   person_list_print(L)
.

person_list_print(LP) :-
    member(person(name(F, L),_,_), LP),
	format('>>> ~s, ~s~n', [L, F]),
	fail % forces backtracking
.
person_list_print(_).
