package sistemaconta;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

class MinhaConta {
    String titular;
    String agencia;
    double saldo;
    String data;
    public MinhaConta (String titular, double saldo, String agencia, String data){
        this.titular = titular;
        this.agencia = agencia;
        this.saldo = saldo;
        this.data = data;
		
	}
    void sacar (double valor) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
        }else {
            System.out.println("Saldo insuficiente");
        }
    }
    void depositar (double valor){
        this.saldo = this.saldo + valor;
	}
    void rendimento () {
        this.saldo += this.saldo * 0.1;	
	}
    public String toString () {
        String str;
        str = "Nome: "+this.titular + 
              "\nAgencia: " + this.agencia + 
              "\nData de abertura: " + this.data + 
              "\nSaldo: " + this.saldo;
        return str;
    }
}
public class SistemaConta {
    public static void main(String[] args) {
        MinhaConta c1;
        c1 = new MinhaConta(" ", 0, " ", " ");
        Scanner scan  = new Scanner (System.in);
        while (true) {
            String line = scan.nextLine();
            String [] ui = line.split(" ");
            if (ui[0].equals("fim")) {
                break;
            }else if (ui[0].equals ("sacar")) {
                c1.sacar( Double.parseDouble(ui[1]));
            }else if (ui[0].equals("depositar")) {
                c1.depositar(Double.parseDouble(ui[1]));
            }else if (ui [0].equals("rendimento")) {
                c1.rendimento();
            }else if (ui [0].equals ("mostrar")) {
                System.out.println(c1);
            }else if (ui [0].equals ("iniciar")) {
                c1.titular = (ui[1]);
                c1.saldo = (Double.parseDouble(ui[2]));
                c1.agencia = (ui [3]);
                c1.data = (ui[4]);
            }
        }
    }
}
