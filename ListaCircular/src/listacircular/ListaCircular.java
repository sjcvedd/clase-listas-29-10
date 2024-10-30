
package listacircular;
import java.io.*;
class nodo {
    String dato;
    nodo sig;
    nodo ant;
    nodo(String letra) {
        this.dato=letra;
    }
    nodo(String letra, nodo L) {
        this.dato = letra;
        this.sig = L;
    }
    nodo(String letra, nodo L, nodo ant) {
        this.dato = letra;
        this.sig = L;
        this.ant = ant;
    }
}



class lista{
    nodo L;
    nodo aux;

   void agregar(String letra) {
       if (L==null){
           L=new nodo(letra);
           L.sig=L;
       }else{
           aux=L;
           while(aux.sig!=L)
               aux=aux.sig;
           aux.sig=new nodo(letra, L);
       }
   }
   void agregarPalabra(String palabra) {
       String[] letras = palabra.split("");
       for (int i = 0; i < letras.length; i++) {
            if (L==null){
                L=new nodo(letras[i]);
                L.sig=L;
                L.ant=L;
            }else{
                aux=L;
                while(aux.sig!=L){
                    aux=aux.sig;
                }
                aux.sig=new nodo(letras[i], L, aux);
                L.ant = aux.sig;
            }
       }
   }
    void mostrar (){
        aux=L;
        String dat="";
        while (aux.sig!=L){
            dat=dat+aux.dato;
            aux=aux.sig;
        }
        dat=dat+aux.dato;
        System.out.print("L-->"+dat);
    }
    void mostrarInversa (){
        aux=L.ant;
        nodo ultimo = aux;
        String dat="";
        while (aux.ant!=ultimo){
            dat=dat+aux.dato;
            aux=aux.ant;
        }
        dat=dat+aux.dato;
        System.out.print("L-->"+dat);
    }
    void eliminar(int valor){
        aux=L;
        nodo aux2 = null;
        while(aux.sig!=L || aux.dato != valor){
            aux2=aux;
            aux=aux.sig;
        }
        if (aux.dato == valor){
            if (aux == L && aux.dato == valor) {
                nodo auxL=L;
                L = L.sig;
                while(aux.sig!=auxL)
                    aux=aux.sig;
                aux.sig = L;
            }else{
                aux2.sig = aux.sig;
            }
            System.out.println(valor + " Eliminado de la lista");
        }else{
            System.out.println("valor no encontrado en la lista");
        }
    }


    void buscar(int valor){
        aux=L;
        if(aux!=null){
            while (aux.sig!=L || aux.dato != valor)
                aux= aux.sig;
            if (aux.dato == valor){
                System.out.println(valor + " Existe dentro de la lista");
            }else{
                System.out.println("valor no encontrado en la lista");
            }
        }
    }
}
public class ListaCircular {


    public static void main(String[] args) throws IOException{
        InputStreamReader sr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(sr);
        lista ls=new lista();
        char op='s';
        while (op!='n'){
            System.out.println("ingrese la palabra a registrar");
            ls.agregarPalabra(br.readLine());
            System.out.println("¿algo mas que ingresar? (s/n): ");
            op=br.readLine().charAt(0);
        }
        ls.mostrar();
        ls.mostrarInversa();
        System.out.println();
    }
}
