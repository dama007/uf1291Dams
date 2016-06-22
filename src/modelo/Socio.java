
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Socio {
    
    private int nSocio;    
    private String nombre;    
    private String apellidos;    
    private String sexo;    
    private String pass;    
    private String telefono;

    
    
    
    
    
    public Socio() {
        
        this.nombre = "";
        this.apellidos = "";
        this.sexo = "";
        this.pass = "";
        this.telefono = "";
    }

    
    
    
    
    
    
    public static final String PROP_TELEFONO = "telefono";

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONO, oldTelefono, telefono);
    }


    public static final String PROP_PASS = "pass";

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        String oldPass = this.pass;
        this.pass = pass;
        propertyChangeSupport.firePropertyChange(PROP_PASS, oldPass, pass);
    }


    public static final String PROP_SEXO = "sexo";

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        propertyChangeSupport.firePropertyChange(PROP_SEXO, oldSexo, sexo);
    }

    
    public static final String PROP_APELLIDOS = "apellidos";

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        propertyChangeSupport.firePropertyChange(PROP_APELLIDOS, oldApellidos, apellidos);
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

    public static final String PROP_NSOCIO = "nSocio";

    public int getnSocio() {
        return nSocio;
    }

    public void setnSocio(int nSocio) {
        int oldnSocio = this.nSocio;
        this.nSocio = nSocio;
        propertyChangeSupport.firePropertyChange(PROP_NSOCIO, oldnSocio, nSocio);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
