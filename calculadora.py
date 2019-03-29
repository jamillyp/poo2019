class Calculadora:
	def __init__ (self, bateriaMaxima):
		self.bateria = 0
		self.bateriaMaxima = bateriaMaxima


	def recarregar(self, carga):
		self.bateria += carga
		if self.bateria > self.bateriaMaxima:
			self.bateria = self.bateriaMaxima

	def __str__ (self):
		return "bateria = "+ str(self.bateria)+ "/"+ str(self.bateriaMaxima)

	def soma(self, a, b):
		if self.bateria == 0:
			print("carga insuficiente!")
		else:
			print(a+b)
			self.bateria -= 1

	def subtracao(self, a, b):
		if self.bateria == 0:
			print("carga insuficiente!")
		else:
			print(a-b)
			self.bateria -= 1

	def multiplicacao(self, a, b):
		if self.bateria == 0:
			print("carga insuficiente!")
		else:
			print(a*b)
			self.bateria -= 1

	def divisao(self, a, b):
		if self.bateria == 0:
			print("bateria insuficiente")
		else:
			if (a or b) != 0:
		 		print(a/b)
		 		self.bateria -= 1
			else:
		 		print("erro: resultado da divisao e zero!")


minhacalculadora = Calculadora(0)

print("iniciar _cargaMaxima, recarregar _valor, soma, subtracao, multiplicacao, divisao, mostrar ou fim")

while True:
	ui = input().split(" ")

	if ui[0] == "iniciar":
		minhacalculadora = Calculadora(int(ui[1]))
	elif ui[0] == "recarregar":
		minhacalculadora.recarregar(int(ui[1]))
	elif ui[0] == "soma":
		minhacalculadora.soma(int(ui[1]), int(ui[2]))
	elif ui[0] == "subtracao":
		minhacalculadora.subtracao(int(ui[1]), int(ui[2]))
	elif ui[0] == "multiplicacao":
		minhacalculadora.multiplicacao(int(ui[1]), int(ui[2]))
	elif ui[0] == "divisao":
		minhacalculadora.divisao(int(ui[1]), int(ui[2]))
	elif ui[0] == "mostrar":
		print(minhacalculadora)
	elif ui[0] == "fim":
		break
	else:
		print("comando invalido!")