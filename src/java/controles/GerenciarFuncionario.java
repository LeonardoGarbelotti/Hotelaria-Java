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
import modelo.Funcionario;

/**
 *
 * @author 1511 IRON
 */
@ManagedBean (name="usuarioGerenciar")
@ViewScoped
public class GerenciarFuncionario implements Serializable {
    private Dao<Funcionario> dao;
    private List<Funcionario> listaFuncionarios;
    private Funcionario funcionario;
    private Funcionario temp;
    private boolean mostraPopupNovo;
    
    public GerenciarFuncionario(){
        funcionario = new Funcionario();
        dao = new Dao(Funcionario.class);
        listaFuncionarios = dao.listarTodos();
        mostraPopupNovo = false;
        
    }
    
    public void excluirFuncionario(Funcionario f){
        dao.excluir(f.getId());
        listaFuncionarios.remove(f); // remove da List
    }
    
    public void inserirFuncionario(){
        dao.inserir(funcionario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Funcionário cadastrado", null));
        
        funcionario = new Funcionario();
    }
    
    public void preparaEditarFuncionario(Funcionario f){
        temp = f; 
    }
    
    public void alterarFuncionario(){
        dao.alterar(temp);
    }
    
    public void abrirPopupNovo() {
        this.mostraPopupNovo = true;
    }
    
    public void fecharPopupNovo(){
        mostraPopupNovo = false;
    }

    public Dao<Funcionario> getDao() {
        return dao;
    }

    public void setDao(Dao<Funcionario> dao) {
        this.dao = dao;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getTemp() {
        return temp;
    }

    public void setTemp(Funcionario temp) {
        this.temp = temp;
    }

    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }
    
}
