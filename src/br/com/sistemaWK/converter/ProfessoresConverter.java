package br.com.sistemaWK.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistemaWK.model.Professores;


@FacesConverter(value = "ProfessoresConverter")
public class ProfessoresConverter implements Converter{

	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Professores> listaProfessores = (List<Professores>) arg1.getAttributes().get("listaProfessores");
	    if (listaProfessores != null) {
	        for (Professores professores : listaProfessores) {
	            if (professores.getNome().equalsIgnoreCase(arg2)) {
	                return professores;
	            }
	        }
	    } else {
	    	Professores professores = new Professores();
	        return professores;
	    }
	    Professores professores = new Professores();
	    return professores;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Professores professores = (Professores) arg2;
	        return professores.getNome();
	    }
	}
}
