/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author Miguel
 */
public class Saludo {
    private String hora;
    private String odern;
    private String mensaje;
    private int numColumnas;
    
    public Saludo(){
    }

    public Saludo(String hora, String odern, String mensaje, int numColumnas) {
        this.hora = hora;
        this.odern = odern;
        this.mensaje = mensaje;
        this.numColumnas = numColumnas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOdern() {
        return odern;
    }

    public void setOdern(String odern) {
        this.odern = odern;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }
    
    
}
