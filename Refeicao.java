
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class Refeicao {
    private int id;
    private int calorias;
    private String refeicao;
    private LinkedList<Alimento> r = new LinkedList<Alimento>();
    
    public Refeicao(Paciente p, LinkedList<Alimento> r, String refeicao){
        calorias = p.funcao();
        this.r = r;
        if(refeicao == "cafe"){
            calorias = (int)(calorias*0.35);
        }else if(refeicao == "almoco"){
            calorias = (int)(calorias*0.4);
        }else if(refeicao == "janta"){
            calorias = (int)(calorias*0.25);
        }
    }
    
    public int getId(){
        return id;
    }

    public LinkedList<Alimento> getR() {
        return r;
    }
    
    public int funcao(){
        return calorias - caloriasTotais();
    }
    
    public int caloriasTotais(){
        LinkedList<Alimento> aux = r;
        int c = 0;
        for(int i = 0; i < aux.size(); i++){
            c = c + aux.get(i).getCalorias();
        }
        return c;
    }
}
