% Person facts: id, name(First, Last), gender, age
person(p001, name(sofia, ramirez), female, 27).
person(p002, name(luis, fernandez), male, 34).
person(p003, name(ana, torres), female, 22).
person(p004, name(marco, ibarra), male, 41).
person(p005, name(valentina, cruz), female, 30).
person(p006, name(diego, morales), male, 25).
person(p007, name(gabriela, serrano), female, 37).
person(p008, name(hector, vazquez), male, 29).
person(p009, name(karla, molina), female, 33).
person(p010, name(ricardo, gomez), male, 45).

% Account facts: link a person id with an account number and balance (hundreds)
person_account(p001, 'AC-109283', 300).
person_account(p001, 'AC-234876', 700).
person_account(p002, 'BK-992384', 400).
person_account(p003, 'CR-558120', 500).
person_account(p003, 'CR-774512', 900).
person_account(p004, 'DL-331904', 200).
person_account(p005, 'EN-802361', 800).
person_account(p006, 'FR-120934', 100).
person_account(p006, 'FR-918237', 600).
person_account(p007, 'GT-456703', 500).
person_account(p008, 'HX-665432', 300).
person_account(p009, 'IM-219878', 700).
person_account(p010, 'JQ-545001', 400).
person_account(p010, 'JQ-783244', 200).

% Rule to collect all accounts for a person id, returning richer objects
accounts_of(PersonId, Accounts) :-
    person(PersonId, name(First, Last), Gender, Age),
    findall(
        account{
            id: PersonId,
            number: AccountNumber,
            first: First,
            last: Last,
            gender: Gender,
            age: Age,
            balance: Balance
        },
        person_account(PersonId, AccountNumber, Balance),
        Accounts
    ).

% Rule to count number of accounts
accounts_num(PersonId, N) :-
    accounts_of(PersonId, Accounts),
    length(Accounts, N).

print_accounts(P) :-
    person(P, name(First, _), _, _),
    person_account(P, Account, Total),
    format("cuentas de ~w:~n# de cuenta: ~w~ntotal: ~w~n", [First, Account, Total]).

% find_account_owner(+A,-O) :-
find_account_owner(A,O):-
    person(P,name(O,_),_,_),
    person_account(P,A,_).

person_full_name(P, Name ) :- person(P,name(F,L),_,_), atomic_list_concat([F, L], ' ', Name).

% Main entry point
main :-
    writeln('*** testing'),
    person_full_name(p001,Name),
    writeln(Name).
