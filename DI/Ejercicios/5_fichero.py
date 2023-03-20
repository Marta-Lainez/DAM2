import PyPDF2 
import string
import re
# creating a pdf file object 
pdfFileObj = open('5_ConstitucionCASTELLANO.pdf', 'rb')
# creating a pdf reader object 
pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
#Número de páginas en el pdf
numPaginas = int(pdfReader.numPages)

listaTexto = []

for i in range(numPaginas):
    # crea un objeto página
    pageObj = pdfReader.getPage(i) 
    # extrae el texto de cada página y lo añade como elemento de la lista listaTexto
    listaTexto.append(pageObj.extractText())

#Creo un String y añado todas las paginas de la constitución que están en la lista listaTexto
stringTexto = ""
for pagina in listaTexto:
    stringTexto += pagina

#Cuenta las palabras del texto
listaPalabras = re.findall(r'\w+', stringTexto)
palabrasTotales = len(listaPalabras)

#Cuenta palabras distintas en el texto
setPalabras = set(listaPalabras)
palabrasDiferentes = len(setPalabras)    

#Cuenta cuántas veces está cada palabra
print("Hay " + str(palabrasTotales)  + " palabras")
print("Hay " + str(palabrasDiferentes) + " palabras distintas\n")

#Calcula cuántas veces está cada palabra diferente en el texto
palabrasDiferentes = len(setPalabras)
print("Top 20 número de veces que está cada palabra en el texto:")
palabrasUsadas = {}
i = 0
for palabra in listaPalabras:
    contador = listaPalabras.count(palabra)
    palabrasUsadas[palabra] = contador
    i += 1
    if(i < 20):
        print(str(palabra) + " " + str(palabrasUsadas[palabra]))



#Calcula la longitus media de las palabras
longitudTotal = 0
for palabra in setPalabras:
    longitudTotal += len(palabra)
longitudMedia = longitudTotal / palabrasDiferentes
print("Longitud media de las palabras: " + str(longitudMedia) + "\n")

#Calcula el porcentaje de cada palabra
palabrasPorcetaje = {}
print("Porcentaje de las top 20 palabras más usadas en el texto:")
i = 0
for palabra in palabrasUsadas:
    porcentaje = palabrasUsadas[palabra] * 100  / palabrasTotales
    palabrasPorcetaje[palabra] = porcentaje
    i += 1
    if(i < 20):
        print(str(palabra) + " " + str(palabrasUsadas[palabra]))

#Cuenta cuántas veces está cada letra del abecedario
abecedario = string.ascii_lowercase
dicts = {}

#Cuenta cuántas veces está cada letra y añade el valor a la lista dicts junto con su letra correspondiente
for letra in abecedario:
    contador = stringTexto.count(letra)
    dicts[letra] = contador

#Ordena la lista dicts por valor decreciente, sacado las letras mas usadas antes
sortedDicts = dict(sorted(dicts.items(), key=lambda item:item[1], reverse=True))
print("Letras usadas por orden decrecente:\n" + str(sortedDicts) + "\n")

#Calcula cuantas letras hay en total
contadorLetras = 0
for palabra in listaPalabras:
    contadorLetras += len(palabra)
#print("Letras usadas en total: " + str(contadorLetras))

#Calcula el porcentaje de cada letra
letrasPorcetaje = {}
print("Porcentaje de las top 20 letras más usadas en el texto:")
i = 0
for letra in sortedDicts:
    porcentaje = sortedDicts[letra] * 100  / contadorLetras
    letrasPorcetaje[letra] = porcentaje
    i += 1
    if(i < 20):
        print(str(letra) + " " + str(sortedDicts[letra]))


#Crea archivo Json
fileJson = open(r"./ConstitucionCASTELLANO.json", "a")
fileJson.writelines(stringTexto)
pdfFileObj.close()


