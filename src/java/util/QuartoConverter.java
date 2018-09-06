/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Quarto;

/**
 *
 * @author 1511 IRON
 */
@FacesConverter(value = "quartoConverter")
public class QuartoConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String tipo;
        Quarto temp = null;
        Dao<Quarto> dao = new Dao(Quarto.class);
        try {
            tipo = value;
            temp = dao.buscarPorTipoQuarto(tipo);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um Quarto"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Quarto){
            Quarto v = (Quarto)obj;
            return v.getTipo();
        }
        return "";
}

    
}
