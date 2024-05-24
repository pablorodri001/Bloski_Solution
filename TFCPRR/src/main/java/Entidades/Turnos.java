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
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuario;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "turno")
    private String turno;

    @Column(name = "descripcion")
    private String descripcion;

    public Turnos() {
    }

    public Turnos(Usuarios usuario, Date fecha, String turno, String descripcion) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.turno = turno;
        this.descripcion = descripcion;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
