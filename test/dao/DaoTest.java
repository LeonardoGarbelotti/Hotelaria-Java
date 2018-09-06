package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Administrador;
import modelo.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoTest {

    public DaoTest() {
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
//    public void testInserirAdministrador() {
//        Dao<Administrador> dao = new Dao(Administrador.class);
//        Administrador adm = new Administrador("PICAPAU", "Pica Pau", "1234");
//        dao.inserir(adm);
//    }
    @Test
    public void testListarFuncionario() {
        Dao<Funcionario> dao = new Dao(Funcionario.class);
        List<Funcionario> lista = dao.listarTodos();
        for (Funcionario adm : lista){
            System.out.println(adm.getId() + " - "+adm.getNome());
        }
        
    }
//    @Test
//    public void testInserirUsuario() {
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        Usuario u = new Usuario("João", "Centro Ciências Tecnológicas");
//        dao.inserir(u);
//    }
//    @Test
//    public void testInserirEmprestimo() {
//        Usuario u = new Usuario("Merlin", "CCT");
//        Veiculo v = new Veiculo("Fiat", "Uno", 4);
//        Emprestimo e = new Emprestimo(v, new Date(), new Date(), u);
//        Dao<Emprestimo> dao = new Dao(Emprestimo.class);
//        dao.inserir(e);
//    }

   /* @Test
    public void testAlterarUsuario() {
        Dao<Funcionario> dao = new Dao(Funcionario.class);
        Funcionario u = new Funcionario();
        u.setId(3);
        u = dao.buscarPorCodigo(u.getId());  // tem que buscar para recuperar a referência ao objeto
        System.out.println("Antes: ");
        System.out.println("Nome: " + u.getNome() + "\n\n");

        // alterando o nome
        u.setNome("José Reinaldo Merlin");
        // gravando
        dao.alterar(u);
        u = dao.buscarPorCodigo(u.getId());  // tem que buscar para recuperar a referência ao objeto
    }
*/
}