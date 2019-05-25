package calculador;
import java.util.Scanner;

class Calculador{
  int bateria;
  int bateriaMax;

  public Calculador(int bateria, int bateriaMax){
    this.bateria = bateria;
    this.bateriaMax = bateriaMax;

  }

  public void soma(int a, int b){
    if (this.bateria > 0){
      this.bateria = this.bateria - 1;
      System.out.println(a+b);
    }
    else {
      System.out.println("falha: bateria insuficiente!");
    }
  }

  public void divisao(double a, double b){
    if (this.bateria > 0){
      this.bateria = this.bateria - 1;
      if (b == 0){
        System.out.println("falha: divisao por 0!");
      }
      else{
        System.out.println(a/b);
      }
    }
    else{
      System.out.println("falha: bateria insuficiente!");
      }
  }

  public void recarga(int carga){
    this.bateria += carga;
    if (this.bateria > this.bateriaMax){
      this.bateria = this.bateriaMax;

    }
  }

  @Override
  public String toString(){
    return "bateria: " + this.bateria + "/" + this.bateriaMax;
  }

public class Controller{
  public void main(String[]args){

    Scanner scanner = new Scanner(System.in);
    Calculador calculador = new Calculador(0,0);

    while (true){
      String line = scanner.nextLine();
      String[] ui = line.split(" ");

      if (ui[0].equals("fim")){
        break;
      }
      else if (ui[0].equals("iniciar")){
        calculador = new Calculador(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
      }
      else if (ui[0].equals("mostrar")){
        System.out.println(calculador);
      }
      else if (ui[0].equals("recarregar")){
        calculador.recarga(Integer.parseInt(ui[1]));
      }
      else if (ui[0].equals("soma")){
        calculador.soma(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
      }
      else if (ui[0].equals("divisao")){
        calculador.divisao(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
      }
      else {
        System.out.println("falha: comando invalido!");
      }  
    }
  }
}

}
