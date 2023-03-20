listaImpar = []
for i in range(500):
    if (i % 2 != 0):
        listaImpar.append(i)

print(listaImpar)

listaPar = []
for i in range(101):
    listaPar.append(listaImpar[i]-1)

print(listaPar)
