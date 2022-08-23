package ortify;

import java.util.ArrayList;

/**
 *
 * @author caemci
 */
public class Artista {

    private String ID;
    private String nombre;
    private ArrayList<Cancion> canciones;

    public Artista(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void agregarCancion(Cancion c) {
        this.canciones.add(c);
    }
    
    public void mostrarDuracionPromedio() {
        int acu = 0;
        int cantCanciones = this.canciones.size();
        for (Cancion cancion : canciones) {
            acu += cancion.getDuracionSeg();
        }
        int prom = (cantCanciones > 0 ? acu / cantCanciones : 0); // Se guarda prom entero.
        mostrarMinSeg(prom);
    }
    
    public boolean esFanDestacado(Usuario u) {
        double mitad = this.canciones.size() / 2.0;
        int i = 0;
        int cantLikes = 0;
        while (i < this.canciones.size() && cantLikes < mitad) {            
            if (this.canciones.get(i).esLiker(u)) {
                cantLikes++;
            }
            i++;
        }
        return cantLikes >= mitad;
    }
    
    private void mostrarMinSeg(int tiempoEnSeg) {
        int min = tiempoEnSeg / 60;
        int seg = tiempoEnSeg % 60;
        System.out.println(min + " minutos, " + seg + " segundos");
    } 

    public Cancion buscarCancion(String IDCancion) {
        int i = 0;
        Cancion can = null;
        while (i < this.canciones.size() && can == null) {
            if (this.canciones.get(i).getID().equals(IDCancion)) {
                can = this.canciones.get(i);
            }
            i++;
        }
        return can;
    }

    @Override
    public String toString() {
        return "Artista{" + "ID=" + ID + ", nombre=" + nombre + ", canciones=" + canciones + '}';
    }
    
    

}
