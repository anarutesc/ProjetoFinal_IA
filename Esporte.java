/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class Esporte {
    private String nome;
    private int calorias;
    
    //Um esporte deverá ter nome e calorias gastas por hora
    public Esporte(String nome, int calorias){
        this.nome = nome;
        this.calorias = calorias;        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    
    
}
