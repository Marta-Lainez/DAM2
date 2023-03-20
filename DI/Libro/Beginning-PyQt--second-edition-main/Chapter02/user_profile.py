"""Listing 2-3 to Listing 2-7
Written by Joshua Willman
Featured in "Beginning PyQt - A Hands-on Approach to GUI Programming, 2nd Ed."
"""

# Import necessary modules
import sys
from PyQt6.QtWidgets import QApplication, QWidget, QLabel
from PyQt6.QtGui import QFont, QPixmap

class MainWindow(QWidget):

    def __init__(self):
        super().__init__()
        self.initializeUI()

    def initializeUI(self):
        """Set up the application's GUI."""
        self.setGeometry(250, 250, 800, 532)
        self.setWindowTitle("2.1 - User Profile GUI")

        self.setUpMainWindow()
        self.show()

    def setUpMainWindow(self):
        """Create the labels to be displayed in the window."""
        self.createImageLabels()

        user_label = QLabel(self)
        user_label.setText("Don Pedro Sánchez")
        user_label.setFont(QFont("Arial", 20))
        user_label.move(15, 140)

        bio_label = QLabel(self)
        bio_label.setText("Bibliografía")
        bio_label.setFont(QFont("Arial", 17))
        bio_label.move(15, 170)

        about_label = QLabel(self)
        about_label.setText("Presidente de ESPAÑA, 50 años, soltero ;)")
        about_label.setWordWrap(True)
        about_label.move(15, 190)

        skills_label = QLabel(self)
        skills_label.setText("Habilidades")
        skills_label.setFont(QFont('Arial', 17))
        skills_label.move(15, 240)

        languages_label = QLabel(self)
        languages_label.setText("Política | Economía")
        languages_label.move(15, 260)

        experience_label = QLabel(self)
        experience_label.setText("Experiencia")
        experience_label.setFont(QFont("Arial", 17))
        experience_label.move(15, 290)

        developer_label = QLabel(self)
        developer_label.setText("Concejal del Ayuntamiento de Madrid")
        developer_label.move(15, 310)

        dev_dates_label = QLabel(self)
        dev_dates_label.setText("18 de mayo de 2004-15 de septiembre de 2009")
        dev_dates_label.setFont(QFont("Arial", 10))
        dev_dates_label.move(15, 330)

        driver_label = QLabel(self)
        driver_label.setText("Diputado en las Cortes Generales por Madrid")
        driver_label.move(15, 350)

        driver_dates_label = QLabel(self)
        driver_dates_label.setText("15 de septiembre de 2009-27 de septiembre de 2011")
        driver_dates_label.setFont(QFont("Arial", 10))
        driver_dates_label.move(15, 370)

    def createImageLabels(self):
        """Open image files and create image labels."""
        images = ["Chapter02/images/bandera.jpg", 
                  "Chapter02/images/peter.jpg"]

        for image in images:
            try:
                with open(image):
                    label = QLabel(self)
                    pixmap = QPixmap(image)
                    label.setPixmap(pixmap)
                    if image == "Chapter02/images/peter.jpg":
                        label.move(80, 10) 
            except FileNotFoundError as error:
                print(f"Image not found.\nError: {error}")            

# Run program
if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainWindow()
    sys.exit(app.exec())