"""Listing 5-1 to Listing 5-2
Written by Joshua Willman
Featured in "Beginning PyQt - A Hands-on Approach to GUI Programming, 2nd Ed."
"""

# Import necessary modules for menu
import sys
from PyQt6.QtWidgets import (QApplication, QMainWindow,QDockWidget,
QPushButton,QVBoxLayout,QWidget,QLabel,QToolBar,QGridLayout,QSizePolicy,QFrame,QMessageBox,QDialog)
from PyQt6.QtGui import QAction
from PyQt6.QtCore import Qt, QSize, QRect
# Import necessary modules for dungeon
from random import randint
import time

class MainWindow(QMainWindow):

				def __init__(self):
								super().__init__()
								self.initializeUI()
								

				def initializeUI(self):
								"""Set up the application's GUI."""
								self.setMinimumSize(450, 350)
								self.setWindowTitle("La mazmorra de Marta Lainez")
								toolbar = QToolBar("My main toolbar")
								self.addToolBar(toolbar)

								self.setUpMainWindow()
								self.createActions()
								self.createMenu()
								self.show()
								self.salas = ["Norte","Sur","Este","Oeste"]
								self.defensas = ["\tTe lanzas a abofetear al temible monstruo pero resbalas con una cascara de platano y fallas",
								"\tLe lanzas una piedra al jefe pero parece que no le ha afectado mucho",
								"\tLe haces un calvo, parece que se tapa los ojos un segundo pero solo se enfada mas"
								"\tAgarras la espada pero se te cae",
								"\tCoges un gran martillo se lo lanzas, dandole pero no debilitandolo",
								"\tLogras alcanzar una flecha, disparando y rozando pero no matando al monstruo",
								"\tSacas tus dagas y corres hasta la bestia, te tropiezas con una piedra que vuela hacia el y lo mata",
								"\tAparece Eric el delegado y se lanza al monstruo. Para cuando acaba con el, el monstruo es irreconocible",
								"\tHaces un triple salto mortal cayendo sobre los hombros del jefe y arrancandole la cabeza",
								"\tInvoca a Jesucristo que abre un portal y devuelve al monstruo y le grita ATRAS SATANAS POR AQUI NO VUELVAS MAS"]
								self.ataques = ["\tTe intenta pinchar con su tridente de las delicias pero falla",
								"\tInvoca 5 cabras satanicas que te embisten, pero aguantas",
								"\tViene un ataque mortal, pero Eric el delegado aparece en ultimo momento y te salva",
								"\tSus garras casi te rozan, pero consigues evadirlas gracias a las clases de acrosport del cole",
								"\tDibuja un pentagrama sobre el suelo, de ahi sale la play 5. Decides venderle tu alma por ella."]

				def setUpMainWindow(self):
					"""Create and arrange widgets in the main window."""
					frame = QFrame()

					layoutPrincipal = QGridLayout()
					self.pushNorte = QPushButton("Norte", self)
					self.pushNorte.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Expanding)
					self.pushSur = QPushButton("Sur", self)
					self.pushSur.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Expanding)
					self.pushEste = QPushButton("Este", self)
					self.pushEste.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Expanding)
					self.pushOeste = QPushButton("Oeste", self)
					self.pushOeste.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Expanding)
					self.pushCentral = QPushButton("Central", self)
					self.pushCentral.setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Expanding)

					self.pushNorte.setEnabled(False)
					self.pushOeste.setEnabled(False)
					self.pushCentral.setEnabled(False)
					self.pushEste.setEnabled(False)
					self.pushSur.setEnabled(False)

					layoutPrincipal.addWidget(self.pushNorte,0,1)
					layoutPrincipal.addWidget(self.pushOeste,1,0)
					layoutPrincipal.addWidget(self.pushCentral,1,1)
					layoutPrincipal.addWidget(self.pushEste,1,2)
					layoutPrincipal.addWidget(self.pushSur,2,1)

					self.pushNorte.clicked.connect(self.action_norte)
					self.pushOeste.clicked.connect(self.action_oeste)
					self.pushCentral.clicked.connect(self.action_central)
					self.pushEste.clicked.connect(self.action_este)
					self.pushSur.clicked.connect(self.action_sur)

					frame.setLayout(layoutPrincipal)
					self.setCentralWidget(frame)

				def entrarSala(self,texto):
					dlg = QDialog()
					dlg.setWindowTitle(texto)
					dlg.setFixedSize(200,1)
					dlg.exec()
				
				def action_norte(self,texto):
					self.entrarSala("Entras en la sala norte")

				def action_oeste(self):
					self.entrarSala("Entras en la sala oeste")
				
				def action_central(self):
 					self.entrarSala("Entras en la sala central")

				def action_este(self):
					self.entrarSala("Entras en la sala este")
				
				def action_sur(self):
					self.entrarSala("Entras en la sala sur")
				
				def createActions(self):
							"""Create the application's menu actions."""
							# Create actions for File menu
							self.quit_act = QAction("Salir")
							self.quit_act.setShortcut("Ctrl+Q")
							self.quit_act.triggered.connect(self.close)

							self.play_act = QAction("Jugar")
							self.play_act.setShortcut("Ctrl+P")
							self.play_act.triggered.connect(self.jugar)
							
				def jugar(self):
					self.pushNorte.setEnabled(True)
					self.pushOeste.setEnabled(True)
					self.pushCentral.setEnabled(True)
					self.pushEste.setEnabled(True)
					self.pushSur.setEnabled(True)

				def createMenu(self):
								"""Create the application's menu bar."""
								self.menuBar().setNativeMenuBar(False)

								# Create file menu and add actions 
								file_menu = self.menuBar().addMenu("Menu")
								file_menu.addAction(self.quit_act)
								file_menu.addAction(self.play_act)
				
				def imprimeAtaque(self,numAtaque):
					"""
					Imprime el ataque correspondiente dependiendo del numero aleatorio de ataque que sale
					"""
					if(numAtaque <= 25):
						print(str(self.ataques[0]))
					elif(numAtaque <= 45):
						print(str(self.ataques[1]))
					elif(numAtaque <= 60):
						print(str(self.ataques[2]))
					elif(numAtaque < 90):
						print(str(self.ataques[3]))
					elif(numAtaque <= 100):
						print(str(self.ataques[4]))
				
				def imprimeDefensa(self,numDefensa):
					"""
					Imprime la defensa correspondiente dependiendo del numero aleatorio de defensa que sale
					"""
					if(numDefensa <= 10):
						print(str(self.defensas[0]))
					elif(numDefensa <= 20):
						print(str(self.defensas[1]))
					elif(numDefensa <= 30):
						print(str(self.defensas[2]))
					elif(numDefensa <= 40):
						print(str(self.defensas[3]))
					elif(numDefensa <= 50):
						print(str(self.defensas[4]))
					elif(numDefensa < 60):
						print(str(self.defensas[5]))
					elif(numDefensa <= 70):
						print(str(self.defensas[6]))
					elif(numDefensa <= 80):
						print(str(self.defensas[7]))
					elif(numDefensa <= 90):
						print(str(self.defensas[8]))
					elif(numDefensa <= 100):
						print(str(self.defensas[9]))
			
				def salaNorte(self):
					"""
					descripcion: Juego de la sala norte en la que te enfrentas a un monstruo en una pelea.
					Si mueres hay que empezar el juego de cero. Hay que vencer al monstruo para superar la sala.
					output: String "S", "N" o "Muert" que indica si se sale de la sala o no o si has muerto.
					"""
					perderBooleano = False
					while(perderBooleano == False):
						ataque = randint(0,100)
						#print("Ataque: " + str(ataque))
						self.imprimeAtaque(int(ataque))
						if(ataque > 90):
							print("Has muerto por lo que se reinicia el juego.")
							return "Muerte"
						respuesta = input("¿Quieres defenderte? S/N: ")
						if(respuesta == "S"):
							defensa = randint(0,100)
							#print("Defensa: " + str(defensa))
							self.imprimeDefensa(int(defensa))
							if(defensa < 60):
								perderBooleano = True
								print("La defensa ha fallado. Vas a ser atacado de nuevo.")
							else:
								print("Enhorabuena, has vencido al jefe.")
								self.salas.remove("Norte")
								return "N"
						else:
							return "N"

if __name__ == '__main__':
				app = QApplication(sys.argv)
				window = MainWindow()
				sys.exit(app.exec())