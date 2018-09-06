/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Cliente;
import util.JpaUtil;

/**
 *
 * @author 1511 IRON
 */
public class ClienteDao implements Serializable{
    public Cliente autenticar(Cliente cli){
        Cliente temp = null; // administrador retornado na consulta ao banco
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Cliente> query = manager.createQuery("SELECT a FROM Cliente a WHERE a.login = :login AND a.senha = :senha",
                Cliente.class); 
        query.setParameter("login", cli.getLogin());
        query.setParameter("senha", cli.getSenha());
        try{
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ 
            
        }     //aqui poderia haver um tratamento de exceção mais decente
        finally{
            manager.close();
        }        
        return temp;
    }
}
