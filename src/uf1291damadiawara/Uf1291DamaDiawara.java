
package uf1291damadiawara;

import dao.SocioDAO;
import vista.Login;

/**
 *
 * @author usu21
 */
public class Uf1291DamaDiawara {

    /**
     * @param args the command line arguments
     * 
     * 
     */
    
    
    public static SocioDAO socioDAO;
    
    public static void main(String[] args) {
        
        
        socioDAO = new SocioDAO();
        
        
        Login log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        
        
        
    }
    
}
