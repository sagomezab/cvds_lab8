
package edu.eci.cvds.servlet.model;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean implements Serializable{

    @Autowired
    ServiceGuess serviceG;
    public ArrayList<Integer> historial;
    private int premio;
    private String estado;
    private Random random;
    private int numeroAdivinar;
    private int numeroIntentos; 
    private int intento;
    private int gift;


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

   @Bean
    public CommandLineRunner currentPrice() throws Exception {
        return args -> {
            serviceG.addConfiguration(new ConfigurationBean("Premio","100000"));
            serviceG.getAllConfiguration().forEach(configutationB -> System.out.println(configutationB));
            gift = Integer.parseInt(serviceG.getConfiguration("Premio").getValor());
            restart();
        };
    }

    public void restart(){
        numeroAdivinar = random.nextInt(100);
        premio = gift;
        numeroIntentos = 0;
    }
    
}
