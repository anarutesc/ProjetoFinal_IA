
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class TabelaAlimentos {
    private int nCarb = 0, nProt = 0, nFrutas = 0, nLeg = 0, nSalada = 0, nFerro = 0;
    private ArrayList<Alimento> lista_carb, lista_prot, lista_fruta, lista_leg, lista_salada, lista_ferro;
    
    public TabelaAlimentos(){
        lista_carb = new ArrayList<Alimento>(); 
        lista_prot = new ArrayList<Alimento>();
        lista_fruta = new ArrayList<Alimento>();
        lista_leg = new ArrayList<Alimento>();
        lista_salada = new ArrayList<Alimento>();
        lista_ferro = new ArrayList<Alimento>();
    }
    
    public void addAlimento(Alimento a){
        if(a.getTipo()=="carboidratos"){
            nCarb++;
            lista_carb.add(a);
        }else if(a.getTipo()=="proteinas"){
            nProt++;
            lista_prot.add(a);
        }else if(a.getTipo()=="frutas"){
            nFrutas++;
            lista_fruta.add(a);
        }else if(a.getTipo()=="ferro"){
            nFerro++;
            lista_ferro.add(a);
        }else if(a.getTipo()=="saladas"){
            nSalada++;
            lista_salada.add(a);
        }else if(a.getTipo()=="legumes"){
            nLeg++;
            lista_leg.add(a);
        }
        
    }
    
    public void removeAlimento(Alimento a){
        if(a.getTipo()=="carboidrato"){
            nCarb--;
            lista_carb.remove(a);
        }else if(a.getTipo()=="proteina"){
            nProt--;
            lista_prot.remove(a);
        }else if(a.getTipo()=="fruta"){
            nFrutas--;
            lista_fruta.remove(a);
        }else if(a.getTipo()=="ferro"){
            nFerro--;
            lista_ferro.remove(a);
        }else if(a.getTipo()=="salada"){
            nSalada--;
            lista_salada.remove(a);
        }else if(a.getTipo()=="legume"){
            nLeg--;
            lista_leg.remove(a);
        }
    }

    public int nAlimentos(){
        return nCarb + nFerro + nFrutas + nLeg + nProt + nSalada;
    }
   
    public int getnCarb() {
        return nCarb;
    }

    public int getnProt() {
        return nProt;
    }

    public int getnFrutas() {
        return nFrutas;
    }

    public int getnLeg() {
        return nLeg;
    }

    public int getnSalada() {
        return nSalada;
    }

    public int getnFerro() {
        return nFerro;
    }

    public ArrayList<Alimento> getLista_carb() {
        return lista_carb;
    }

    public ArrayList<Alimento> getLista_prot() {
        return lista_prot;
    }

    public ArrayList<Alimento> getLista_fruta() {
        return lista_fruta;
    }

    public ArrayList<Alimento> getLista_leg() {
        return lista_leg;
    }

    public ArrayList<Alimento> getLista_salada() {
        return lista_salada;
    }

    public ArrayList<Alimento> getLista_ferro() {
        return lista_ferro;
    }
    
    
}
