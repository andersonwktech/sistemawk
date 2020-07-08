package br.com.sistemaWK.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistemaWK.model.Servicos;


@FacesConverter(value = "ServicosConverter")
public class ServicosConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Servicos> listaServicos = (List<Servicos>) arg1.getAttributes().get("listaServicos");
	    if (listaServicos != null) {
	        for (Servicos servicos : listaServicos) {
	            if (servicos.getNomeservicos().equalsIgnoreCase(arg2)) {
	                return servicos;
	            }
	        }
	    } else {
	    	Servicos servicos = new Servicos();
	        return servicos;
	    }
	    Servicos servicos = new Servicos();
	    return servicos;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Servicos servicos = (Servicos) arg2;
	        return servicos.getNomeservicos();
	    }
	}
}
