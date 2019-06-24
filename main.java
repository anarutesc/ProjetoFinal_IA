

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class main {
    //Os valores de alguns alimentos já foram inseridos diretamente no banco, mas segue abaixo exemplo de inserção:
//    String url = "jdbc:mysql://localhost/alimentos";
//    String usuario = "root";
//    String senha = "computa";
    public static void main(String[] args) {
        
        //Criacao da tabela de Alimentos
        TabelaAlimentos ta = new TabelaAlimentos();
        
        //Cadastro dos alimentos referentes à refeicao almoco
        //       ----------- Carboidratos ------------
        Alimento arroz = new Alimento("arroz integral",66,"carboidratos");
        ta.addAlimento(arroz);
        Alimento mandioca = new Alimento("mandioca",159,"carboidratos");
        ta.addAlimento(mandioca);
        Alimento macarrao = new Alimento("macarrao integral",111,"carboidratos");
        ta.addAlimento(macarrao);
        Alimento polenta = new Alimento("polenta",44,"carboidratos");
        ta.addAlimento(polenta);
        Alimento batata = new Alimento("batata doce",86,"carboidratos");
        ta.addAlimento(batata);
        
        //       ----------- Proteínas ------------
        Alimento carne = new Alimento("carne bovina",192,"proteinas");
        ta.addAlimento(carne);
        Alimento frango = new Alimento("file de frango",101,"proteinas");
        ta.addAlimento(frango);
        Alimento peixe = new Alimento("file de peixe",128,"proteinas");
        ta.addAlimento(peixe);
        
        //       ----------- Saladas ------------
        Alimento alface = new Alimento("alface",4,"saladas");
        ta.addAlimento(alface);
        Alimento escarola = new Alimento("escarola",17,"saladas");
        ta.addAlimento(escarola);
        Alimento agriao = new Alimento("agrião",13,"saladas");
        ta.addAlimento(agriao);
        Alimento rucula = new Alimento("rúcula",25,"saladas");
        ta.addAlimento(rucula);
        Alimento coentro = new Alimento("coentro",23,"saladas");
        ta.addAlimento(coentro);
        
        //       ----------- Legumes ------------
        Alimento cenoura = new Alimento("cenoura",41,"legumes");
        ta.addAlimento(cenoura);
        Alimento rabanete = new Alimento("rabanete",19,"legumes");
        ta.addAlimento(rabanete);
        Alimento beterraba = new Alimento("beterraba",43,"legumes");
        ta.addAlimento(beterraba);
        Alimento abobora = new Alimento("abóbora cozida",40,"legumes");
        ta.addAlimento(abobora);
        Alimento milho = new Alimento("milho",69,"legumes");
        ta.addAlimento(milho);
        
        //       ----------- Frutas ------------
        Alimento morango = new Alimento("morango",45,"frutas");
        ta.addAlimento(morango);
        Alimento banana = new Alimento("banana",87,"frutas");
        ta.addAlimento(banana);
        Alimento maca = new Alimento("maçã",81,"frutas");
        ta.addAlimento(maca);
        Alimento kiwi = new Alimento("kiwi",46,"frutas");
        ta.addAlimento(kiwi);
        Alimento melancia = new Alimento("melancia",24,"frutas");
        ta.addAlimento(melancia);
        Alimento mamao = new Alimento("mamão",85,"frutas");
        ta.addAlimento(mamao);
        
        //       ----------- Ferro ------------
        Alimento espinafre = new Alimento("espinafre",23,"ferro");
        ta.addAlimento(espinafre);
        Alimento brocolis = new Alimento("brócolis",34,"ferro");
        ta.addAlimento(brocolis);
        Alimento feijao = new Alimento("feijão carioca",79,"ferro");
        ta.addAlimento(feijao);
        Alimento couve = new Alimento("couve",63,"ferro");
        ta.addAlimento(couve);
        
        //Configuração dos dados pessoais e médicos do paciente
        Esporte e = new Esporte("natacao", 350);
        Paciente p = new Paciente(701299, "ana");
        p.setDadosMedicos(68.6, 1.65, e, 1);
        
        Dieta dieta = new Dieta(p, ta);
        Refeicao r = dieta.SimulatedAnnealing();
        System.out.println("--------- Almoço: --------");
        for(int i = 0; i< r.getR().size();i++){
            System.out.println(r.getR().get(i).getTipo() + ": " + r.getR().get(i).getNome());
        }
        System.out.println("Calorias ingeridas: " + r.caloriasTotais());
    }
}
