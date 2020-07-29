package shimizu.common.bos;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * @author Shimizu
 */
@Service
@AllArgsConstructor
public class BosService<T> {
    private final EntityManager entityManager;
    private final BosTypeManager bosTypeManager;

    public T find(String id) {
        return (T) entityManager.find(bosTypeManager.getClass(id), id);
    }

}
