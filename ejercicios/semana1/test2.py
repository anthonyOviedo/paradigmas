#!/usr/bin/env python3
from functools import reduce
from operator import itemgetter

# Ejemplo 1
# solo suma, la funcion f difinida es utilizada mas adelante en el print, asi como lo dice la funcion x: x+x, lo que significa, que el numero solo es la suma de si mismo
f = lambda x: x + x          # λx. x + x
print(f(3))                  # (λx. x + x) 3  →  6

# Ejemplo 2 (anidado) en esta funcion, double viene a ser la definicion de la lambda , la cual va a ser utilizada, la sintaxis nos permite enviar lambdas como parametros
double = lambda x: x + x                 # λx. x + x esto es una sinple definicion
apply_twice = lambda g, v: g(g(v))       # λg. λv. g (g v) aqui se recibe una funcion g, la cual va a afectr a v para posteriormente ese resultado meterlo de nuevo en la funcion g 

print(apply_twice(double, 2))            # → 8 aqui vemos donde se pasa la funcion por parametros llamada double, esa es la g que se va a utilizar dos veces (g g(v))
# Equivale a: (λg. λv. g (g v)) (λx. x + x) 2  →  (λv. double (double v)) 2 → 8

# Ejemplo 3 (currificación)
add = lambda x: (lambda y: x + y)        # λx. λy. x + y
print(add(5)(7))                         # ((λx. λy. x + y) 5) 7  → 12


input("ctrl+C to quit")

# -----------------------------
# Datos de ejemplo
# -----------------------------
nums = [2, 5, 8, 3, 10, 7]
pares = [(1, "a"), (3, "c"), (2, "b"), (2, "a")]
users = [
    {"nombre": "Ana", "edad": 29},
    {"nombre": "Luis", "edad": 35},
    {"nombre": "Marta", "edad": 22},
    {"nombre": "Luis", "edad": 19},
]

# -----------------------------
# 1) sorted / max / min con key=lambda
# -----------------------------
orden_nums = sorted(nums, key=lambda x: x)               # trivial
orden_pares = sorted(pares, key=lambda p: (p[1]))   # por 2nd parametro
user_mayor  = max(users, key=lambda u: u["edad"])   
users_alf   = sorted(users, key=lambda u: (u["nombre"], u["edad"]))

# -----------------------------
# 2) map + filter (aunque list comps son preferibles)
# -----------------------------
cuadrados = list(map(lambda x: x * x, nums))
solo_pares = list(filter(lambda x: x % 2 == 0, nums))

# -----------------------------
# 3) reduce para acumulaciones
# -----------------------------
suma_nums = reduce(lambda a, b: a + b, nums)
producto_nums = reduce(lambda a, b: a * b, nums, 1)  # con valor inicial

# -----------------------------
# 4) Diccionario de funciones (dispatch)
# -----------------------------
ops = {
    "+": lambda a, b: a + b,
    "-": lambda a, b: a - b,
    "*": lambda a, b: a * b,
    "/": lambda a, b: a / b if b != 0 else float("inf"),
}
calc_ej = ops["*"](6, 7)

# -----------------------------
# 5) Clausura rápida con lambda
# -----------------------------
def make_power(n):
    return lambda x: x ** n

pow2 = make_power(2)
pow3 = make_power(3)

# -----------------------------
# 6) Lambda con condicional (ternario)
# -----------------------------
tipo_num = lambda x: "par" if x % 2 == 0 else "impar"
tipos = [tipo_num(x) for x in nums]

# -----------------------------
# 7) Uso con itemgetter (no es lambda pero útil comparativo)
# -----------------------------
# A veces itemgetter es más claro/rápido:
users_por_nombre = sorted(users, key=itemgetter("nombre"))

# -----------------------------
# Resultados
# -----------------------------
if __name__ == "__main__":
    print("1) sorted/max/min")
    print("   orden_nums      :", orden_nums)
    print("   orden_pares     :", orden_pares)
    print("   user_mayor      :", user_mayor)
    print("   users_alf       :", users_alf)
    input("ctrl+C to quit")

    print("\n2) map/filter")
    print("   cuadrados       :", cuadrados)
    print("   solo_pares      :", solo_pares)
    input("ctrl+C to quit")

    print("\n3) reduce")
    print("   suma_nums       :", suma_nums)
    print("   producto_nums   :", producto_nums)
    input("ctrl+C to quit")

    print("\n4) dict de ops")
    print("   calc_ej (6*7)   :", calc_ej)
    input("ctrl+C to quit")

    print("\n5) clausuras")
    print("   pow2(5), pow3(2):", pow2(5), pow3(2))
    input("ctrl+C to quit")

    print("\n6) condicional en lambda")
    print("   tipos           :", tipos)
    input("ctrl+C to quit")

    print("\n7) itemgetter vs lambda")
    print("   users_por_nombre:", users_por_nombre)
