/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Quarto;

/**
 *
 * @author 1511 IRON
 */
@ManagedBean (name="quartoGerenciar")
@ViewScoped
public class GerenciarQuarto implements Serializable{
    private List<Quarto> listaQuartos;
    private Dao<Quarto> dao;
    
    public GerenciarQuarto(){
        dao = new Dao(Quarto.class);
        listaQuartos = dao.listarTodos();
    }

    public List<Quarto> getListaQuartos() {
        return listaQuartos;
    }

    public void setListaQuartos(List<Quarto> listaQuartos) {
        this.listaQuartos = listaQuartos;
    }

    public Dao<Quarto> getDao() {
        return dao;
    }

    public void setDao(Dao<Quarto> dao) {
        this.dao = dao;
    }
    
    
            
}
