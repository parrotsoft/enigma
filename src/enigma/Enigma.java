/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class Enigma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        
        int opcion;
        Saludo saludo = new Saludo();
        
        do {
            System.out.println("--- MENU DE OPCIONES ---");
            System.out.println("1. Mensaje de Saludo");
            System.out.println("2. Orden");
            System.out.println("3. Despedida");
            System.out.println("4. Salir");
            opcion = reader.nextInt();
            
            switch(opcion) {
                case 1:
                    saludo = saludo();
                    break;
                case 2:
                    orden(saludo);
                    break;
                case 3:
                    despedida();
                    break;
                case 4:
                    break;
            }
        } while (opcion != 4);

    }
    
    public static Saludo saludo() {
        Scanner reader = new Scanner(System.in);
        Saludo saludo = new Saludo();
        System.out.println("Digite la hora del siguiente mensaje: ");
        saludo.setHora(reader.next());
        System.out.println("Digite la cantidad de columnas: ");
        saludo.setNumColumnas(reader.nextInt());
        System.out.println("Digite el orden de las columnas: ");
        saludo.setOdern(reader.next());
        saludo.setMensaje("HEIL HITLER "+saludo.getHora()+" "+saludo.getNumColumnas()+" C "+saludo.getOdern());
        System.out.println("*** EL SALUDO ES: ***: \n" +saludo.getMensaje());
        
        char matriz[][] = new char[5][4];
        meteMensajeEnMatriz(matriz, saludo.getMensaje().replaceAll(" ", ""));
        
        String mesajeEncriptado = getTextoColumna(matriz, '1')+"\t"+
                getTextoColumna(matriz, '2')+"\t"+getTextoColumna(matriz, '3')+
                "\t"+getTextoColumna(matriz, '4');
        
        System.out.println("*** EL SALUDO ENCRIPTADO ES : ***: \n" +mesajeEncriptado);
        
        return saludo;
    }
    
    public static void orden(Saludo saludo) {
        Scanner reader = new Scanner(System.in);
        String mensaje = "";
        System.out.println("Digite en mensaje a encriptar :");
        mensaje = reader.nextLine();
        mensaje = mensaje.replaceAll(" ", "");
        int numFilas = getNumFilas( (double)mensaje.length() / (double)saludo.getNumColumnas());
        char[][] matrix = new char[numFilas][saludo.getNumColumnas()];
        
        int posicionCadena = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (posicionCadena<mensaje.length()) {
                    matrix[i][j] = mensaje.charAt(posicionCadena);
                    posicionCadena ++;
                }
            }
        }
        System.err.println("*** MENSAJE ENCRIPTADO ***\n" +getTextoEncriptado(saludo, matrix)+"\n");
        
    }
    
    public static void meteMensajeEnMatriz(char matrix[][], String mensaje) {
        int posicionCadena = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (posicionCadena<mensaje.length()) {
                    matrix[i][j] = mensaje.charAt(posicionCadena);
                    posicionCadena ++;
                }
            }
        }
    }
    
    public static void despedida() {
        Scanner reader = new Scanner(System.in);
        String hora = "";
        System.out.println("Digite la hora de envio del mensaje para el siguiente dia: ");
        hora = reader.nextLine();
        String saludo = "HEIL HITLER " + hora;
        
        char matriz[][] = new char[5][4];
        meteMensajeEnMatriz(matriz, saludo.replaceAll(" ", ""));
        
        String mesajeEncriptado = getTextoColumna(matriz, '1')+"\t"+
                getTextoColumna(matriz, '2')+"\t"+getTextoColumna(matriz, '3')+
                "\t"+getTextoColumna(matriz, '4');
        
        System.out.println("*** EL SALUDO ENCRIPTADO ES : ***: \n" +mesajeEncriptado);
        
    }
    
    public static void imprimeMatrix(char matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println("\n");
        }
    }
    
    public static int getNumFilas(double numero) {
        return (int)Math.ceil(numero);
    }
    
    public static String getTextoColumna(char matrix[][], char columna) {
        String cadena = "";
        for (int i = 0; i < matrix.length; i++) {     
            cadena += matrix[i][Character.getNumericValue(columna) - 1];
        }
        return cadena;
    }
    
    public static String getTextoEncriptado(Saludo saludo, char matrix[][]) {
        String cadena = "";
        String orden = saludo.getOdern();
        for(int i = 0; i < orden.length(); i++) {
            cadena += getTextoColumna(matrix, orden.charAt(i)) + "\t";
        }
        return cadena;
    }
    
    
}
