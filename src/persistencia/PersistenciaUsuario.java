package persistencia;

import entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import util.Conexao;

/**
 *
 * @author Ricardo
 */
public class PersistenciaUsuario extends Conexao implements Persistencia{
    
    private final EntityManager em;
    private Usuario usuario;

    public PersistenciaUsuario() {
        this.em = getEntityManager();
        this.usuario = new Usuario();
    }
    
    
    @Override
    public void inserir(Object object) {
        this.usuario = (Usuario) object;
        try {
           this.em.getTransaction().begin();
           this.em.persist(usuario);
           this.em.getTransaction().commit();

        } catch (Exception ex) {
            this.em.getTransaction().rollback();
            ex.getMessage();
        }

        
    }

    @Override
    public void atualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object listarPorCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
