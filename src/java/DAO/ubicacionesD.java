
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ubicacionesM;


public class ubicacionesD extends Dao{
    
    public List<ubicacionesM> listarUbicaciones() throws Exception{
        this.Conectar();
        ResultSet rs;
        List<ubicacionesM> lista;
        try {
            String sql = "select * from temp_ubicacion";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            ubicacionesM ubi;
            while (rs.next()) {
                ubi = new ubicacionesM();
                ubi.setId(rs.getInt("id"));
                ubi.setCodigo(rs.getString("codigo"));
                ubi.setUbicacion(rs.getString("ubicacion"));
                ubi.setDireccion(rs.getString("direccion"));
                ubi.setLatitud(rs.getDouble("latitud"));
                ubi.setLongitud(rs.getDouble("longitud"));
                ubi.setDpto(rs.getString("dpto"));
                lista.add(ubi);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
