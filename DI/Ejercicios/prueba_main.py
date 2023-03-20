"""Listing 8-11 to Listing 8-15
Written by Joshua Willman
Featured in "Beginning PyQt - A Hands-on Approach to GUI Programming, 2nd Ed."
"""

# Import necessary modules
import sys
from PyQt6.QtWidgets import (QApplication, QMainWindow)
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QIntValidator
from prueba import Ui_MainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)

        self.initializeUI()
        self.show()

    def initializeUI(self):
        self.ui.p_sumar.clicked.connect(self.suma)
        self.ui.p_restar.clicked.connect(self.resta)
    
    def suma(self):
        resultado = self.ui.sp1.value() + self.ui.sp2.value()
        self.ui.t_resultado.setText(f"{resultado}")

    def resta(self):
        resultado = self.ui.sp1.value() - self.ui.sp2.value()
        self.ui.t_resultado.setText(f"{resultado}")

#   def numberClicked(self, text_value):
#       """When a button with a digit is pressed, check if 
#       the text for QLineEdit widgets are empty. If empty, 
#       set the focus to the correct widget and enter text value."""
#       if self.ui.line_edit1.text() == "":
#           self.ui.line_edit1.setFocus()
#           self.ui.line_edit1.setText(text_value)
#           self.ui.line_edit1.repaint()
#       elif (self.ui.line_edit1.text() != "") and (self.ui.line_edit2.text() == ""):
#           self.ui.line_edit2.setFocus()
#           self.ui.line_edit2.setText(text_value)
#           self.ui.line_edit2.repaint()
#       elif (self.ui.line_edit1.text() != "") and (self.ui.line_edit2.text() != "") \
#           and (self.ui.line_edit3.text() == ""):
#           self.ui.line_edit3.setFocus()
#           self.ui.line_edit3.setText(text_value)
#           self.ui.line_edit3.repaint()
#       elif (self.ui.line_edit1.text() != "") and (self.ui.line_edit2.text() != "") \
#           and (self.ui.line_edit3.text() != "") and (self.ui.line_edit4.text() == ""):
#           self.ui.line_edit4.setFocus()
#           self.ui.line_edit4.setText(text_value)
#           self.ui.line_edit4.repaint()
#       
#   def checkPasscode(self):
#       """Concatenate the text values from the 4 QLineEdit widgets,
#       and check to see if the passcode entered by user matches 
#       existing passcode."""
#       entered_passcode = self.ui.line_edit1.text() + self.ui.line_edit2.text() + \
#           self.ui.line_edit3.text() +  self.ui.line_edit4.text()
#       if len(entered_passcode) == 4 and int(entered_passcode) == self.passcode:
#           QMessageBox.information(self, "Valid Passcode!", "Valid Passcode!", 
#               QMessageBox.StandardButton.Ok)
#           self.close()
#       else:
#           QMessageBox.warning(self, "Error Message", "Invalid Passcode.", 
#               QMessageBox.StandardButton.Close)
#           self.ui.line_edit1.clear()
#           self.ui.line_edit2.clear()
#           self.ui.line_edit3.clear()
#           self.ui.line_edit4.clear()
#           self.ui.line_edit1.setFocus()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    Keypad = MainWindow()
    sys.exit(app.exec())