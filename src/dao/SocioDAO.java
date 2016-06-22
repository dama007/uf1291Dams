
package dao;

import exception.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Actividad;
import modelo.Inscripcion;
import modelo.ListaActividades;
import modelo.Socio;

/**
 *
 * @author usu21
 */
public class SocioDAO {
    
    private Connection conexion;
    
    
    
    public void insertarSocio(Socio socio) throws MyException {
        
        conectar();
        try {
            String insert = "insert into socio values (?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setInt(1, socio.getnSocio());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellidos());
            ps.setString(4, socio.getSexo());
            ps.setString(5, socio.getPass());
            ps.setString(6, socio.getTelefono());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MyException("Error al insertar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }

    }
    
    
    
    public boolean validarSocio(int nSocio, String pass) throws MyException {

        conectar();
        try {
            String query = "select nSocio, pass from socio where nSocio=? and pass=?;";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, nSocio);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            boolean val = false;
            if (rs.next()) {
                val = false;
                return true;
            }
            rs.close();
            ps.close();
            return val;
        } catch (SQLException ex) {
            throw new MyException("Error al validadar: " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }
    
    
    
    
    public ListaActividades selectAllActividades() throws MyException {
      ListaActividades listaActividades = new ListaActividades();
      conectar();
      if (conexion != null) {
          try {
              String query = "select * from actividad";
              Statement st = conexion.createStatement();
              ResultSet rs = st.executeQuery(query);
              while (rs.next()) {
                  Actividad act = new Actividad();
                  act.setNombre(rs.getString("nombre"));
                  act.setPrecio(rs.getDouble("precio"));
                  act.setPlazas_max(rs.getInt("plazas_max"));
                  listaActividades.altaActividad(act);  
              }
              rs.close();
              st.close();
          } catch (SQLException ex) {
              System.out.println("Error en la consulta" + ex.getMessage());
          } finally {
              desconectar();
          }
      }
      return listaActividades;
    }
    
    
    public void insertarInscripcion(Inscripcion i) throws MyException {
        conectar();
            try {
                String insert = "insert into inscripcion values(?,?,?)";
                PreparedStatement ps = conexion.prepareStatement(insert);
                ps.setInt(1, i.getSocio().getnSocio());
                ps.setString(2, i.getActividad().getNombre());
                ps.setDate(3, new java.sql.Date(i.getFecha().getTime()));
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
            } finally {
                desconectar();
    
        }
    }
    
    
   
    
    
    private void conectar() throws MyException {
        try {
            String url = "jdbc:mysql://localhost:3306/dam_gym";
            String user = "root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {

            throw new MyException("Error al conectar " + ex.getLocalizedMessage());
        }

    }

    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
    
}
