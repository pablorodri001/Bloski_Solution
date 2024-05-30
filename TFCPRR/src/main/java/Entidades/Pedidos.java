package Entidades;

import javax.persistence.*;

@Entity
@Table(name = "Pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "id_producto")
    private int idProducto;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    private Productos receta;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Double precio;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Productos getReceta() {
        return receta;
    }

    public void setReceta(Productos receta) {
        this.receta = receta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Pedidos() {
    }

    public Pedidos(int idCliente, Productos receta, Integer cantidad, Double precio) {
        this.idCliente = idCliente;
        this.idProducto = receta.getIdProducto();
        this.receta = receta;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
