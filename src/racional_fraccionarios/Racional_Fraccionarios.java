/*
16. Crea  una  clase  Racional  que  permita  trabajar  con  números  racionales  (fracciones).  
Incluye  los siguientes métodos: constructores (por defecto y parametrizado), accedentes suma, resta, 
multiplicación, división, comparaciones, y print().
 */
package racional_fraccionarios;

public class Racional_Fraccionarios {
    
    //atributos
    int numerador;
    int denominador;

    //iniciamos el constructor
    public Racional_Fraccionarios() {
        this.numerador=0;
        this.denominador=1; //el denominador no puede ser cero
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    //iniciamos el constructor con un parámetro                                                            
    public Racional_Fraccionarios(int num) {
            this.numerador = num;
            this.denominador = 1;                                                                                             
    }
    
    //iniciamos el constructor de la clase con dos parámetros                                              
    public Racional_Fraccionarios(int num, int den) {              
            this.numerador = num;
            if(den==0){
                den = 1;
            }
            this.denominador = den;                                                                                           
            simplificar();
    }
    
    //método para simplificar fracciones
    public void simplificar() {
        int n = mcd(); //se calcula el mcd de la fracción
        numerador = numerador / n;
        denominador = denominador / n;
    }
    
    //calculamos del máximo común divisor por el algoritmo de Euclides 
    public int mcd() {
        int u = Math.abs(numerador); //valor absoluto del numerador                                                                                      
        int v = Math.abs(denominador); //valor absoluto del denominador
        if(v == 0){
             return u;
        }
        int residuo;
        while(v != 0){
             residuo = u % v;
             u = v;
             v = residuo;
        }
        return u;
    }
    
    @Override
    public String toString() {
        simplificar();
        return numerador + "/" + denominador;
    }  
    
    //suma
    //sumar fracciones
    public Racional_Fraccionarios sumar(Racional_Fraccionarios f) {
        Racional_Fraccionarios aux = new Racional_Fraccionarios();
        aux.numerador = this.numerador * f.denominador + this.denominador * f.numerador;
        aux.denominador = this.denominador * f.denominador;
        aux.simplificar();  //se simplifica antes de devolverla                                                   
        return aux;
    }
   
    //restar fracciones
    public Racional_Fraccionarios restar(Racional_Fraccionarios f) {
        Racional_Fraccionarios aux = new Racional_Fraccionarios();
        aux.numerador = this.numerador * f.denominador - this.denominador * f.numerador;
        aux.denominador = this.denominador * f.denominador;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
   
    //multiplicar fracciones
    public Racional_Fraccionarios multiplicar(Racional_Fraccionarios f) {
        Racional_Fraccionarios aux = new Racional_Fraccionarios();
        aux.numerador = this.numerador * f.numerador;
        aux.denominador = this.denominador * f.denominador;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //dividir fracciones
    public Racional_Fraccionarios dividir(Racional_Fraccionarios f) {
        Racional_Fraccionarios aux = new Racional_Fraccionarios();
        aux.numerador = this.numerador * f.denominador;
        aux.denominador = this.denominador * f.numerador;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
    
    public static void main(String[] args) {
        // Se crean 4 fracciones
        Racional_Fraccionarios f1 = new Racional_Fraccionarios(3, 8); // Fracción 3/8
        Racional_Fraccionarios f2 = new Racional_Fraccionarios(16, 48); // Fracción 16/48
        Racional_Fraccionarios f3 = new Racional_Fraccionarios(); // Fracción 0/1
        Racional_Fraccionarios f4 = new Racional_Fraccionarios(4,32); // Fracción 4/32
        // operaciones aritméticas con esas fracciones
        Racional_Fraccionarios suma = f1.sumar(f2);
        Racional_Fraccionarios resta = f1.restar(f3);
        Racional_Fraccionarios producto = f1.multiplicar(f4);
        Racional_Fraccionarios cociente = f1.dividir(f2);
        //mostrar resultados
        System.out.println(f1 + " + " + f2 + " = " + suma);
        System.out.println(f1 + " - " + f3 + " = " + resta);
        System.out.println(f1 + " * " + f4 + " = " + producto);
        System.out.println(f1 + " / " + f2 + " = " + cociente);  
    }
    
    
}
