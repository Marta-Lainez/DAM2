"""
Crear un programa que pregunte por el nombre y el apellido de la persona que lo lanza
y devuelva un mensaje inicial con:

Hola <nombre>, qué quieres hacer:
Sumar dos números
Restar	dos números
Multiplicar dos números
Saber la hora
Conocer el día de la semana en el que nací
Salir

El programa volverá al mismo menú tras ejecutar cualquiera de las acciones entre 1 y 5. 
Cuando se escriba 6 o Salir, el programa devolverá el siguiente mensaje:

Adiós, <nombre> <apellido>
"""
from datetime import datetime
from calendar import weekday

def imprimeMenu():
    print("Hola " + nombre + ", qué quieres hacer:")
    print("""
    1)Sumar dos números
    2)Restar dos números
    3)Multiplicar dos números
    4)Saber la hora
    5)Conocer el día de la semana en el que nací
    6)Salir
    """)
def suma(x,y):
    """
    descripcion: Esta funcion suma los parametros
    input: factores a sumar
    output: suma
    """
    return x+y

def resta(x,y):
    """
    descripcion: Esta funcion resta los parametros
    input: factores a restar
    output: resta
    """
    return x-y

def multiplica(x,y):
    """
    descripcion: Esta funcion multiplica los parametros
    input: factores a multiplicar
    output: producto
    """
    return x*y
def diaCumple(año,mes,dia):
    """
    input: año, mes, dia
    descripcion: imprime el dia de la semana que era el dia del input
    """
    dia = weekday(int(año),int(mes),int(dia))
    if(dia == 0):
        print("Lunes")
    elif(dia == 1):
        print("Martes")
    elif(dia == 2):
        print("Miercoles")
    elif(dia == 3):
        print("Jueves")
    elif(dia == 4):
        print("Viernes")
    elif(dia == 5):
        print("Sabado")
    else:
        print("Domingo")

nombre = input("Tu nombre:")
apellido = input("Tu apellido:")
imprimeMenu()
opcion = input("Opcion: ")
while(opcion != "6" and opcion != "Salir"):
    if(opcion == "1"):
        x = int(input("Primer numero: "))
        y = int(input("Segundo numero: "))
        print(suma(x,y))
    elif(opcion == "2"):
        x = int(input("Primer numero: "))
        y = int(input("Segundo numero: "))
        print(resta(x,y))
    elif(opcion == "3"):
        x = int(input("Primer numero: "))
        y = int(input("Segundo numero: "))
        print(multiplica(x,y))
    elif(opcion == "4"):
        print(datetime.now())
    elif(opcion == "5"):
        dia = int(input("Dia: "))
        mes = int(input("Mes: "))
        año = int(input("Año: "))
        diaCumple(año,mes,dia)
    else:
        print("Esa opcion no existe")

    imprimeMenu()
    opcion = input("Opcion: ")

print("Adiós, " + nombre + " " + apellido)
