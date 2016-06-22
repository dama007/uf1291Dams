
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 *
 * @author usu21
 */
public class Inscripcion {
    
    private Socio socio;    
    private Actividad actividad;    
    private Date fecha;

    
    
    public Inscripcion() {
        socio = new Socio();
        actividad = new Actividad();
        fecha = new Date();
    }

    
    
    
    
    public static final String PROP_FECHA = "fecha";

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        propertyChangeSupport.firePropertyChange(PROP_FECHA, oldFecha, fecha);
    }


    public static final String PROP_ACTIVIDAD = "actividad";

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        Actividad oldActividad = this.actividad;
        this.actividad = actividad;
        propertyChangeSupport.firePropertyChange(PROP_ACTIVIDAD, oldActividad, actividad);
    }

    public static final String PROP_SOCIO = "socio";

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        Socio oldSocio = this.socio;
        this.socio = socio;
        propertyChangeSupport.firePropertyChange(PROP_SOCIO, oldSocio, socio);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
