package Controllers;

import Entidades.Clientes;
import Entidades.Recetas;
import UtilidadesEntidades.HibernateUtil;
import UtilidadesEntidades.ImageLoader;
import UtilidadesEntidades.Mail;
import UtilidadesEntidades.PdfGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PedidosController extends GenericController{

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

        File file = new File("src/main/resources/Fotos/pizza-margarita.jpg");
        Image image1 = new Image(file.toURI().toString());
        imageView1.setImage(image1);
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(100);

        File file2 = new File("src/main/resources/Fotos/istockphoto-520215281-612x612.jpg");
        Image image2 = new Image(file2.toURI().toString());
        imageView2.setImage(image2);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);

        File file3 = new File("src/main/resources/Fotos/cocacola.jpeg");
        Image image3 = new Image(file3.toURI().toString());
        imageView3.setImage(image3);
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(100);

        File file4 = new File("src/main/resources/Fotos/cesar.jpeg");
        Image image4 = new Image(file4.toURI().toString());
        imageView4.setImage(image4);
        imageView4.setFitHeight(100);
        imageView4.setFitWidth(100);

        File file5 = new File("src/main/resources/Fotos/pollo.jpeg");
        Image image5 = new Image(file5.toURI().toString());
        imageView5.setImage(image5);
        imageView5.setFitHeight(100);
        imageView5.setFitWidth(100);

        File file6 = new File("src/main/resources/Fotos/agua.jpeg");
        Image image6 = new Image(file6.toURI().toString());
        imageView6.setImage(image6);
        imageView6.setFitHeight(100);
        imageView6.setFitWidth(100);

        File file7 = new File("src/main/resources/Fotos/aguavalencia.png");
        Image image7 = new Image(file7.toURI().toString());
        imageView7.setImage(image7);
        imageView7.setFitHeight(100);
        imageView7.setFitWidth(100);

        File file8 = new File("src/main/resources/Fotos/bacon_cheese_fries.png");
        Image image8 = new Image(file8.toURI().toString());
        imageView8.setImage(image8);
        imageView8.setFitHeight(100);
        imageView8.setFitWidth(100);

        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
        convertirPrecios();
    }

    public void handleGenerarRecibo(ActionEvent actionEvent) {
        List<Clientes> pedido = new ArrayList<>();

        // Obtener el último id de cliente
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

                Recetas receta = HibernateUtil.obtenerRecetaPorNombre(nombre);
                if (receta != null) {
                    // Usar el nuevo id del cliente
                    Clientes nuevoCliente = new Clientes(nuevoIdCliente, receta, cantidad, precio);
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
        añadirProducto("BaconCheeseFries", bacon.getValue(), baconF);
    }

    private void añadirProducto(String nombre, int cantidad, double precio) {
        if (cantidad > 0) {
            Recetas receta = new Recetas(cantidad, precio);
            String item = cantidad + " " + nombre + " " + precio + "$";
            Pedido.getItems().add(item);
            total += cantidad * precio;
            totalLabel.setText(String.format("%.2f$", total));
        }
    }
}
