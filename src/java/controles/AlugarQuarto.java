/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Alugar;
import modelo.Cliente;
import modelo.Quarto;

/**
 *
 * @author 1511 IRON
 */
@ManagedBean(name = "alugarQuarto")
@ViewScoped
public class AlugarQuarto implements Serializable {

    private List<Quarto> quartos;
    private List<Cliente> clientes;
    private Dao<Quarto> daoQuarto;
    private Dao<Cliente> daoCliente;
    private Alugar alugar;
    Dao<Alugar> daoAlugar;

    public AlugarQuarto() {
        daoQuarto = new Dao(Quarto.class);
        daoCliente = new Dao(Cliente.class);
        quartos = daoQuarto.listarTodos();
        clientes = daoCliente.listarTodos();
        daoAlugar = new Dao(Alugar.class);
        alugar = new Alugar();

    }

    public void registrarAluguel() {
        daoAlugar.inserir(alugar);
        alugar = new Alugar();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluguel feito com sucesso", null));
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Dao<Quarto> getDaoQuarto() {
        return daoQuarto;
    }

    public void setDaoQuarto(Dao<Quarto> daoQuarto) {
        this.daoQuarto = daoQuarto;
    }

    public Dao<Cliente> getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(Dao<Cliente> daoCliente) {
        this.daoCliente = daoCliente;
    }

    public Alugar getAlugar() {
        return alugar;
    }

    public void setAlugar(Alugar alugar) {
        this.alugar = alugar;
    }

    public Dao<Alugar> getDaoAlugar() {
        return daoAlugar;
    }

    public void setDaoAlugar(Dao<Alugar> daoAlugar) {
        this.daoAlugar = daoAlugar;
    }
    
    
}
