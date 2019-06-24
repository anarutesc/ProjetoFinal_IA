
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class Dieta {
    TabelaAlimentos ta;
    LinkedList<Refeicao> refeicoes = new LinkedList<Refeicao>();
    Paciente paciente;
    
    public Dieta(Paciente p, TabelaAlimentos ta){
        this.paciente = p;
        this.ta = ta;
    }
    
    public void Dietas() {
        LinkedList<Alimento> dieta;
        Refeicao r;
        for(int c = 0; c < ta.getnCarb(); c++){
           for(int p = 0; p < ta.getnProt(); p++){
                for(int fr = 0; fr < ta.getnFrutas(); fr++){
                    for(int fe = 0; fe < ta.getnFerro(); fe++){
                        for(int l = 0; l < ta.getnLeg(); l++){
                            for(int s = 0; s < ta.getnSalada(); s++){
                                dieta = new LinkedList<Alimento>();
                                dieta.add(ta.getLista_carb().get(c));
                                dieta.add(ta.getLista_prot().get(p));
                                dieta.add(ta.getLista_fruta().get(fr));
                                dieta.add(ta.getLista_ferro().get(fe));
                                dieta.add(ta.getLista_leg().get(l));
                                dieta.add(ta.getLista_salada().get(s));
                                r = new Refeicao(this.paciente, dieta, "almoco");
                                refeicoes.add(r);
                            }
                        }
                    }
                }
            } 
        }
    }
    
    public Refeicao SimulatedAnnealing() {
        Dietas();
        double Ti = 150;
        double alfa = 0.85;
        double Tf = 1;
        int L = 1;
        double T_atual = Ti;

        int valor_max = refeicoes.size();
        Random r = new Random();
        int pos = r.nextInt(valor_max);
        int custo = abs(refeicoes.get(pos).funcao());
        Refeicao refeicao = refeicoes.get(pos);
        
        while (T_atual > Tf) {
            for (int i = 0; i < L; i++) {
                r = new Random();
                pos = r.nextInt(valor_max);
                int custo_aux = abs(refeicoes.get(pos).funcao());

                if (custo_aux < custo) {
                    custo = custo_aux;
                    refeicao = refeicoes.get(pos);
                } else {
                    if (r.nextDouble() < (Math.exp(-(custo_aux - custo) / T_atual))) {
                        custo = custo_aux;
                        refeicao = refeicoes.get(pos);
                    }
                }
            }

            T_atual = T_atual * alfa;
        }
        return refeicao;
    }
}
