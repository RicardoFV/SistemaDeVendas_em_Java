
package persistencia;

// INTERFACE RESPONSÁVEL POR TRATAR TODOS OS METODOS , TAIS COMO :
// INSERIR , ATUALIZAR, DELETAR, LISTARPORCODIGO LISTARTODOS
// TODAS AS CLASSES QUE TIVEREM ALGUM TRATATIVA NO BANCO , DEVE IMPLEMENTAR
// ESSA INTERFCE.

import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface Persistencia {
    
    public void inserir(Object object);
    public void atualizar(Object object);
    public void deletar(Object object);
    public Object listarPorCodigo(int id);
    public List<Object> listarTodos();
    
}
