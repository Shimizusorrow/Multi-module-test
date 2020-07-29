package shimizu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shimizu.app.domain.VacateApplyOrder;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/29 10:43
 */
public interface VacateApplyOrderRepo extends JpaRepository<VacateApplyOrder, String> {
}
