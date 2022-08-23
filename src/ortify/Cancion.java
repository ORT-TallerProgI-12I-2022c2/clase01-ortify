package ortify;

import java.util.ArrayList;

/**
 *
 * @author caemci
 */
public class Cancion {
    private String ID;
    private String nombre;
    private int duracionSeg;
    private ArrayList<Usuario> likers;

    public Cancion(String ID, String nombre, int duracionSeg) {
        this.ID = ID;
        this.nombre = nombre;
        this.duracionSeg = duracionSeg;
        this.likers = new ArrayList<>();
    }
    
    public void agregarLiker(Usuario u) {
        this.likers.add(u);
    }

    public boolean esLiker(Usuario u) {
        return this.likers.contains(u);
    }    

    public String getID() {
        return ID;
    }

    public int getDuracionSeg() {
        return duracionSeg;
    }
    
    

    
    
}
