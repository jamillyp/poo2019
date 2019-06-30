package agiota;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Cliente{
    private String nome;
    private float saldo;

    public Cliente (String nome){
        this.nome = nome;
        this.saldo = 0;                   
    }
    public String getNome(){
        return ""+this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
        public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    @Override
    public String toString(){
        return "nome: "+this.nome + "\n saldo: "+this.saldo;
    }
}
class Sistema{
    private float saldo;
    int nextTrId;
    private Map <String,Cliente> cliente;
    private Map <Integer, Transacao> transacoes;
    private int proxChaveCli;
    private int proxChaveTran;
    
    public Sistema(float saldo){
        this.saldo = saldo;
        this.cliente = new HashMap <>();
        this.transacoes = new HashMap <>();
        this.proxChaveTran = 0;    
    }
    public void cadastrarCli(String chaveCli, Cliente c){
        Cliente aux = this.cliente.get(chaveCli);
        if (aux == null){
            this.cliente.put(chaveCli, c);
            System.out.println("Cliente adicionado!");
            
        }else{ 
            System.out.println("Cliente já existe!");
        }
    }
    public float getSaldo(){
        return saldo;
    }
    public void setSaldo(){
        this.saldo = saldo;
    }
    
    public void setCliente(Map <String, Cliente> cliente){
        this.cliente = cliente;
    }
    public Map<Integer, Transacao> getTransacoes(){
        return this.transacoes;
    }
    public void setTransacao(Map <Integer, Transacao> transacoes){
        this.transacoes = transacoes;
    }
    public int getProxChaveCli(){
        return this.proxChaveCli;
    }
    public void setProxChaveCli(int proxChaveCli){
        this.proxChaveCli = proxChaveCli;
    }
    public int getProxChaveTran(){
        return this.proxChaveTran;
    }
    public void setProxChaveTran(int proxChaveTran){
        this.proxChaveTran = proxChaveTran;
    }
    public Cliente retornarCli(String chaveCli){
        Cliente clientes = cliente.get(chaveCli);
        return clientes;
    }
    public void novaTransacao(float valor, String nomeCli){ 
        this.transacoes.put(proxChaveTran, new Transacao(proxChaveTran, valor, nomeCli));
        this.proxChaveTran += 1;        
    }
    public void emprestar(String chaveCliente, float saldo){
        Cliente cliente = retornarCli(chaveCliente);
        novaTransacao(-saldo, chaveCliente);
        this.saldo -= saldo;
        cliente.setSaldo(cliente.getSaldo() + saldo);
        System.out.println("Emprestimo feito com sucesso! Saldo atual: " + this.saldo);
    }
    public void receber(String nomeCli, float saldo){
        Cliente cliente = retornarCli(nomeCli);
        if(cliente.getSaldo() < saldo){
            System.out.println("Falha: Pagamento é maior que a divida!");
            return;
        }
        novaTransacao(saldo, nomeCli);
        cliente.setSaldo(cliente.getSaldo() - saldo);
        this.saldo += saldo;
        System.out.println("Pagamento feito com sucesso! Saldo atual: " + this.saldo);
    }
    public void historico(){
        System.out.println(transacoes.values());
    }
    
    @Override
    public String toString(){
        String str = "";
        for(Cliente cli : this.cliente.values()){
            str += " " + cli.getNome();
        }
        str += "\nsaldo em caixa: " + this.saldo;
        return str;
    }
}
    

class Transacao{
    float valor;
    String idCli;                
    public Transacao(int proxChaveTran, float valor, String idcli){
        this.idCli = idCli;
        this.valor = valor;
    }
    public float getValor(){
        return this.valor;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public String getIdCli(){
        return this.idCli;
    }
    public void setidCli(String idCli){
        this.idCli = idCli;
    }
    public String toString(){
        return "Valor emprestado: " + this.valor;
    }
}

public class Agiota {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scan = new Scanner(System.in);
      
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("sair")){
                break;
            }else if (ui[0].equals("inicio")){
                sistema = new Sistema(Float.parseFloat(ui[1]));
            }else if (ui[0].equals("cadastrar")){
                String nome = ui[1];
                sistema.cadastrarCli(nome, new Cliente(nome));
            }else if (ui[0].equals("mostrar")){
                System.out.println(sistema);
            }else if (ui[0].equals("emprestar")) {
                sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
            }else if (ui[0].equals("receber")) {
                sistema.receber(ui[1], Float.parseFloat(ui[2]));    
            }else if (ui[0].equals("historico")) {
                for (Transacao trans: sistema.getTransacoes().values()){
                    System.out.println(trans);
                }
            }else{
                System.out.println("falha: comando inválido");
            }
        }      
    }
}
