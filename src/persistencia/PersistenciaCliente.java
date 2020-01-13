package persistencia;

import entidade.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.Conexao;

/**
 *
 * @author Ricardo
 */
public class PersistenciaCliente extends Conexao implements Persistencia {

    private final EntityManager em;
    private Cliente cliente;

    public PersistenciaCliente() {
        this.em = getEntityManager();
        this.cliente = new Cliente();
    }

    @Override
    public void inserir(Object object) {
        this.cliente = (Cliente) object;
        try {
            this.em.getTransaction().begin();
            this.em.persist(cliente);
            this.em.getTransaction().commit();

        } catch (Exception ex) {
            this.em.getTransaction().rollback();
            ex.getMessage();
        }
    }

    @Override
    public void atualizar(Object object) {
        this.cliente = (Cliente) object;
        try {
            this.em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, cliente.getId());
            c.setNome(cliente.getNome());
            c.setEndereco(cliente.getEndereco());
            c.setCidade(cliente.getCidade());
            c.setEstado(cliente.getEstado());
            c.setUf(cliente.getUf());
            c.setCep(cliente.getCep());
            c.setTelefone(cliente.getTelefone());
            c.setCpf(cliente.getCpf());
            c.setRg(cliente.getRg());
            c.setEmail(cliente.getEmail());
            this.em.merge(c);
            this.em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.getMessage();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Object object) {
        this.cliente = (Cliente) object;
        this.em.getTransaction().begin();
        Cliente c = em.find(Cliente.class, cliente.getId());
        this.em.remove(c);
        this.em.getTransaction().commit();
        try {

        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.getMessage();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object listarPorCodigo(int id) {

        return this.em.find(Cliente.class, id);
    }

    @Override
    public List<Object> listarTodos() {
        Query query = this.em.createQuery("select object(c) from Cliente as c");
        return query.getResultList();
    }

}
