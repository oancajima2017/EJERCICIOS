package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Dao {

    private Connection cn;

    public void Conectar() throws Exception {       //Metodo con los datos de acceso
        try {
            if (cn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://34.73.82.252:3306/ubicaciones?user=prueba&password=Prueba#1234");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
                cn = null;
            }
        }
    }

    public java.sql.Connection getCn() {
        return cn;
    }

    public void setCn(java.sql.Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) throws Exception {  //Validar coneccion
        Dao dao = new Dao();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
    }
}
