package Model.bean;

import java.util.Date;


public class Produto {
    
    private int id;
    private String descricao;
    private int qtd;
    private String data;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    } 
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    
    }

    @Override
    public String toString() {
        return getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
