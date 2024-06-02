package Controllers;

import Entidades.Pedidos;
import Entidades.Productos;
import UtilidadesEntidades.HibernateUtil;
import UtilidadesEntidades.Mail;
import UtilidadesEntidades.PdfGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PedidosController extends GenericController {

    public Label precioPizza;
    public Label precioHamburguesa;
    public Label precioCola;
    public Label precioCesar;
    public Label precioPollo;
    public Label precioAgua;
    public Label precioCoctel;
    public Label precioBacon;
    public ListView<String> Pedido;
    public Label totalLabel;
    private double total = 0.0;

    private double pizzaF;
    private double hamburguesaF;
    private double colaF;
    private double cesarF;
    private double polloF;
    private double aguaF;
    private double coctelF;
    private double baconF;

    @FXML
    private Spinner<Integer> pizza;
    @FXML
    private Spinner<Integer> hamburguesa;
    @FXML
    private Spinner<Integer> cola;
    @FXML
    private Spinner<Integer> cesar;
    @FXML
    private Spinner<Integer> pollo;
    @FXML
    private Spinner<Integer> agua;
    @FXML
    private Spinner<Integer> coctel;
    @FXML
    private Spinner<Integer> bacon;

    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private ImageView imageView8;

    private void convertirPrecios() {
        if (precioPizza != null) {
            String pizzat = precioPizza.getText();
            pizzaF = Double.parseDouble(pizzat.substring(0, pizzat.length() - 1));
        }
        if (precioHamburguesa != null) {
            String hamburguesat = precioHamburguesa.getText();
            hamburguesaF = Double.parseDouble(hamburguesat.substring(0, hamburguesat.length() - 1));
        }
        if (precioCola != null) {
            String colat = precioCola.getText();
            colaF = Double.parseDouble(colat.substring(0, colat.length() - 1));
        }
        if (precioCesar != null) {
            String cesart = precioCesar.getText();
            cesarF = Double.parseDouble(cesart.substring(0, cesart.length() - 1));
        }
        if (precioPollo != null) {
            String pollot = precioPollo.getText();
            polloF = Double.parseDouble(pollot.substring(0, pollot.length() - 1));
        }
        if (precioAgua != null) {
            String aguat = precioAgua.getText();
            aguaF = Double.parseDouble(aguat.substring(0, aguat.length() - 1));
        }
        if (precioCoctel != null) {
            String coctelt = precioCoctel.getText();
            coctelF = Double.parseDouble(coctelt.substring(0, coctelt.length() - 1));
        }
        if (precioBacon != null) {
            String bacontelt = precioBacon.getText();
            baconF = Double.parseDouble(bacontelt.substring(0, bacontelt.length() - 1));
        }
    }

    public void initialize() {
        List<Spinner<Integer>> spinners = new ArrayList<>();
        spinners.add(pizza);
        spinners.add(hamburguesa);
        spinners.add(cola);
        spinners.add(cesar);
        spinners.add(pollo);
        spinners.add(agua);
        spinners.add(coctel);
        spinners.add(bacon);


        loadAndSetImage(imageView1, "Fotos/pizza-margarita.jpg");
        loadAndSetImage(imageView2, "Fotos/istockphoto-520215281-612x612.jpg");
        loadAndSetImage(imageView3, "Fotos/cocacola.jpeg");
        loadAndSetImage(imageView4, "Fotos/cesar.jpeg");
        loadAndSetImage(imageView5, "Fotos/pollo.jpeg");
        loadAndSetImage(imageView6, "Fotos/agua.jpeg");
        loadAndSetImage(imageView7, "Fotos/aguavalencia.png");
        loadAndSetImage(imageView8, "Fotos/bacon_cheese_fries.png");


        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
        convertirPrecios();
    }

    private void loadAndSetImage(ImageView imageView, String relativePath) {
        try {
            String normalizedPath = getClass().getResource("/" + relativePath).toExternalForm();
            Image image = new Image(normalizedPath);
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen en la ruta: " + relativePath);
            e.printStackTrace();
        }
    }



    public void handleGenerarRecibo(ActionEvent actionEvent) {
        List<Pedidos> pedido = new ArrayList<>();

        int ultimoIdCliente = HibernateUtil.obtenerUltimoIdCliente();
        int nuevoIdCliente = ultimoIdCliente + 1;

        for (String item : Pedido.getItems()) {
            try {
                String[] partes = item.split(" ");
                if (partes.length < 3) {
                    throw new NumberFormatException("Formato incorrecto del ítem: " + item);
                }

                int cantidad = Integer.parseInt(partes[0]);

                StringBuilder nombreBuilder = new StringBuilder();
                for (int i = 1; i < partes.length - 1; i++) {
                    if (i > 1) {
                        nombreBuilder.append(" ");
                    }
                    nombreBuilder.append(partes[i]);
                }
                String nombre = nombreBuilder.toString();

                String precioStr = partes[partes.length - 1].replace("$", "");
                double precio = Double.parseDouble(precioStr);

                Productos receta = HibernateUtil.obtenerRecetaPorNombre(nombre);
                if (receta != null) {
                    Pedidos nuevoCliente = new Pedidos(nuevoIdCliente, receta, cantidad, precio);
                    pedido.add(nuevoCliente);
                }
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                System.out.println("Error al procesar el ítem: " + item);
                e.printStackTrace();
            }
        }

        String pdfPath = PdfGenerator.generateInvoice(pedido);

        String toEmail = "pablorodrirodri2001@gmail.com";
        String subject = "Factura de pedido";
        String body = "Adjuntamos la factura de su pedido.";

        try {
            Mail mail = new Mail("pruebadam888@gmail.com", "kbtyhsjjrbvppnmi");
            mail.sendEmail(toEmail, subject, body, pdfPath);
            System.out.println("Correo electrónico enviado con éxito a " + toEmail);
        } catch (MessagingException | IOException e) {
            System.out.println("Error al enviar el correo electrónico con la factura adjunta: " + e.getMessage());
            e.printStackTrace();
        }

        boolean exito = HibernateUtil.insertarPedido(pedido);
        if (exito) {
            System.out.println("Pedido guardado exitosamente");
        } else {
            System.out.println("Error al guardar el pedido");
        }
        mostrarPopupExito(toEmail);
    }

    public void handleLimpiarPedido(ActionEvent actionEvent) {
        Pedido.getItems().clear();
        total = 0.0;
        totalLabel.setText(String.format("%.2f$", total));
    }

    public void onAnhadirProdPizza(ActionEvent actionEvent) {
        añadirProducto("Pizza Margarita", pizza.getValue(), pizzaF);
    }

    public void onAnhadirProdHamburguesa(ActionEvent actionEvent) {
        añadirProducto("Hamburguesa con Queso", hamburguesa.getValue(), hamburguesaF);
    }

    public void onAnhadirProdCola(ActionEvent actionEvent) {
        añadirProducto("Refresco de Cola", cola.getValue(), colaF);
    }

    public void onAnhadirProdCesar(ActionEvent actionEvent) {
        añadirProducto("Ensalada César", cesar.getValue(), cesarF);
    }

    public void onAnhadirProdPollo(ActionEvent actionEvent) {
        añadirProducto("Sándwich de Pollo", pollo.getValue(), polloF);
    }

    public void onAnhadirProdAgua(ActionEvent actionEvent) {
        añadirProducto("Agua Mineral", agua.getValue(), aguaF);
    }

    public void onAnhadirProdCoctel(ActionEvent actionEvent) {
        añadirProducto("agua de valencia", coctel.getValue(), coctelF);
    }

    public void onAnhadirProdBacon(ActionEvent actionEvent) {
        añadirProducto("Bacon Cheese Fries", bacon.getValue(), baconF);
    }

    private void añadirProducto(String nombre, int cantidad, double precio) {
        if (cantidad > 0) {
            Productos receta = new Productos(cantidad, precio);
            String item = cantidad + " " + nombre + " " + precio + "$";
            Pedido.getItems().add(item);
            total += cantidad * precio;
            totalLabel.setText(String.format("%.2f$", total));
        }
    }

    private void mostrarPopupExito(String email) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Factura Generada");
        alert.setHeaderText(null);
        alert.setContentText("Factura generada y enviada al siguiente email: " + email);
        alert.showAndWait();
    }
}
