package shimizu.common.bos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * @author Shimizu
 */
@Service
public class BosService<T> {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BosTypeManager bosTypeManager;

    public T find(String id){
        Class<?> aClass=bosTypeManager.getClass(id);
        return (T) entityManager.find(aClass, id);
    }

}
