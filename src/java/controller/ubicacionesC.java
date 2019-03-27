package controller;

import DAO.reporte;
import DAO.ubicacionesD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ubicacionesM;

@Named(value = "ubicacionesC")
@SessionScoped
public class ubicacionesC implements Serializable {

    private List<ubicacionesM> ubicaciones;

    public void listarUbicaciones() throws Exception {
        ubicacionesD dao;
        try {
            dao = new ubicacionesD();
            ubicaciones = dao.listarUbicaciones();
        } catch (Exception e) {
            throw e;
        }

    }

    public void desargarExcel() throws Exception {
        reporte dao;
        try {
            dao = new reporte();
            dao.importarDatos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DESCARGA EXITOSA: SE CREO UNA CARPETA(java) EN LA UNIDAD C:", "Se encuentra en el disco C"));

        } catch (Exception e) {
            throw e;
        }
    }

    public List<ubicacionesM> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<ubicacionesM> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

}
