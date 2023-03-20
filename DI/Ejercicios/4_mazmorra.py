"""
ESQUEMA:    
Un metodo para cada sala:
    def salaNorte()
    def salaSur()
    def salaEste()
    def salaOeste()

Un booleano que marcara si sigues jugando

Una lista que contenga las salas que quedan sin vencer

Un metodo que imprima las salas que queden
    def imprimirsalas()

Un metodo que reinicie las salas por si se muere o se vuelve a jugar
    def reiniciarSalas()

Una lista para los acertijos y otra con sus soluciones con un numero random que escoja el acertijo
Lo mismo para las preguntas de la sala oeste

Un metodo que describa cómo funciona el juego
"""


from random import randint
import time
muerto = False
defensas = ["\tTe lanzas a abofetear al temible monstruo pero resbalas con una cascara de platano y fallas",
            "\tLe lanzas una piedra al jefe pero parece que no le ha afectado mucho",
            "\tLe haces un calvo, parece que se tapa los ojos un segundo pero solo se enfada mas"
            "\tAgarras la espada pero se te cae",
            "\tCoges un gran martillo se lo lanzas, dandole pero no debilitandolo",
            "\tLogras alcanzar una flecha, disparando y rozando pero no matando al monstruo",
            "\tSacas tus dagas y corres hasta la bestia, te tropiezas con una piedra que vuela hacia el y lo mata",
            "\tAparece Eric el delegado y se lanza al monstruo. Para cuando acaba con el, el monstruo es irreconocible",
            "\tHaces un triple salto mortal cayendo sobre los hombros del jefe y arrancandole la cabeza",
            "\tInvoca a Jesucristo que abre un portal y devuelve al monstruo y le grita ATRAS SATANAS POR AQUI NO VUELVAS MÁS"]
ataques = ["\tTe intenta pinchar con su tridente de las delicias pero falla",
            "\tInvoca 5 cabras satanicas que te embisten, pero aguantas",
            "\tViene un ataque mortal, pero Eric el delegado aparece en ultimo momento y te salva",
            "\tSus garras casi te rozan, pero consigues evadirlas gracias a las clases de acrosport del cole",
            "\tDibuja un pentagrama sobre el suelo, de ahi sale la play 5. Decides venderle tu alma por ella."]

def imprimeAtaque(numAtaque):
    """
    Imprime el ataque correspondiente dependiendo del numero aleatorio de ataque que sale
    """
    if(numAtaque <= 25):
        print(str(ataques[0]))
    elif(numAtaque <= 45):
        print(str(ataques[1]))
    elif(numAtaque <= 60):
        print(str(ataques[2]))
    elif(numAtaque < 90):
        print(str(ataques[3]))
    elif(numAtaque <= 100):
        print(str(ataques[4]))
   

def imprimeDefensa(numDefensa):
    """
    Imprime la defensa correspondiente dependiendo del numero aleatorio de defensa que sale
    """
    if(numDefensa <= 10):
        print(str(defensas[0]))
    elif(numDefensa <= 20):
        print(str(defensas[1]))
    elif(numDefensa <= 30):
        print(str(defensas[2]))
    elif(numDefensa <= 40):
        print(str(defensas[3]))
    elif(numDefensa <= 50):
        print(str(defensas[4]))
    elif(numDefensa < 60):
        print(str(defensas[5]))
    elif(numDefensa <= 70):
        print(str(defensas[6]))
    elif(numDefensa <= 80):
        print(str(defensas[7]))
    elif(numDefensa <= 90):
        print(str(defensas[8]))
    elif(numDefensa <= 100):
        print(str(defensas[9]))
        
        
def describirJuego():
    print("Te encuentras en la sala del medio de una mazmorra, rodeado de otras 4 salas. Una al norte, otra al sur, otra al oeste y otra al este. Para lograr salir de la mazmorra debes superar todas las salas con vida.")
jugar = True
salas = ["Norte","Sur","Este","Oeste"]
acertijos = ["Hay algo que, aunque te pertenezca, la gente siempre lo utiliza más que tú. ¿Qué es? (Respuesta = Nombre)",
            "Crezco a pesar de no estar vivo. No tengo pulmones, pero para vivir necesito el aire. El agua, aunque no tenga boca, me mata. ¿Qué soy? (Respuesta = Fuego)",
            "Estando roto es más útil que sin romperse. ¿Qué es? (Respuesta = Huevo)",
            "Aparato que te metes en la boca unas 3 veces al día. ¿Qué es? (Respuesta = Cepillo)",
            "Las personas siempre duermen menos en un mes del año. ¿Cuál es este mes? (Respuesta = Febrero)",
            "Estoy en todo pese a estar en nada. ¿Qué soy? (Respuesta = D)",
            "Te paras cuando está verde y continúas cuando está rojo. ¿Qué es? (Respuesta = Sandia)",
            "¿Qué monte era el más alto del mundo antes de descubrir el Everest? (Respuesta = Everest)",
            "La señora y el señor Sánchez tienen 6 hijos barones. Cada hijo baron tiene una hermana. ¿Cuántas personas hay en la familia Sánchez? (Respuesta = 9)",
            "Soy alto siendo joven y corto cuando soy viejo. Resplandezco con la vida y el viento es mi mayor enemigo. ¿Qué soy? (Respuesta = Vela)"]
respuestasAcertijos = ["Nombre","Fuego","Huevo","Cepillo","Febrero","D","Sandia","Everest","9","Vela"]

preguntas = ["¿Cuál es el río más largo de España? (Respuesta = Ebro)",
            "¿Cuál es el río más largo de la península ibérica? (Respuesta = Tajo)",
            "¿Cuál es el río más largo del mundo? (Respuesta = Amazonas)",
            "¿Cuál es la montaña más alta de España? (Respuesta = Teide)",
            "¿Cuál es la montaña más alta del mundo? (Respuesta = Everest)",
            "¿Cuál es el océano más grande? (Respuesta = Pacifico)",
            "¿Cuál es el país con más extensión? (Respuesta = Rusia)",
            "¿Cuál es el país más poblado? (Respuesta = India)"]
respuestasPreguntas = ["Ebro","Tajo","Amazonas","Teide","Everest","Pacifico","Rusia","India"]

def imprimirSalas():
    """
    Imprime la lista de salas
    """
    print("Salas restantes: ")
    for l in salas:
        print(l)

def reiniciarSalas():
    """
    Rellena la lista salas con las 4 salas originales
    """
    salas.clear()
    salas.append("Norte")
    salas.append("Sur")
    salas.append("Este")
    salas.append("Oeste")

def perder():
    """
    descripcion: Imprime mensaje para volver a hacer una prueba
    output: String "S" o "N" que indica si se intenta la sala de nuevo

    """
    return input("Quieres volver a intentarlo? S/N: ")

def salaMedio():
    """
    Imprime mensaje de que vuelves a la sala del medio
    """
    print("Volviendo a la sala del medio...")

def nuevaSala():
    """
    descripcion: Pide nueva sala a la que ir
    output: Nombre de la sala a la que entrar
    """
    return input("Elija nueva sala:")

def salaNorte():
    """
    descripcion: Juego de la sala norte en la que te enfrentas a un monstruo en una pelea.
    Si mueres hay que empezar el juego de cero. Hay que vencer al monstruo para superar la sala.
    output: String "S", "N" o "Muert" que indica si se sale de la sala o no o si has muerto.
    """
    perderBooleano = False
    while(perderBooleano == False):
        ataque = randint(0,100)
        #print("Ataque: " + str(ataque))
        imprimeAtaque(int(ataque))
        if(ataque > 90):
            print("Has muerto por lo que se reinicia el juego.")
            return "Muerte"
        respuesta = input("¿Quieres defenderte? S/N: ")
        if(respuesta == "S"):
            defensa = randint(0,100)
            #print("Defensa: " + str(defensa))
            imprimeDefensa(int(defensa))
            if(defensa < 60):
                perderBooleano = True
                print("La defensa ha fallado. Vas a ser atacado de nuevo.")
            else:
                print("Enhorabuena, has vencido al jefe.")
                salas.remove("Norte")
                return "N"
        else:
            return "N"

def salaSur():
    """
    descripcion: Juego de la sala sur en la que hay que acertar un acertijo para poder superar la sala.
    output: String "S" o "N" que indica si se sale de la sala o no.
    """
    numAcertijo = randint(0,9)
    print(str(acertijos[numAcertijo]))
    respuesta = input("Respuesta: ")
    if(respuestasAcertijos[numAcertijo].lower() in respuesta.lower()):
        print("Enhorabuena, has acertado.")
        salas.remove("Sur")
        return "N"
    else:
        return perder()

def salaEste():
    """
    descripcion: Juego de la sala este en el que hay que conseguir abrir un cofre para superar la sala.
    output: String "S" o "N" que indica si se sale de la sala o no.
    """
    numero = randint(1,100)
    print(numero)
    if(numero > 63):
        print("Enhorabuena, has conseguido abrir el cofre")
        salas.remove("Este")
        return "N"
    else:
        print("Descansando 20 segundos...")
        time.sleep(20)
        return perder()

def salaOeste():
    """
    descripcion: Juego de la sala oeste en el que hay que responder a una pregunta para superar la sala.
    output: String "S" o "N" que indica si se sale de la sala o no
    """
    numPregunta = randint(0,7)
    print(str(preguntas[numPregunta]))
    respuesta = input("Respuesta: ")
    if(respuestasPreguntas[numPregunta].lower() in respuesta.lower()):
        print("Enhorabuena, has acertado.")
        salas.remove("Oeste")
        return "N"
    else:
        return perder()

        
while jugar == True and muerto == False:
    describirJuego()
    reiniciarSalas()
    while(len(salas) > 0):
        imprimirSalas()
        opcion = input("¿A que sala quieres ir? ")
        if(opcion in salas):
            if(opcion == "Norte"):
                print("Aparece un monstruo y te ataca.")
                while True:
                    returnNorte = salaNorte()
                    if(returnNorte == "N"):
                        salaMedio()
                        break
                    elif(returnNorte == "Muerte"):
                        muerto = True
                        break
            if(opcion == "Sur"):
                print("Para superar esta sala debes acertar un acertijo.")
                while True:
                    if(salaSur() == "N"):
                        salaMedio()
                        break
            if(opcion == "Este"):
                print("Para superar esta sala hay que conseguir abrir un cofre.")
                while True:
                    if(salaEste() == "N"):
                        salaMedio()
                        break
            if(opcion == "Oeste"):
                print("Para superar esta sala debes responder bien a una pregunta.")
                while True:
                    if(salaOeste() == "N"):
                        salaMedio()
                        break
        else:
            print("Esa sala no está disponible. Vuelva a elegir")
    if(muerto == True):
        print("Has muerto. Quieres volver a intentarlo de nuevo?")
    else:
        reiniciar = input("Enhorabuena!! Has ganado! Quieres volver a jugar? S/N: ")
    if(reiniciar != "S"):
        jugar = False
print("Juego finalizado.")

