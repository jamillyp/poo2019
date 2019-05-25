package conta;

import java.util.Scanner;

class ContaPessoal{
    int numConta;
    float saldo;
    float deposito;
    float tarifa;
    float saque;
    String extrato;

    ContaPessoal(int numConta, float saldo) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.deposito = deposito;
        this.tarifa = tarifa;
        this.saque = saque;
        this.extrato = extrato;
    }

    @Override
    public String toString(){
        return  " ******Abertura da conta****** " + 
                "\n Conta: " + this.numConta +
                "\n 1. Deposito realizado: " + this.deposito +
                " / Saldo: " + this.saldo +
                "\n 2. Saque realizado: -" + this.saque +
                " / Saldo: " + this.saldo;
    }  
    
    public boolean depositar(float valor){
        if (this.numConta >= 0){
            this.saldo += valor;
            this.deposito = valor;
            return true;
        }
        return false;
    }
    public boolean sacar(float valor){
        if (this.numConta >= 0){
            if (this.saldo >= valor){
                this.saldo -= valor;
                this.saque = valor;
                return true;
            }else{
                System.out.println("Saldo insuficiente!");
            }
        }
        return false;
    }
    
}

public class Conta {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ContaPessoal conta = new ContaPessoal(0,0);
        
        while(true){
            String line = scan.nextLine();
            String[]ui;
            ui = line.split(" ");
            
            if (ui[0].equals("fim")){
                break;
            }else if (ui[0].equals("inicio")){
                conta = new ContaPessoal(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
            }else if (ui[0].equals("extrato")){
                System.out.println(conta);
            }else if (ui[0].equals("depositar")){
                conta.depositar(Float.parseFloat(ui[1]));
            }else if (ui[0].equals("sacar")){
                conta.sacar(Float.parseFloat(ui[1]));
            }else{
                System.out.println("Opção inválida!");
            }
    }
}
}    
    

