package controller;

import java.util.Scanner;

class Pet {
    private boolean vivo;
    String nome;
    private int energia;
    private int saciedade;
    private int limpeza;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int diamantes;
    private int idade;
    private int getLimpezaMax;
    
    public int getEnergia(){
        return energia;
        
    }
    public void setEnergia(int energia){
        if (energia > this.energiaMax){
            this.energia = this.energiaMax;
        }else if (energia < 0){
            this.energia = 0;
            this.vivo = false;
        }else{
            this.energia = energia;
        }
    }
    public int getSaciedade(){
        return saciedade;
    }
    public void setSaciedade(int saciedade){
        if (saciedade > this.saciedadeMax){
            this.saciedade = this.saciedadeMax;
        }else if (saciedade < 0){
            this.saciedade = 0;
            this.vivo = false;
        }else{
            this.saciedade = saciedade;
        }
    }
    public int getLimpeza(){
        return limpeza;
        
    }
    public void setLimpeza(int limpeza){
        if (limpeza > this.limpezaMax){
            this.limpeza = this.limpezaMax;
        }else if (limpeza < 0){
            this.limpeza = 0;
            this.vivo = false;
        }else{
            this.limpeza = limpeza;
        }
    }
    public int getEnergiaMax(){
        return energiaMax;
    }
    public int getLimpezaMax(){
        return limpezaMax;
    }
    
    public boolean testVivo(){
        if (this.vivo)
            return true;
        System.out.println("falha: Seu pet está morto!");
        return false;
    }
        
    public void jogar(){
        if (!this.testVivo())
            return;
        this.setEnergia(this.getEnergia()-2);
        this.setSaciedade(this.getSaciedade()-1);
        this.setLimpeza(this.getLimpeza()-3);
        this.diamantes += 1;
        this.idade += 1;
    }
    
    public void comer(){
        if (!this.testVivo())
            return;
        this.setEnergia(this.getEnergia()-1);
        this.setSaciedade(this.getSaciedade()+4);
        this.setLimpeza(this.getLimpeza()-2);
        this.idade += 1;
    }
    
    public void dormir(){
        if (!this.testVivo())
            return;
        if (this.energiaMax - this.energia < 5){
            System.out.println("falha: Pet não está com sono!");
            return;
        }
        this.idade += this.energiaMax - this.energia;
        this.setEnergia(this.getEnergiaMax());
    }
    
    public void tomar_banho(){
        if (!this.testVivo())
            return;
        this.setEnergia(this.getEnergia()-3);
        this.setSaciedade(this.getSaciedade()-1);
        this.setLimpeza(this.getLimpezaMax);
        this.idade += 2;
    }
    
    public Pet(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.saciedade = saciedade;
        this.limpeza = limpeza;
        this.energiaMax = energia;
        this.saciedadeMax = saciedade;
        this.limpezaMax = limpeza;
        this.diamantes = 0;
        this.idade = 0;
        this.vivo = true;
       }
    
    @Override
    public String toString(){
        return "[ " + this.nome + " ]" + 
                " E: " + this.energia + "/" + this.energiaMax + 
                " S: " + this.saciedade + "/" + this.saciedadeMax + 
                " L: " + this.limpeza + "/" + this.limpezaMax +
                " I: " + this.idade +
                " D: " + this.diamantes;
    }
}
    public class Controller{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Pet pet = new Pet("",0,0,0);
        
        while(true){
            String line = scan.nextLine();
            String[]ui;
            ui = line.split(" ");
            if (ui[0].equals("fim")){
                break;
            }else if(ui[0].equals("inicio")){
                pet = new Pet(ui[1],
                Integer.parseInt(ui[2]), 
                Integer.parseInt(ui[3]), 
                Integer.parseInt(ui[4]));
            }else if (ui[0].equals("jogar")){
                pet.jogar();
            }else if (ui[0].equals("comer")){
                pet.comer();
            }else if (ui[0].equals("dormir")){
                pet.dormir();
            }else if (ui[0].equals("mostrar")){
                System.out.println(pet);
            }else{
                System.out.println("Falha: comando inválido!");
            }
        }
    }
}    