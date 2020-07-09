package br.com.sistemaWK.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistemaWK.model.Consultores;


@FacesConverter(value = "ConsultoresConverter")
public class ConsultoresConverter implements Converter{

	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Consultores> listaConsultores = (List<Consultores>) arg1.getAttributes().get("listaConsultores");
	    if (listaConsultores != null) {
	        for (Consultores consultores : listaConsultores) {
	            if (consultores.getNome().equalsIgnoreCase(arg2)) {
	                return consultores;
	            }
	        }
	    } else {
	    	Consultores consultores = new Consultores();
	        return consultores;
	    }
	    Consultores consultores = new Consultores();
	    return consultores;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Consultores consultores = (Consultores) arg2;
	        return consultores.getNome();
	    }
	}
}
