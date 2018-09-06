package dao;

import modelo.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José
 */
public class AdministradorDaoTest {
    
    public AdministradorDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testInserir() {
//        Dao<Administrador> dao = new Dao(Administrador.class);
//       Administrador adm = new Administrador("ADMIN", "Administrador", "admin");
//       dao.inserir(adm);
//    }
    
    @Test
    public void testBuscarPorNome(){
        AdministradorDao dao = new AdministradorDao();
        Administrador adm = dao.buscarPorNome("ADMIN");
        System.out.println(adm.getId() + " - " + adm.getLogin());
    }
}