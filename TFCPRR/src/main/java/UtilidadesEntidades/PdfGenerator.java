package UtilidadesEntidades;

import Entidades.Pedidos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PdfGenerator {

    public static String generateInvoice(List<Pedidos> pedido) {
        String dest = "invoice.pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();

            document.add(new Paragraph("Factura"));
            document.add(new Paragraph("------------"));

            PdfPTable table = new PdfPTable(3);
            table.addCell("Cantidad");
            table.addCell("Producto");
            table.addCell("Precio");

            for (Pedidos cliente : pedido) {
                table.addCell(String.valueOf(cliente.getCantidad()));
                table.addCell(cliente.getReceta().getNombre());
                table.addCell(String.valueOf(cliente.getPrecio()) + "$");
            }

            document.add(table);
            document.add(new Paragraph("------------"));
            double total = pedido.stream().mapToDouble(c -> c.getCantidad() * c.getPrecio()).sum();
            document.add(new Paragraph("Total: " + total + "$"));

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return dest;
    }
}
