/**
 Simple Runner file for ease dev from CMD
 For more o differents .pl
  * Change holamundo as required for your needs
  * Add more consult for more paths
 @author loriacarlos@gmail.com 
 @since 2025
 
 Use with nodemon (assumes it's installed):
 nodemon -w . --ext pl --exec "swipl -t halt -q -s runner.pl"
 Explanation 
 * watch .pl files in current dir (-w .)
 * Execute the script runner.pl (-s runner.pl ) runner.pl 
 * Call goal its (holamundo's) main goal (-g main) 
 * On termination of script halt (-t halt)
 Limitations
 The predicate 'runner_main' should not be used in the watched scripts
*/

:- initialization(runner_main).

runner_main :-
    catch(runner_run, Error, handle_error(Error)),
    halt.
	
runner_script('./holamundo.pl').
% runner_script('../foo.pl').
% runner_script('../../goo.pl').

runner_run :-
    % Change add more paths
	forall(runner_script(S),
           consult(S)),
	%
    format(">>> (Re)Loading Ok.~n").

handle_error(Error) :-
    format(">>> Runner Error: ~w~n", [Error]).