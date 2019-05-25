
package topique;

import java.util.ArrayList;
import java.util.Scanner;

class Passageiro{
    String nome;
    int idade;
    
    public Passageiro(String nome, int idade){
        this.nome = nome;
        this.idade = idade;    
    }
    
    @Override
    public String toString(){
        String str;
        return str = this.nome + ":" + this.idade;
}

}

class Topique {
    ArrayList<Passageiro> cadeiras;
    int lotacaoMax;
    int preferencial;
    public Topique(int lotacaoMax, int preferencial){
        this.lotacaoMax = lotacaoMax;
        cadeiras = new ArrayList<Passageiro>();
        for(int i = 0; i < this.lotacaoMax; i++){
            this.cadeiras.add(null); 
        }
        this.preferencial = preferencial;    
    }
    private boolean inserirPref(Passageiro pref){
        for (int i = 0; i < this.preferencial; i++){
            if (this.cadeiras.get(i) == null ){
                this.cadeiras.set(i, pref);
                return true;
            }
        }
        return false;
    }
    private boolean inserirComum(Passageiro comum){
        for (int i = this.preferencial; i < this.cadeiras.size(); i++){
            if (this.cadeiras.get(i)== null){
                this.cadeiras.set(i,comum);
                return true;
            }
        }
        return false;
    }
    
    public boolean inserir(Passageiro p){
        if (p.idade >= 60){
            if(this.inserirPref(p)){
                return true;
            }else if (this.inserirComum(p)){
                return true;
            }else{
                System.out.println("Topique lotada!");
            }
            return false;    
        }else if (this.inserirComum(p)){
            return true;
        }else if (this.inserirPref(p)){
            return true;
        }else{
            System.out.println("Topique lotada!");
        }
        return false;
    }
            
    public boolean remover(String nome){
        for (int i = 0; i < cadeiras.size(); i++){
            if (cadeiras.get(i) != null){
                if (cadeiras.get(i).nome.equals(nome)){
                    cadeiras.set(i, null);
                    return true;
                }else{
                    System.out.println("Passageiro não encontrado!");
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        String str="[ ";
        for (int i =0; i < this.cadeiras.size(); i++){
            if (i < this.preferencial){
                str += " @"; 
            }else {
                str += " =";
            }
            
            if (this.cadeiras.get(i) != null){
                str += this.cadeiras.get(i).toString();
            }
        }
        return str += " ]";
    }
}
       


public class Sistema{
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       Topique top = new Topique(0,0);
            
       while(true){
            String line = scan.nextLine();
            String[]ui;
            ui = line.split(" ");
            if (ui[0].equals("fim")){
                break;
            }
            else if (ui[0].equals("inicio")){
                top = new Topique(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
            }
            else if (ui[0].equals("mostrar")){
                System.out.println(top);
            }
            else if (ui[0].equals("inserir")){
                Passageiro pass = new Passageiro(ui[1], Integer.parseInt(ui[2]));
                top.inserir(pass);
            }
            else if (ui[0].equals("remover")){
                top.remover(ui[1]);
            }
            else{
                System.out.println("Opção inválida!");
            }
            
    }
  }
}

