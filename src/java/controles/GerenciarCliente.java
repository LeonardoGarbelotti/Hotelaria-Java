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
import modelo.Cliente;
import modelo.Funcionario;

/**
 *
 * @author 1511 IRON
 */
@ManagedBean(name = "clienteGerenciar")
@ViewScoped
public class GerenciarCliente implements Serializable {

    private Dao<Cliente> dao;
    private List<Cliente> listaClientes;
    private Cliente cliente;
    private Cliente temp;
    private boolean mostraPopupNovo;

    public GerenciarCliente() {
        cliente = new Cliente();
        dao = new Dao(Cliente.class);
        listaClientes = dao.listarTodos();
        mostraPopupNovo = false;

    }

    public void excluirCliente(Cliente c) {
        dao.excluir(c.getId());
        listaClientes.remove(c); // remove da List
    }

    public void inserirCliente() {
        dao.inserir(cliente);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Cadastro efetuado com sucesso!", null));

        cliente = new Cliente();
    }

    public void preparaEditarCliente(Cliente c) {
        temp = c;
    }

    public void alterarCliente() {
        dao.alterar(temp);
    }

    public void abrirPopupNovo() {
        this.mostraPopupNovo = true;
    }

    public void fecharPopupNovo() {
        mostraPopupNovo = false;
    }

    public Dao<Cliente> getDao() {
        return dao;
    }

    public void setDao(Dao<Cliente> dao) {
        this.dao = dao;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getTemp() {
        return temp;
    }

    public void setTemp(Cliente temp) {
        this.temp = temp;
    }

    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }

}
