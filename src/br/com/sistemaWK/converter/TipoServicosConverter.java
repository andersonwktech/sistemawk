package br.com.sistemaWK.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistemaWK.model.Tiposervicos;

@FacesConverter(value = "TipoServicosConverter")
public class TipoServicosConverter implements Converter{
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unchecked")
		List<Tiposervicos> listaTipoServicos = (List<Tiposervicos>) arg1.getAttributes().get("listaTipoServicos");
	    if (listaTipoServicos != null) {
	        for (Tiposervicos tiposervicos : listaTipoServicos) {
	            if (tiposervicos.getDescricao().equalsIgnoreCase(arg2)) {
	                return tiposervicos;
	            }
	        }
	    } else {
	    	Tiposervicos tiposervicos = new Tiposervicos();
	        return tiposervicos;
	    }
	    Tiposervicos tiposervicos = new Tiposervicos();
	    return tiposervicos;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2.toString().equalsIgnoreCase("0")) {
	        return "Selecione";
	    } else {
	    	Tiposervicos tiposervicos = (Tiposervicos) arg2;
	        return tiposervicos.getDescricao();
	    }
	}

}
