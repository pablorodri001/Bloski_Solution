package Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Turnos")
public class Turnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private int idTurno;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id_restaurante")
    private Restaurante restaurante;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "turno")
    private String turno;

    @Column(name = "descripcion")
    private String descripcion;

    public Turnos() {
    }

    public Turnos(Restaurante restaurante, Date fecha, Integer idEmpleado, String turno, String descripcion) {
        this.restaurante = restaurante;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.turno = turno;
        this.descripcion = descripcion;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

