# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'mazmorra.ui'
##
## Created by: Qt User Interface Compiler version 6.4.1
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QAction, QBrush, QColor, QConicalGradient,
    QCursor, QFont, QFontDatabase, QGradient,
    QIcon, QImage, QKeySequence, QLinearGradient,
    QPainter, QPalette, QPixmap, QRadialGradient,
    QTransform)
from PySide6.QtWidgets import (QApplication, QFrame, QGridLayout, QHBoxLayout,
    QLineEdit, QMainWindow, QMenu, QMenuBar,
    QPushButton, QRadioButton, QSizePolicy, QStatusBar,
    QTextEdit, QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(722, 494)
        MainWindow.setBaseSize(QSize(0, 0))
        self.actionSalir = QAction(MainWindow)
        self.actionSalir.setObjectName(u"actionSalir")
        self.actionAyuda = QAction(MainWindow)
        self.actionAyuda.setObjectName(u"actionAyuda")
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.frame_6 = QFrame(self.centralwidget)
        self.frame_6.setObjectName(u"frame_6")
        self.frame_6.setGeometry(QRect(0, 0, 441, 451))
        self.frame_6.setFrameShape(QFrame.Panel)
        self.frame_6.setFrameShadow(QFrame.Raised)
        self.frame_6.setLineWidth(7)
        self.frame_6.setMidLineWidth(0)
        self.layoutWidget = QWidget(self.frame_6)
        self.layoutWidget.setObjectName(u"layoutWidget")
        self.layoutWidget.setGeometry(QRect(10, 10, 421, 431))
        self.gridLayout = QGridLayout(self.layoutWidget)
        self.gridLayout.setObjectName(u"gridLayout")
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.frame_2 = QFrame(self.layoutWidget)
        self.frame_2.setObjectName(u"frame_2")
        self.frame_2.setFrameShape(QFrame.Panel)
        self.frame_2.setFrameShadow(QFrame.Raised)
        self.frame_2.setLineWidth(7)
        self.pushSur = QPushButton(self.frame_2)
        self.pushSur.setObjectName(u"pushSur")
        self.pushSur.setGeometry(QRect(0, 0, 131, 131))
        palette = QPalette()
        brush = QBrush(QColor(240, 119, 121, 255))
        brush.setStyle(Qt.SolidPattern)
        palette.setBrush(QPalette.Active, QPalette.Button, brush)
        brush1 = QBrush(QColor(240, 240, 240, 255))
        brush1.setStyle(Qt.SolidPattern)
        palette.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette.setBrush(QPalette.Disabled, QPalette.Button, brush)
        self.pushSur.setPalette(palette)
        self.pushSur.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushSur.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.pushSur.setAutoDefault(False)
        self.pushSur.setFlat(False)

        self.gridLayout.addWidget(self.frame_2, 2, 1, 1, 1)

        self.frame_3 = QFrame(self.layoutWidget)
        self.frame_3.setObjectName(u"frame_3")
        self.frame_3.setFrameShape(QFrame.Panel)
        self.frame_3.setFrameShadow(QFrame.Raised)
        self.frame_3.setLineWidth(7)
        self.pushCentral = QPushButton(self.frame_3)
        self.pushCentral.setObjectName(u"pushCentral")
        self.pushCentral.setGeometry(QRect(0, 0, 131, 131))
        palette1 = QPalette()
        palette1.setBrush(QPalette.Active, QPalette.Button, brush)
        palette1.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette1.setBrush(QPalette.Disabled, QPalette.Button, brush)
        self.pushCentral.setPalette(palette1)
        self.pushCentral.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushCentral.setStyleSheet(u"font: 15pt \"Lucida Calligraphy\";")
        self.pushCentral.setAutoDefault(False)
        self.pushCentral.setFlat(False)

        self.gridLayout.addWidget(self.frame_3, 1, 1, 1, 1)

        self.frame_5 = QFrame(self.layoutWidget)
        self.frame_5.setObjectName(u"frame_5")
        self.frame_5.setFrameShape(QFrame.Panel)
        self.frame_5.setFrameShadow(QFrame.Raised)
        self.frame_5.setLineWidth(7)
        self.frame_5.setMidLineWidth(0)
        self.pushNorte = QPushButton(self.frame_5)
        self.pushNorte.setObjectName(u"pushNorte")
        self.pushNorte.setGeometry(QRect(0, 0, 131, 131))
        palette2 = QPalette()
        palette2.setBrush(QPalette.Active, QPalette.Button, brush)
        palette2.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette2.setBrush(QPalette.Disabled, QPalette.Button, brush)
        self.pushNorte.setPalette(palette2)
        self.pushNorte.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushNorte.setMouseTracking(False)
        self.pushNorte.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.pushNorte.setAutoDefault(False)
        self.pushNorte.setFlat(False)

        self.gridLayout.addWidget(self.frame_5, 0, 1, 1, 1)

        self.frame_4 = QFrame(self.layoutWidget)
        self.frame_4.setObjectName(u"frame_4")
        self.frame_4.setFrameShape(QFrame.Panel)
        self.frame_4.setFrameShadow(QFrame.Raised)
        self.frame_4.setLineWidth(7)
        self.pushOeste = QPushButton(self.frame_4)
        self.pushOeste.setObjectName(u"pushOeste")
        self.pushOeste.setGeometry(QRect(0, 0, 131, 131))
        palette3 = QPalette()
        palette3.setBrush(QPalette.Active, QPalette.Button, brush)
        palette3.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette3.setBrush(QPalette.Disabled, QPalette.Button, brush)
        self.pushOeste.setPalette(palette3)
        self.pushOeste.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushOeste.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.pushOeste.setAutoDefault(False)
        self.pushOeste.setFlat(False)

        self.gridLayout.addWidget(self.frame_4, 1, 0, 1, 1)

        self.frame = QFrame(self.layoutWidget)
        self.frame.setObjectName(u"frame")
        palette4 = QPalette()
        palette4.setBrush(QPalette.Active, QPalette.Button, brush)
        brush2 = QBrush(QColor(255, 255, 255, 255))
        brush2.setStyle(Qt.SolidPattern)
        palette4.setBrush(QPalette.Active, QPalette.Base, brush2)
        palette4.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette4.setBrush(QPalette.Inactive, QPalette.Base, brush2)
        palette4.setBrush(QPalette.Disabled, QPalette.Button, brush)
        palette4.setBrush(QPalette.Disabled, QPalette.Base, brush1)
        self.frame.setPalette(palette4)
        self.frame.setFrameShape(QFrame.Panel)
        self.frame.setFrameShadow(QFrame.Raised)
        self.frame.setLineWidth(5)
        self.pushEste = QPushButton(self.frame)
        self.pushEste.setObjectName(u"pushEste")
        self.pushEste.setGeometry(QRect(0, 0, 131, 131))
        self.pushEste.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushEste.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.pushEste.setAutoDefault(False)
        self.pushEste.setFlat(False)

        self.gridLayout.addWidget(self.frame, 1, 2, 1, 1)

        self.frame_text = QFrame(self.centralwidget)
        self.frame_text.setObjectName(u"frame_text")
        self.frame_text.setGeometry(QRect(440, 0, 281, 451))
        self.frame_text.setFrameShape(QFrame.Panel)
        self.frame_text.setFrameShadow(QFrame.Raised)
        self.frame_text.setLineWidth(7)
        self.pushJugar = QPushButton(self.frame_text)
        self.pushJugar.setObjectName(u"pushJugar")
        self.pushJugar.setGeometry(QRect(10, 410, 111, 31))
        palette5 = QPalette()
        brush3 = QBrush(QColor(170, 255, 255, 255))
        brush3.setStyle(Qt.SolidPattern)
        palette5.setBrush(QPalette.Active, QPalette.Button, brush3)
        palette5.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette5.setBrush(QPalette.Disabled, QPalette.Button, brush3)
        self.pushJugar.setPalette(palette5)
        self.pushJugar.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushJugar.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.pushSalir = QPushButton(self.frame_text)
        self.pushSalir.setObjectName(u"pushSalir")
        self.pushSalir.setGeometry(QRect(130, 410, 141, 31))
        palette6 = QPalette()
        brush4 = QBrush(QColor(255, 255, 127, 255))
        brush4.setStyle(Qt.SolidPattern)
        palette6.setBrush(QPalette.Active, QPalette.Button, brush4)
        palette6.setBrush(QPalette.Inactive, QPalette.Button, brush1)
        palette6.setBrush(QPalette.Disabled, QPalette.Button, brush4)
        self.pushSalir.setPalette(palette6)
        self.pushSalir.setCursor(QCursor(Qt.PointingHandCursor))
        self.pushSalir.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.textEdit_texto = QTextEdit(self.frame_text)
        self.textEdit_texto.setObjectName(u"textEdit_texto")
        self.textEdit_texto.setGeometry(QRect(10, 10, 261, 261))
        self.textEdit_texto.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.textEdit_texto.setReadOnly(True)
        self.textEdit_respuesta = QTextEdit(self.frame_text)
        self.textEdit_respuesta.setObjectName(u"textEdit_respuesta")
        self.textEdit_respuesta.setGeometry(QRect(130, 280, 141, 121))
        self.textEdit_respuesta.setStyleSheet(u"font: 11pt \"Lucida Calligraphy\";")
        self.textEdit_respuesta.setReadOnly(True)
        self.horizontalLayoutWidget = QWidget(self.frame_text)
        self.horizontalLayoutWidget.setObjectName(u"horizontalLayoutWidget")
        self.horizontalLayoutWidget.setGeometry(QRect(10, 290, 111, 101))
        self.verticalLayout = QVBoxLayout(self.horizontalLayoutWidget)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.textEdit_opcion3 = QLineEdit(self.horizontalLayoutWidget)
        self.textEdit_opcion3.setObjectName(u"textEdit_opcion3")

        self.horizontalLayout.addWidget(self.textEdit_opcion3)

        self.radioButton_3 = QRadioButton(self.horizontalLayoutWidget)
        self.radioButton_3.setObjectName(u"radioButton_3")
        sizePolicy = QSizePolicy(QSizePolicy.Fixed, QSizePolicy.Expanding)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.radioButton_3.sizePolicy().hasHeightForWidth())
        self.radioButton_3.setSizePolicy(sizePolicy)
        self.radioButton_3.setCursor(QCursor(Qt.PointingHandCursor))

        self.horizontalLayout.addWidget(self.radioButton_3)


        self.verticalLayout.addLayout(self.horizontalLayout)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.textEdit_opcion2 = QLineEdit(self.horizontalLayoutWidget)
        self.textEdit_opcion2.setObjectName(u"textEdit_opcion2")

        self.horizontalLayout_2.addWidget(self.textEdit_opcion2)

        self.radioButton_2 = QRadioButton(self.horizontalLayoutWidget)
        self.radioButton_2.setObjectName(u"radioButton_2")
        sizePolicy.setHeightForWidth(self.radioButton_2.sizePolicy().hasHeightForWidth())
        self.radioButton_2.setSizePolicy(sizePolicy)
        self.radioButton_2.setCursor(QCursor(Qt.PointingHandCursor))

        self.horizontalLayout_2.addWidget(self.radioButton_2)


        self.verticalLayout.addLayout(self.horizontalLayout_2)

        self.horizontalLayout_3 = QHBoxLayout()
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.textEdit_opcion1 = QLineEdit(self.horizontalLayoutWidget)
        self.textEdit_opcion1.setObjectName(u"textEdit_opcion1")

        self.horizontalLayout_3.addWidget(self.textEdit_opcion1)

        self.radioButton_1 = QRadioButton(self.horizontalLayoutWidget)
        self.radioButton_1.setObjectName(u"radioButton_1")
        sizePolicy1 = QSizePolicy(QSizePolicy.Fixed, QSizePolicy.Minimum)
        sizePolicy1.setHorizontalStretch(0)
        sizePolicy1.setVerticalStretch(0)
        sizePolicy1.setHeightForWidth(self.radioButton_1.sizePolicy().hasHeightForWidth())
        self.radioButton_1.setSizePolicy(sizePolicy1)
        self.radioButton_1.setCursor(QCursor(Qt.PointingHandCursor))

        self.horizontalLayout_3.addWidget(self.radioButton_1)


        self.verticalLayout.addLayout(self.horizontalLayout_3)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 722, 22))
        self.menuMenu = QMenu(self.menubar)
        self.menuMenu.setObjectName(u"menuMenu")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.menubar.addAction(self.menuMenu.menuAction())
        self.menuMenu.addAction(self.actionSalir)
        self.menuMenu.addAction(self.actionAyuda)

        self.retranslateUi(MainWindow)

        self.pushSur.setDefault(False)
        self.pushCentral.setDefault(False)
        self.pushNorte.setDefault(False)
        self.pushOeste.setDefault(False)
        self.pushEste.setDefault(False)


        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.actionSalir.setText(QCoreApplication.translate("MainWindow", u"Salir", None))
        self.actionAyuda.setText(QCoreApplication.translate("MainWindow", u"Ayuda", None))
        self.pushSur.setText(QCoreApplication.translate("MainWindow", u"Sur", None))
        self.pushCentral.setText(QCoreApplication.translate("MainWindow", u"Sala\n"
"Central", None))
        self.pushNorte.setText(QCoreApplication.translate("MainWindow", u"Norte", None))
        self.pushOeste.setText(QCoreApplication.translate("MainWindow", u"Oeste", None))
        self.pushEste.setText(QCoreApplication.translate("MainWindow", u"Este", None))
        self.pushJugar.setText(QCoreApplication.translate("MainWindow", u"Jugar", None))
        self.pushSalir.setText(QCoreApplication.translate("MainWindow", u"Salir", None))
        self.radioButton_3.setText("")
        self.radioButton_2.setText("")
        self.radioButton_1.setText("")
        self.menuMenu.setTitle(QCoreApplication.translate("MainWindow", u"Menu", None))
    # retranslateUi

