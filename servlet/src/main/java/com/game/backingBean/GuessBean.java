
package com.game.backingBean;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean implements Serializable{
    public ArrayList<Integer> historial;
    private int premio;
    private String estado;
    private Random random;
    private int numeroAdivinar;
    private int numeroIntentos; 
    private int intento;


    public GuessBean(){
        random = new Random();
        historial = new ArrayList<>();
        numeroAdivinar = random.nextInt(100);
        premio = 100000;
        estado = "Sin Ganador";
        numeroIntentos = 0;
    }
    public int getPremio() {
        return premio;
    }
    public String getEstado() {
        return estado;
    }
    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }
    public int getNumeroIntentos(){
        return this.numeroIntentos;
    }
    public int getIntento(){
        return intento;
    }
    public void setPremio(int premio) {
        this.premio = premio;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }
    public void setIntento(int a){
        this.intento = a;
        historial.add(this.intento);
    }

    public ArrayList<Integer> getHistorial(){
        return historial;
    }
    public void setHistorial(ArrayList<Integer> historial) {
        this.historial = historial;
    }

    public void guess(){
        if(estado.equals("Sin Ganador")){
            if(numeroAdivinar == intento){
                estado = "Gano";
            }
            else{
                premio -= 10000;
                estado = "Sin Ganador";
            }
            numeroIntentos++;
        }
   }
    public void restart(){
        numeroAdivinar = random.nextInt(100);
        premio = 100000;
        numeroIntentos = 0;
    }
    
}
