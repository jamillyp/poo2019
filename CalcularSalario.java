
package calcularsalario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario{
    String nome;
    String cargo;
    int max_diarias;
    int qtdDiarias;
    double bonus = 0;
    double salario;
    
    public Funcionario(String nome, int max_diarias){
        this.nome = nome;
        this.max_diarias = max_diarias;   
    }
    
    void calcularSalario(){
        if (this.qtdDiarias  == 1){
            this.bonus += 100;
        }
        else if(this.qtdDiarias == 2){
            this.bonus += 200;
        }
        this.salario += this.bonus;
    }
    
    void setBonus(double x){
        this.bonus += x;
        this.salario += this.bonus;
    }
 
    
    void addDiaria(int qtdDiarias){
        if (qtdDiarias > this.max_diarias){
            this.qtdDiarias = this.max_diarias; 
        }else{
            this.qtdDiarias = qtdDiarias;
        }
        calcularSalario();
    }
        
    public String mostrarFuncionario(){
        String str;
        str = "nome: "+this.nome;
        str+= "\ncargo: "+this.cargo;
        str+= "\nMaxima Diarias: "+ this.max_diarias;
        str+= "\nqtdDiarias: "+ this.qtdDiarias;
        str+= "\nsalario: "+this.salario;
        return str; 
    }
}

final class Professor extends Funcionario{
    char classe;

    public Professor(String nome, char classe) {
        super(nome, 2);
        super.cargo = "Professor";
        this.classe = classe;
        calcularSalario();
    }

    
    @Override
    void calcularSalario() {
        if (this.classe == 'A'){
            this.salario = 3000;
        }else if(this.classe == 'B'){
            this.salario = 5000;
        }else if(this.classe == 'C'){
            this.salario = 7000;
        }else if(this.classe == 'D'){
            this.salario = 9000;
        }else if(this.classe == 'E'){
            this.salario = 11000;
        }if(this.qtdDiarias > 0){
            super.calcularSalario();
        }
    }
}
final class Sta extends Funcionario{
    int nivel;
    
    public Sta(String nome, int nivel) {
        super(nome, 1);
        super.cargo = "Secretario tecnico administrativo";
        this.nivel = nivel;
        calcularSalario();
    }
    void setNivel(int nivel){
        this.nivel = nivel;
    }
    @Override
    void calcularSalario(){
        this.salario = 3000 + 300 * this.nivel;
        if(this.qtdDiarias > 0){
           super.calcularSalario();
        } 
    }
}    
final class Ter extends Funcionario{
    boolean insalubre;
    int horas;
    
    public Ter(String nome, int horas, boolean insalubre) {
        super(nome,0);
        super.cargo = "Terceirizado";
        this.insalubre = insalubre;
        this.horas = horas;
        this.calcularSalario();
    }
    
    @Override
    void calcularSalario(){
        if (this.insalubre == true){
            this.salario = 4 * horas + 500;
        }else{
         this.salario = 4 * horas;   
        }
        super.calcularSalario();
    }
}

public class CalcularSalario {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Funcionario> listaFun = new ArrayList<>();
        
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            
            if (ui[0].equals("addProf")){
                Professor prof = new Professor(ui[1],ui[2].charAt(0));
                if(listaFun.add(prof)){
                    System.out.println("Professor adicionado com sucesso!");
                }
            }else if (ui[0].equals("addSta")){
                Sta sta = new Sta(ui[1],Integer.parseInt(ui[2]));
                if(listaFun.add(sta)){
                  System.out.println("Sta adicionado com sucesso!");   
                }
            }else if (ui[0].equals("addTer")){
                Ter ter = new Ter (ui[1],Integer.parseInt(ui[2]), Boolean.valueOf(ui[3]));
                if(listaFun.add(ter)){
                    System.out.println("Ter adicionado com sucesso!");
                
                }
                
            }else if (ui[0].equals("show")){
                for(Funcionario f: listaFun){
                    if (f.nome.equals(ui[1])){
                        System.out.println(f.mostrarFuncionario());
                    }
                }
            }else if(ui[0].equals("addDiaria")){
                for(Funcionario f: listaFun){
                    if(f.nome.equals(ui[1])){
                        f.addDiaria(Integer.parseInt(ui[2]));
                    }
                }
            }else if(ui[0].equals("setBonus")){
                double x = (Double.parseDouble(ui[1])/listaFun.size());
                System.out.println(x);
                for(Funcionario f: listaFun){
                    f.setBonus(x);
                }
            }
        }
    }  
}
