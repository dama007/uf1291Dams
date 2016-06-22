
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaActividades {
    
    
   
    public ListaActividades() {
        lista = ObservableCollections.observableList(new ArrayList<Actividad>());

    }
    
    
    
    public void altaActividad(Actividad a) {
        lista.add(a);
    }
    
    private ObservableList<Actividad> lista;

    public static final String PROP_LISTA = "lista";

    public ObservableList<Actividad> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Actividad> lista) {
        ObservableList<Actividad> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
    
    
    
    
    
   

    
}
