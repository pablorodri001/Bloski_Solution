package UtilidadesEntidades;

import Entidades.Clientes;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.util.List;

public class PdfGenerator {

    public static String generateInvoice(List<Clientes> pedido) {
        String dest = "invoice.pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Factura"));
            document.add(new Paragraph("------------"));

            Table table = new Table(3);
            table.addCell("Cantidad");
            table.addCell("Producto");
            table.addCell("Precio");

            for (Clientes cliente : pedido) {
                table.addCell(String.valueOf(cliente.getCantidad()));
                table.addCell(cliente.getReceta().getNombre());
                table.addCell(String.valueOf(cliente.getPrecio()) + "$");
            }

            document.add(table);
            document.add(new Paragraph("------------"));
            double total = pedido.stream().mapToDouble(c -> c.getCantidad() * c.getPrecio()).sum();
            document.add(new Paragraph("Total: " + total + "$"));

            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
