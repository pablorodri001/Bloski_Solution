package UtilidadesEntidades;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Entidades.Usuarios;

public class UsuarioDAO {

    public Usuarios obtenerUsuarioPorNombreYContrasena(String nombreUsuario, String contrasena) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Usuarios WHERE nombreUsuario = :nombreUsuario AND contrasena = :contrasena", Usuarios.class)
                    .setParameter("nombreUsuario", nombreUsuario)
                    .setParameter("contrasena", contrasena)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertarUsuario(Usuarios usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
