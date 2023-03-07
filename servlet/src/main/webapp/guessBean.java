import javax.faces.bean.ManagedBean;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "guessBean")
@ApplicationScoped


public class guessBean {
    private int premio;
    private String estado;
    private Random random;
    private int numeroAdivinar;
    private int numeroIntentos;
    private int intento;


    public guessBean(){
        random = new Random();
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
    }
    public void guess(){
        if(estado.equals("Sin Ganador")){
            if(numeroAdivinar == intento){
                estado = "Gano";
                premio = 100000;
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
