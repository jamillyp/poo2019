
package sistemaempresa;

import java.util.ArrayList;
import java.util.Scanner;

class ControleBonificacao{
    private double totalDeBonificacao = 0;
    
    public void registra(Funcionario funcionario){
        this.totalDeBonificacao += funcionario.getBonificacao();
    }
    public double getTotalDeBonificacao(){
        return this.totalDeBonificacao;
    }
}

class Funcionario{
    protected String nome;
    protected double salario;
    String cargo;
    
    void setNome(String nome){
        this.nome = nome;
    }
    void setSalario(double salario){
        this.salario = salario;
    }
    public double getBonificacao(){
        return this.salario*0.10;
    }
}

class Gerente extends Funcionario{
    protected int senha = 456;
    protected int qtdFunGerenciados;
    
    public boolean autentica(int senha){
        if (senha == this.senha){
            System.out.println("Acesso permitido!");
            return true;
        }else{
            System.out.println("Acesso negado!");
            return false;
        }
    }
    void setSenha(int senha){
        this.senha = senha;
    }
    @Override
    public double getBonificacao(){
        return super.getBonificacao()+1000;
    }
}
class Diretor extends Gerente{
    protected double gratificacao;
    
    public Diretor(){
        this.setGratificacao();
    }
    
    public double getGratificacao(){
        return this.gratificacao;
    }
    void setGratificacao(){
        this.gratificacao = super.getBonificacao()*2;
    }
}

public class SistemaEmpresa {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("iniciar")){
                Funcionario funcionario = new Funcionario();
                funcionario.cargo = ui[1];
                funcionario.salario = Double.parseDouble(ui[2]);
                System.out.println("O cargo eh: " + funcionario.cargo);
                if (funcionario.cargo.equals("gerente")){
                    int senhaUsuario = Integer.parseInt(ui[3]); 
                    if (gerente.autentica(senhaUsuario)){
                        System.out.println("Valor da bonificacao: " + gerente.getBonificacao());
                    }
                }else if (funcionario.cargo.equals("comum")){
                    System.out.println("Valor da bonificacao: " + funcionario.getBonificacao());
                }else if(funcionario.cargo.equals("diretor")){
                    Diretor diretor = new Diretor();
                    int senhaUsuario = Integer.parseInt(ui[3]);
                    if (diretor.autentica(senhaUsuario)){
                        System.out.println("Valor da bonificacao: " + diretor.getBonificacao());
                        System.out.println("Valor da gratificacao: " + diretor.getGratificacao());
                    }
                }
            }else if(ui[3].equals("sair")){
                break;
            }
        }
    }
}
