/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import modelo.Administrador;
/**
 *
 * @author 1511 IRON
 */
public class FiltroAutenticar implements PhaseListener {
    //PAGINAS QUE NAO VAO ESTAR NO FILTRO
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        String pagina = facesContext.getViewRoot().getViewId();
        if (pagina.contains("/index")) {
            return;
        }
        else if(pagina.contains("/form-login")){
            return;
        }
        else if(pagina.contains("/cliente/novoCliente")){
            return;
        }
        
        //USUARIO VOLTA PRA INDEX
        Administrador usuarioLogado = (Administrador) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index?faces-redirect=true");
            facesContext.renderResponse();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {        

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW; 
}
}
