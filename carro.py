class Car:
  def __init__(self):
    self.pas = 0
    self.km = 0
    self.gas = 0
    self.limitePas = 2
    self.limiteGas = 10
    
  def embarcar(self):
    if self.pas < self.limitePas:
      self.pas = self.pas + 1
    else:
      print("limite de passageiros excedido!")


  def tirar(self):
    if self.pas > 0:
      self.pas = self.pas - 1
    else:
      print("nao tem ninguem no carro!")
  
  def abastecer(self,qtd):
    self.gas = self.gas + qtd
    if (self.gas > self.limiteGas):
      self.gas = self.limiteGas
    
  def andar(self,distancia):
    if self.pas == 0:
      print("nao tem ninguem no carro!")
      return

    gas_necessaria = distancia/10
    if (self.gas >= gas_necessaria):
      self.km = self.km + distancia
      self.gasolina = self.gasolina - gas_necessaria

    else:
      print("gasolina insuficiente!")          

  def __str__(self):
    return "passageiros: " + str (self.pas) + ", gasolina: " + str (self.gas) + ", km: " + str (self.km)

carro = Car ()
line = ""

print ("mostrar, embarcar, tirar, abastecer _quantidade, dirigir _distancia, fim")
while (line != "fim"):
  line = input()
  ui = line.split(" ")

  if ui[0] == "end":
    break
  elif ui[0] == "mostrar":
    print (carro)
  elif ui[0] == "embarcar":
    carro.embarcar()
  elif ui[0] == "tirar":
    carro.tirar() 
  elif ui[0] == "abastecer":
    carro.abastecer(int(ui[1]))
  elif ui[0] == "dirigir":
    carro.andar(int(ui[1]))
  else:
    print ("comando invalido!")    

