import sys
import random

from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import (
    QApplication,
    QGridLayout,
    QLineEdit,
    QMainWindow,
    QPushButton,
    QVBoxLayout,
    QHBoxLayout,
    QComboBox,
    QWidget,
    QLabel,
    QDialog,
    QMessageBox

)
from PyQt6.QtGui import QAction


        
class Ortografia(QMainWindow):
    """PyCalc's main window (GUI or view)."""

    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ortografía de Marta")
        self.numeroPred = 9 
        
        self.mal = ["garage", "misógeno", "preveer", "transplantar", "urgar", "inexcrutable", "jeringoza", "inflingido", "hemiplegía", "exausto"]
        self.bien = ["garaje", "misógino", "prever", "trasplantar", "hurgar", "inescrutable", "jerigonza", "infligido", "hemiplejía", "exhausto"]

        self.palabrastotales = 10
        self.numDificultad = 5

        self.bienb = True # Es para saber si el dato enviado esta bien escrito o no
        self.setFixedSize(500, 500)
        self.generalLayout = QVBoxLayout()
        
        
        centralWidget = QWidget(self)
        centralWidget.setLayout(self.generalLayout)
        centralWidget.setStyleSheet("background: pink;")
        self.setCentralWidget(centralWidget)
        self.pregunta = QLabel("¿Está esta palabra bien escrita?")
        #self.palabra = QLabel(self._palabra())
        self.palabra = QLabel()
        self.palabra.setStyleSheet("QLabel"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : lightGrey;"
                                 "color : black;"
                                 "}")
        self.palabra.setFixedHeight(50)
        self.pregunta.setFixedHeight(50)
        
        self.generalLayout.addWidget(self.pregunta)
        self.generalLayout.addWidget(self.palabra)
        self.layh = QHBoxLayout()
        
        self.createButtons()
        self.generalLayout.addLayout(self.layh)
        self.laygrid= QGridLayout()
        
        self.createGrid()
    
        self.generalLayout.addLayout(self.laygrid)
        self.generalLayout.setContentsMargins(50,50,50,50)
        self.laygrid.setHorizontalSpacing(30)
        self.acertado = 0
        self.fallado = 0
        self.botonBien.clicked.connect(self.pulsaBien)
        self.botonMal.clicked.connect(self.pulsaMal)
        
        self.createActions()
        self.createMenu()
        self.descripcionJuego()
        
        #self._createDisplay()

    def descripcionJuego(self):
        dlg = QMessageBox(self)
        dlg.setWindowTitle("Guia:")
        dlg.setText("Seleccione tanto la cantidad de palabras como la dificultad en la barra al mismo nivel que el menú.\n\n" +
                    "A continuación entre en el menú y dele a \"Jugar\".\n\n"
                    "\tCómo jugar:\n\nAparecerá una palabra en la caja gris. Tan solo debe pulsar \"bien\", si piensa que la ortografía es correcta, o \"mal\""
                    " si piensa que es incorrecta. Los fallos y aciertos se irán actualizando y al final obtendrá una nota y un estado"
                    " \"APROBADO\" o \"SUSPENDIDO\" dependiendo del resultado. Buena suerte :)")
        dlg.setStyleSheet("background: pink;")
        dlg.exec()

    
    def _palabra(self):
        numero = random.randint(1, 2)
        if self.numeroPred  != 0:
            numero2 = random.randint(0, self.numeroPred)
        else:
             numero2 = 0 

        if numero == 1:
            self.bienb = False
            palabra = self.mal[numero2]
            self.mal.pop(numero2)
            self.bien.pop(numero2)
            self.numeroPred -= 1
            return palabra
        else:
            self.bienb = True
            palabra = self.bien[numero2]
            self.mal.pop(numero2)
            self.bien.pop(numero2)
            self.numeroPred -= 1
            return palabra
        
    def pulsaBien(self):
        if(self.bienb == True):
            self.acertado += 1
            self.aciertos.setText(str(self.acertado))
            self.division.setText(str(self.acertado) + "/" + str(self.palabrastotales))
        else:
            self.fallado += 1
            self.fallos.setText(str(self.fallado))
        if(self.numeroPred >= 0):
            pal= self._palabra()
            self.palabra.setText(pal)
        else:
            self.botonBien.blockSignals(True)
            self.botonMal.blockSignals(True)
            self.nota.setText(str(self.acertado))
            if(self.acertado >= self.numDificultad):
                self.estado.setText("APROBADO")
            else:
                self.estado.setText("SUSPENDIDO")
            

    def pulsaMal(self):
        if(self.bienb != True):
            self.acertado += 1
            self.aciertos.setText(str(self.acertado))
            self.division.setText(str(self.acertado) + "/" + str(self.palabrastotales))
        else:
            self.fallado += 1
            self.fallos.setText(str(self.fallado))
        if(self.numeroPred >= 0):
            pal= self._palabra()
            self.palabra.setText(pal)
        else:
            self.botonBien.blockSignals(True)
            self.botonMal.blockSignals(True)
            self.nota.setText(str(self.acertado))
            if(self.acertado >= 5):
                self.estado.setText("APROBADO")
            else:
                self.estado.setText("SUSPENDIDO")
    def createButtons(self):
        self.botonBien = QPushButton("Bien")
        self.botonBien.setEnabled(False)
        self.botonBien.setStyleSheet("QPushButton"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : #4AFF8D;"
                                 "color : black;"
                                 "border-radius: 5px;"
                                 "}")
        self.botonBien.setFixedHeight(50)
        self.botonMal = QPushButton("Mal")
        self.botonMal.setEnabled(False)
        self.botonMal.setStyleSheet("QPushButton"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : #FF7979;"
                                 "color : black;"
                                 "border-radius: 5px;"
                                 "}")
    
        self.botonMal.setFixedHeight(50)
        self.layh.addWidget(self.botonBien)
        self.layh.addWidget(self.botonMal)


    def createGrid(self):
        self.a = QLabel("Aciertos")
        self.a.setFixedHeight(50)
        """
        self.a.setStyleSheet("QLabel"
                                 "{"
                                 "text-align: center;"
                                 "}")
        """                         
        self.b = QLabel("Fallos")
        self.b.setFixedHeight(50)
        self.c = QLabel("")
        self.c.setFixedHeight(50)
        self.d = QLabel("Nota")
        self.d.setFixedHeight(50)
        self.laygrid.addWidget(self.a, 0, 0)
        self.laygrid.addWidget(self.b, 0, 1)
        self.laygrid.addWidget(self.c, 0, 2)
        self.laygrid.addWidget(self.d, 0, 3)
        self.aciertos = QLabel("")
        self.aciertos.setFixedHeight(50)
        self.aciertos.setStyleSheet("QLabel"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : yellow;"
                                 "color : black;"
                                 "}")
        self.fallos = QLabel("")
        self.fallos.setFixedHeight(50)
        self.fallos.setStyleSheet("QLabel"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : yellow;"
                                 "color : black;"
                                 "}")
        self.nota = QLabel("")
        self.nota.setFixedHeight(50)
        self.nota.setStyleSheet("QLabel"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : yellow;"
                                 "color : black;"
                                 "}")
        self.laygrid.addWidget(self.aciertos, 1, 0)
        self.laygrid.addWidget(self.fallos, 1, 1)
        self.laygrid.addWidget(QLabel(""), 1, 2)
        self.laygrid.addWidget(self.nota, 1, 3)
        self.division = QLabel("")
        self.division.setStyleSheet("QLabel"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : #0B7ABD;"
                                 "color : white;"
                                 "}")
        self.division.setFixedHeight(50)
        self.estado = QLabel("")
        self.estado.setStyleSheet("QLabel"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : #0B7ABD;"
                                 "color : white;"
                                 "}")
        self.estado.setFixedHeight(50)
        self.laygrid.addWidget(self.division, 2, 0)
        self.laygrid.addWidget(self.estado, 2, 1, 1, 3)

    def salir(self):
        # clearing a single digit
        sys.exit()
        
    def play(self):
        
        self.palabra.setText(self._palabra()) 
        self.botonBien.setEnabled(True)
        
        self.botonBien.setStyleSheet("QPushButton"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : #17FF6C;"
                                 "color : white;"
                                 "border-radius: 15px;"
                                 "}")
        self.botonMal.setEnabled(True)
        self.botonMal.setStyleSheet("QPushButton"
                                 "{"
                                 "border : 1px solid black;"
                                 "background : #FF5252;"
                                 "color : white;"
                                 "border-radius: 15px;"
                                 "}")
    def numDiez(self):
        self.palabrastotales=10
        self.diez.setCheckable(True)
        self.veinte.setCheckable(False)
    def numVeinte(self):
        self.palabrastotales=20
        self.diez.setCheckable(False)
        self.veinte.setCheckable(True)

    def dificultadCinco(self):
        self.numDificultad=5
    def dificultadOcho(self):
        self.numDificultad=8
    def dificultadDiez(self):
        self.numDificultad=10

    def createActions(self):
        """Create the application's menu actions."""
        # Create actions for File menu
        self.jugar = QAction("Jugar")
        self.jugar.setShortcut("Ctrl+W")
        self.jugar.triggered.connect(self.play)
        self.sal = QAction("Salir")
        self.sal.setShortcut("Ctrl+Q")
        self.sal.triggered.connect(self.salir)
        self.diez =QAction("10")
        self.diez.triggered.connect(self.numDiez)
        self.veinte =QAction("20")
        self.veinte.triggered.connect(self.numVeinte)
        self.dif_cinco =QAction("5")
        self.dif_cinco.triggered.connect(self.numVeinte)
        self.dif_ocho =QAction("8")
        self.dif_ocho.triggered.connect(self.numVeinte)
        self.dif_diez =QAction("10")
        self.dif_diez.triggered.connect(self.numVeinte)
        

    def createMenu(self):
        """Create the application's menu bar."""
        mainMenu = self.menuBar()
        mainMenu.setStyleSheet("""QMenuBar { background-color: #F8FC94; }""")
        mainMenu.setNativeMenuBar(False)
        
        # Create file menu and add actions 
        file_menu = self.menuBar().addMenu("Menu")
        file_menu.addAction(self.jugar)
        file_menu.addAction(self.sal)

        file_nums = self.menuBar().addMenu("Núm palabras")
        file_nums.addAction(self.diez)
        self.diez.setCheckable(True)
        file_nums.addAction(self.veinte)
        self.veinte.setCheckable(True)
        file_diff = self.menuBar().addMenu("Dificultad")
        file_diff.addAction(self.dif_cinco)
        file_diff.addAction(self.dif_ocho)
        file_diff.addAction(self.dif_diez)
        """
        file_menu.setStyleSheet("background-color: #FAFF7B;"
                                "color:black;")
        file_nums.setStyleSheet("background-color: #FAFF7B;"
                                "color:black;")
        file_diff.setStyleSheet("background-color: #FAFF7B;"
                                "color:black;")
        """
            
            

        

def main():
    """PyCalc's main function."""
    pycalcApp = QApplication([])
    pycalcWindow = Ortografia()
    pycalcWindow.show()
    sys.exit(pycalcApp.exec())


if __name__ == "__main__":
    main()
