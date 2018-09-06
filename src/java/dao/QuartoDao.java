/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Quarto;
import util.JpaUtil;
/**
 *
 * @author 1511 IRON
 */
public class QuartoDao implements Serializable {
    
    public Quarto buscarPorTipo(String tipo) {
        Quarto temp = new Quarto();
        EntityManager manager = JpaUtil.getEntityManager();
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

    public Quarto buscarPorTamanho(String tamanho) {
        Quarto temp = new Quarto();
        EntityManager manager = JpaUtil.getEntityManager();
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
}
