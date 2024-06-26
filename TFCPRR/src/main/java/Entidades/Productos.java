package Entidades;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante restaurante;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Override
    public String toString() {
        return "Recetas{" +
                "idProducto=" + idProducto +
                ", restaurante=" + restaurante +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

    public Productos(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    public Productos(Integer cantidad, Double precioUnitario) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Productos() {
    }

    public Productos(Restaurante restaurante, String nombre, String descripcion, Integer cantidad, Double precioUnitario) {
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

