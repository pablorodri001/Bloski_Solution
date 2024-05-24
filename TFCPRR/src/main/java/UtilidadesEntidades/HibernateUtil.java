package UtilidadesEntidades;

import Entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateUtil {
    static  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    static  SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    public static Usuarios obtenerUsuarioPorNombreYContrasena(String nombreUsuario, String contrasena) {
        Session sesion=sf.openSession();
        sesion.beginTransaction();
        return sesion.createQuery("FROM Usuarios WHERE nombreUsuario = :nombreUsuario AND contrasena = :contrasena", Usuarios.class)
                .setParameter("nombreUsuario", nombreUsuario)
                .setParameter("contrasena", contrasena)
                .uniqueResult();

    }
    public static boolean insertarUsuario(Usuarios usuario) {
        Session sesion=sf.openSession();
        sesion.beginTransaction();
       try{
        sesion.save(usuario);
        sesion.getTransaction().commit();
        return true;}
       catch (Exception e) {
           if (sesion.getTransaction() != null) {
               sesion.getTransaction().rollback();
           }
           e.printStackTrace();
           return false;
       }
    }

    public static List<Recetas> rellenarInventario() {
        Session sesion=sf.openSession();
        sesion.beginTransaction();
        List<Recetas> recetasList =new ArrayList<Recetas>();
        List<Recetas> recetas =sesion.createQuery("SELECT j FROM Recetas j", Recetas.class).list();
        recetasList.addAll(recetas);
        System.out.println(recetasList);
        sesion.getTransaction().commit();
        return recetasList;
    }

    public static List<Turnos> rellenarTurno() {
        Session sesion = sf.openSession();
        sesion.beginTransaction();
        List<Turnos> turnoList = new ArrayList<>();
        List<Turnos> turnos = sesion.createQuery("SELECT t FROM Turnos t", Turnos.class).list();
        turnoList.addAll(turnos);
        System.out.println(turnoList);
        sesion.getTransaction().commit();
        return turnoList;

    }
    public static void modificarTurno(int idTurno, Usuarios usuario, Date fecha, String turno, String descripcion) {
        Session sesion = sf.openSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("UPDATE Turnos SET usuario = :usuario, fecha = :fecha, turno = :turno, descripcion = :descripcion WHERE idTurno = :idTurno");
        query.setParameter("usuario", usuario);
        query.setParameter("fecha", fecha);
        query.setParameter("turno", turno);
        query.setParameter("descripcion", descripcion);
        query.setParameter("idTurno", idTurno);
        int filasActualizadas = query.executeUpdate();

        sesion.getTransaction().commit();
        sesion.close();

        if (filasActualizadas > 0) {
            System.out.println("Turno modificado exitosamente");
        } else {
            System.out.println("No se encontró ningún turno con el ID proporcionado");
        }
    }

    public static boolean guardarReceta(Recetas receta) {
        Session sesion=sf.openSession();
        sesion.beginTransaction();
        try{
            sesion.save(receta);
            sesion.getTransaction().commit();
            return true;}
        catch (Exception e) {
            if (sesion.getTransaction() != null) {
                sesion.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }

    }
    public static boolean insertarPedido(List<Clientes> pedido) {
        Session sesion = sf.openSession();
        sesion.beginTransaction();
        try {
            for (Clientes cliente : pedido) {
                sesion.save(cliente);
            }
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (sesion.getTransaction() != null) {
                sesion.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            sesion.close();
        }
    }

    public static Recetas obtenerRecetaPorNombre(String nombre) {
        Session sesion = HibernateUtil.sf.openSession();
        sesion.beginTransaction();
        Recetas receta = null;
        try {
            receta = sesion.createQuery("FROM Recetas WHERE nombre = :nombre", Recetas.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            if (sesion.getTransaction() != null) {
                sesion.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }
        return receta;
    }
    public static int obtenerUltimoIdCliente() {
        try{Session session = sf.openSession();
        session.beginTransaction();
        String hql = "select max(c.idCliente) from Clientes c";
        Integer maxId = session.createQuery(hql, Integer.class).uniqueResult();
        return maxId != null ? maxId : 0;
        }
        catch (Exception e) {
            System.err.println("Error al obtener el último idCliente: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}
