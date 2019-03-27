package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class reporte extends Dao {

    public void crearCarpeta() {
        File repo = new File("C:\\java");
        if (!repo.exists()) {
            repo.mkdir();
        }
    }

    public void importarDatos() throws Exception {
        crearCarpeta();
        this.Conectar();
        try {
            String sql = "select * from temp_ubicacion";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);

            String filename = "C:\\java\\demo2.xls";

            WritableWorkbook workbook = Workbook.createWorkbook(new File(filename));

            WritableFont fuente1 = new WritableFont(WritableFont.TAHOMA, 11);
            fuente1.setColour(Colour.BLACK);

            WritableFont fuente2 = new WritableFont(WritableFont.TAHOMA, 11);
            fuente2.setColour(Colour.BLACK);
            fuente2.setBoldStyle(WritableFont.BOLD);
            
            WritableFont fuente3 = new WritableFont(WritableFont.TAHOMA, 11);
            fuente3.setColour(Colour.WHITE);
            fuente3.setBoldStyle(WritableFont.BOLD);

            WritableSheet ws1 = workbook.createSheet("mySheet1", 0);

            WritableCellFormat cellFormat1 = new WritableCellFormat(fuente2);

            cellFormat1.setAlignment(Alignment.CENTRE);
            cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormat1.setBackground(Colour.AQUA);

            WritableCellFormat cellFormat2 = new WritableCellFormat(fuente1);

            cellFormat2.setAlignment(jxl.format.Alignment.CENTRE);
            cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat2.setWrap(true);
            cellFormat2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.HAIR,
                    jxl.format.Colour.BLACK);
            
            WritableCellFormat cellFormat3 = new WritableCellFormat(fuente3);

            cellFormat3.setAlignment(Alignment.JUSTIFY);
            cellFormat3.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat3.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormat3.setBackground(Colour.DARK_BLUE);

            ws1.mergeCells(0, 1, 1, 1);
            Label linea1 = new Label(0, 1, "Departamento:", cellFormat3);
            ws1.addCell(linea1);
            
            ws1.setColumnView(2, 23);
            ws1.addCell(new Label(2, 1, "Cusco", cellFormat2));
            
            ws1.setColumnView(3, 82);
            ws1.addCell(new Label(3, 1, "Reporte de Ubicaciones 2018", cellFormat2));
            
            ws1.mergeCells(0, 3, 1, 3);
            Label linea2 = new Label(0, 3, "Fecha:", cellFormat3);
            ws1.addCell(linea2);
            
            ws1.setColumnView(2, 23);
            ws1.addCell(new Label(2, 3, new SimpleDateFormat("dd/MM/YYYY hh:mm").format(new java.util.Date()), cellFormat2));

            ws1.mergeCells(0, 5, 1, 5);
            Label linea3 = new Label(0, 5, "Total Registros:", cellFormat3);
            ws1.addCell(linea3);
            
            ws1.setColumnView(2, 23);
            ws1.addCell(new Label(2, 5, "20", cellFormat2));
            
            ws1.setColumnView(0, 6);
            ws1.addCell(new Label(0, 7, "ID", cellFormat1));

            ws1.setColumnView(1, 12);
            ws1.addCell(new Label(1, 7, "Codigo", cellFormat1));

            ws1.setColumnView(2, 23);
            ws1.addCell(new Label(2, 7, "Ubicación", cellFormat1));

            ws1.setColumnView(3, 82);
            ws1.addCell(new Label(3, 7, "Dirección", cellFormat1));

            ws1.setColumnView(4, 10);
            ws1.addCell(new Label(4, 7, "Latitud", cellFormat1));

            ws1.setColumnView(5, 10);
            ws1.addCell(new Label(5, 7, "Longitud", cellFormat1));

            ws1.setColumnView(6, 15);
            ws1.addCell(new Label(6, 7, "Dpto", cellFormat1));

            int iRows = 8;
            while ((rs != null) && (rs.next())) {
                ws1.addCell(new Label(0, iRows, rs.getString("id"), cellFormat2));
                ws1.addCell(new Label(1, iRows, rs.getString("codigo"), cellFormat2));
                ws1.addCell(new Label(2, iRows, rs.getString("ubicacion"), cellFormat2));
                ws1.addCell(new Label(3, iRows, rs.getString("direccion"), cellFormat2));
                ws1.addCell(new Label(4, iRows, rs.getString("latitud"), cellFormat2));
                ws1.addCell(new Label(5, iRows, rs.getString("longitud"), cellFormat2));
                ws1.addCell(new Label(6, iRows, rs.getString("dpto"), cellFormat2));
                ++iRows;
            }
            workbook.write();
            workbook.close();
        } catch (IOException | SQLException | WriteException e) {
            throw e;
        }
    }

}
