/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Cliente;
import modelo.Quarto;
import util.JpaUtil;

/**
 * Classe genérica para persistir objetos.
 */
public class Dao<T> implements Serializable {

    private final Class<T> classe;
    EntityManager manager;

    public Dao(Class<T> classe) {
        this.classe = classe;
    }

    public T alterar(T objeto) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        objeto = manager.merge(objeto);
        manager.getTransaction().commit();
        manager.close();
        return objeto;
    }

    public T buscarPorCodigo(Object id) {
        T objeto;
        manager = JpaUtil.getEntityManager();
        objeto = manager.find(classe, id);
        manager.close();
        return objeto;
    }

    public void excluir(Integer id) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        T temp = manager.find(classe, id);
        manager.remove(temp);
        tx.commit();
        manager.close();
    }

    public void inserir(T objeto) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();
        return;
    }

    public List<T> listarTodos() {
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

    public Quarto buscarPorTipoQuarto(String tipo) {
        Quarto temp = new Quarto();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT v FROM Quarto v WHERE v.tipo = :p";
        TypedQuery<Quarto> query = manager.createQuery(sql, Quarto.class);
        query.setParameter("p", tipo);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

    public Quarto buscarPorTamanhoQuarto(String tamanho) {
        Quarto temp = new Quarto();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT v FROM Quarto v WHERE v.tamanho = :p";
        TypedQuery<Quarto> query = manager.createQuery(sql, Quarto.class);
        query.setParameter("p", tamanho);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
    
    public Cliente buscarPorNomeCliente(String nome) {
        Cliente temp = new Cliente();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT u FROM Cliente u WHERE u.nome = :nome";
        TypedQuery<Cliente> query = manager.createQuery(sql, Cliente.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
}
