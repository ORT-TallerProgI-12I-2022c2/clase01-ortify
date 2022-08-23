
package ortify;

/**
 *
 * @author caemci
 */
public class Usuario {
    private String nombre;
    private Estado estado;

    public Usuario(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }    
    
    public Estado getEstado() {
        return estado;
    }

    
}
