# Form implementation generated from reading ui file 'mazmorra.ui'
#
# Created by: PyQt6 UI code generator 6.4.0
#
# WARNING: Any manual changes made to this file will be lost when pyuic6 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt6 import QtCore, QtGui, QtWidgets


class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(888, 476)
        MainWindow.setBaseSize(QtCore.QSize(0, 0))
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.frame_6 = QtWidgets.QFrame(self.centralwidget)
        self.frame_6.setGeometry(QtCore.QRect(10, 0, 431, 431))
        self.frame_6.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame_6.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame_6.setLineWidth(7)
        self.frame_6.setMidLineWidth(0)
        self.frame_6.setObjectName("frame_6")
        self.layoutWidget = QtWidgets.QWidget(self.frame_6)
        self.layoutWidget.setGeometry(QtCore.QRect(10, 10, 411, 411))
        self.layoutWidget.setObjectName("layoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.layoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")
        self.frame_2 = QtWidgets.QFrame(self.layoutWidget)
        self.frame_2.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame_2.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame_2.setLineWidth(10)
        self.frame_2.setObjectName("frame_2")
        self.pushSur = QtWidgets.QPushButton(self.frame_2)
        self.pushSur.setGeometry(QtCore.QRect(0, 0, 131, 131))
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        self.pushSur.setPalette(palette)
        self.pushSur.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushSur.setAutoDefault(False)
        self.pushSur.setDefault(False)
        self.pushSur.setFlat(False)
        self.pushSur.setObjectName("pushSur")
        self.gridLayout.addWidget(self.frame_2, 2, 1, 1, 1)
        self.frame_3 = QtWidgets.QFrame(self.layoutWidget)
        self.frame_3.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame_3.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame_3.setLineWidth(10)
        self.frame_3.setObjectName("frame_3")
        self.pushCentral = QtWidgets.QPushButton(self.frame_3)
        self.pushCentral.setGeometry(QtCore.QRect(0, 0, 131, 131))
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        self.pushCentral.setPalette(palette)
        self.pushCentral.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushCentral.setAutoDefault(False)
        self.pushCentral.setDefault(False)
        self.pushCentral.setFlat(False)
        self.pushCentral.setObjectName("pushCentral")
        self.gridLayout.addWidget(self.frame_3, 1, 1, 1, 1)
        self.frame_5 = QtWidgets.QFrame(self.layoutWidget)
        self.frame_5.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame_5.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame_5.setLineWidth(10)
        self.frame_5.setObjectName("frame_5")
        self.pushNorte = QtWidgets.QPushButton(self.frame_5)
        self.pushNorte.setGeometry(QtCore.QRect(0, 0, 131, 131))
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        self.pushNorte.setPalette(palette)
        self.pushNorte.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushNorte.setMouseTracking(False)
        self.pushNorte.setAutoDefault(False)
        self.pushNorte.setDefault(False)
        self.pushNorte.setFlat(False)
        self.pushNorte.setObjectName("pushNorte")
        self.gridLayout.addWidget(self.frame_5, 0, 1, 1, 1)
        self.frame_4 = QtWidgets.QFrame(self.layoutWidget)
        self.frame_4.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame_4.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame_4.setLineWidth(10)
        self.frame_4.setObjectName("frame_4")
        self.pushOeste = QtWidgets.QPushButton(self.frame_4)
        self.pushOeste.setGeometry(QtCore.QRect(0, 0, 131, 131))
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        self.pushOeste.setPalette(palette)
        self.pushOeste.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushOeste.setAutoDefault(False)
        self.pushOeste.setDefault(False)
        self.pushOeste.setFlat(False)
        self.pushOeste.setObjectName("pushOeste")
        self.gridLayout.addWidget(self.frame_4, 1, 0, 1, 1)
        self.frame = QtWidgets.QFrame(self.layoutWidget)
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(255, 255, 255))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Base, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(255, 255, 255))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Base, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 119, 121))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Base, brush)
        self.frame.setPalette(palette)
        self.frame.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame.setLineWidth(10)
        self.frame.setObjectName("frame")
        self.pushEste = QtWidgets.QPushButton(self.frame)
        self.pushEste.setGeometry(QtCore.QRect(0, 0, 131, 131))
        self.pushEste.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushEste.setAutoDefault(False)
        self.pushEste.setDefault(False)
        self.pushEste.setFlat(False)
        self.pushEste.setObjectName("pushEste")
        self.gridLayout.addWidget(self.frame, 1, 2, 1, 1)
        self.frame_7 = QtWidgets.QFrame(self.centralwidget)
        self.frame_7.setGeometry(QtCore.QRect(440, 0, 441, 431))
        self.frame_7.setFrameShape(QtWidgets.QFrame.Shape.Panel)
        self.frame_7.setFrameShadow(QtWidgets.QFrame.Shadow.Raised)
        self.frame_7.setLineWidth(7)
        self.frame_7.setObjectName("frame_7")
        self.horizontalLayoutWidget = QtWidgets.QWidget(self.frame_7)
        self.horizontalLayoutWidget.setGeometry(QtCore.QRect(30, 140, 381, 121))
        self.horizontalLayoutWidget.setObjectName("horizontalLayoutWidget")
        self.horizontalLayout = QtWidgets.QHBoxLayout(self.horizontalLayoutWidget)
        self.horizontalLayout.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.radioButton_1 = QtWidgets.QRadioButton(self.horizontalLayoutWidget)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Policy.Fixed, QtWidgets.QSizePolicy.Policy.Minimum)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.radioButton_1.sizePolicy().hasHeightForWidth())
        self.radioButton_1.setSizePolicy(sizePolicy)
        self.radioButton_1.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.radioButton_1.setText("")
        self.radioButton_1.setObjectName("radioButton_1")
        self.horizontalLayout.addWidget(self.radioButton_1)
        self.textEdit_opcion1 = QtWidgets.QTextEdit(self.horizontalLayoutWidget)
        self.textEdit_opcion1.setReadOnly(True)
        self.textEdit_opcion1.setObjectName("textEdit_opcion1")
        self.horizontalLayout.addWidget(self.textEdit_opcion1)
        self.radioButton_2 = QtWidgets.QRadioButton(self.horizontalLayoutWidget)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Policy.Fixed, QtWidgets.QSizePolicy.Policy.Expanding)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.radioButton_2.sizePolicy().hasHeightForWidth())
        self.radioButton_2.setSizePolicy(sizePolicy)
        self.radioButton_2.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.radioButton_2.setText("")
        self.radioButton_2.setObjectName("radioButton_2")
        self.horizontalLayout.addWidget(self.radioButton_2)
        self.textEdit_opcion2 = QtWidgets.QTextEdit(self.horizontalLayoutWidget)
        self.textEdit_opcion2.setReadOnly(True)
        self.textEdit_opcion2.setObjectName("textEdit_opcion2")
        self.horizontalLayout.addWidget(self.textEdit_opcion2)
        self.radioButton_3 = QtWidgets.QRadioButton(self.horizontalLayoutWidget)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Policy.Fixed, QtWidgets.QSizePolicy.Policy.Expanding)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.radioButton_3.sizePolicy().hasHeightForWidth())
        self.radioButton_3.setSizePolicy(sizePolicy)
        self.radioButton_3.setText("")
        self.radioButton_3.setObjectName("radioButton_3")
        self.horizontalLayout.addWidget(self.radioButton_3)
        self.textEdit_opcion3 = QtWidgets.QTextEdit(self.horizontalLayoutWidget)
        self.textEdit_opcion3.setReadOnly(True)
        self.textEdit_opcion3.setObjectName("textEdit_opcion3")
        self.horizontalLayout.addWidget(self.textEdit_opcion3)
        self.pushJugar = QtWidgets.QPushButton(self.frame_7)
        self.pushJugar.setGeometry(QtCore.QRect(20, 370, 141, 31))
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(170, 255, 255))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(170, 255, 255))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        self.pushJugar.setPalette(palette)
        self.pushJugar.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushJugar.setObjectName("pushJugar")
        self.pushSalir = QtWidgets.QPushButton(self.frame_7)
        self.pushSalir.setGeometry(QtCore.QRect(280, 370, 141, 31))
        palette = QtGui.QPalette()
        brush = QtGui.QBrush(QtGui.QColor(255, 255, 127))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Active, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(240, 240, 240))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Inactive, QtGui.QPalette.ColorRole.Button, brush)
        brush = QtGui.QBrush(QtGui.QColor(255, 255, 127))
        brush.setStyle(QtCore.Qt.BrushStyle.SolidPattern)
        palette.setBrush(QtGui.QPalette.ColorGroup.Disabled, QtGui.QPalette.ColorRole.Button, brush)
        self.pushSalir.setPalette(palette)
        self.pushSalir.setCursor(QtGui.QCursor(QtCore.Qt.CursorShape.PointingHandCursor))
        self.pushSalir.setObjectName("pushSalir")
        self.textEdit_texto = QtWidgets.QTextEdit(self.frame_7)
        self.textEdit_texto.setGeometry(QtCore.QRect(30, 20, 381, 111))
        self.textEdit_texto.setReadOnly(True)
        self.textEdit_texto.setObjectName("textEdit_texto")
        self.textEdit_respuesta = QtWidgets.QTextEdit(self.frame_7)
        self.textEdit_respuesta.setGeometry(QtCore.QRect(30, 280, 381, 71))
        self.textEdit_respuesta.setReadOnly(True)
        self.textEdit_respuesta.setObjectName("textEdit_respuesta")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 888, 22))
        self.menubar.setObjectName("menubar")
        self.menuMenu = QtWidgets.QMenu(self.menubar)
        self.menuMenu.setObjectName("menuMenu")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)
        self.actionSalir = QtGui.QAction(MainWindow)
        self.actionSalir.setObjectName("actionSalir")
        self.menuMenu.addAction(self.actionSalir)
        self.menubar.addAction(self.menuMenu.menuAction())

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.pushSur.setText(_translate("MainWindow", "Sur"))
        self.pushCentral.setText(_translate("MainWindow", "Centro"))
        self.pushNorte.setText(_translate("MainWindow", "Norte"))
        self.pushOeste.setText(_translate("MainWindow", "Oeste"))
        self.pushEste.setText(_translate("MainWindow", "Este"))
        self.pushJugar.setText(_translate("MainWindow", "Jugar"))
        self.pushSalir.setText(_translate("MainWindow", "Salir de la sala"))
        self.menuMenu.setTitle(_translate("MainWindow", "Menu"))
        self.actionSalir.setText(_translate("MainWindow", "Salir"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_MainWindow()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec())