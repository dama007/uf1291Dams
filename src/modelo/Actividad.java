
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Actividad {
    
    
    private String nombre;    
    private double precio;    
    private int plazas_max;

    
    
    
    public Actividad() {
        this.nombre = "";
    }
    
    
    
    

    public static final String PROP_PLAZAS_MAX = "plazas_max";

    public int getPlazas_max() {
        return plazas_max;
    }

    public void setPlazas_max(int plazas_max) {
        int oldPlazas_max = this.plazas_max;
        this.plazas_max = plazas_max;
        propertyChangeSupport.firePropertyChange(PROP_PLAZAS_MAX, oldPlazas_max, plazas_max);
    }


    public static final String PROP_PRECIO = "precio";

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        double oldPrecio = this.precio;
        this.precio = precio;
        propertyChangeSupport.firePropertyChange(PROP_PRECIO, oldPrecio, precio);
    }


    public static final String PROP_NOMBRE = "nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
