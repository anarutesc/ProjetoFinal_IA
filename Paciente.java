/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ana_r
 */
public class Paciente {
    private int cpf;
    private String nome;
    private double peso;
    private double altura;
    private int calorias;
    private Esporte esporte;
    private double horas_esporte;
    
    //Dados pessoais: cpf e nome
    //Dados médicos: peso, altura, se pratica esporte (e qual) ou não
    public Paciente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    //Dados médicos: peso, altura, se pratica esporte (e qual) ou não
    public void setDadosMedicos(double peso, double altura, Esporte esporte, double horas_esporte){
        this.peso = peso;
        this.altura = altura;
        this.esporte = esporte;
        this.horas_esporte = horas_esporte;
        imc();
    }
    
    private void imc(){
        //De acordo com o imc, decide se o paciente deverá emagrecer, manter o peso ou engordar.
        double imc = peso/(altura*altura);
        if(imc < 18.5){
            calorias = (int)peso*30;
        }else if(imc >= 18.5 && imc < 25){
            calorias = (int)peso*25;
        }else{
            calorias = (int)peso*20;
        }
    }
    
    public int funcao(){
        if(esporte == null){
            return calorias;
        }else{
            return (int)(calorias + esporte.getCalorias()*horas_esporte);
        }
    }
    
    
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    
    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public double getHoras_esporte() {
        return horas_esporte;
    }

    public void setHoras_esporte(double horas_esporte) {
        this.horas_esporte = horas_esporte;
    }
        
}
