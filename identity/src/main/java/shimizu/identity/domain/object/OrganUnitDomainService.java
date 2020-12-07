package shimizu.identity.domain.object;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.OrganUnit;
import shimizu.identity.repository.OrganUnitRepository;

/**
 * @author Shimizu
 * @description 机构DomainService
 * @date 2020-12-07 15:28
 */
@Service
@AllArgsConstructor
public class OrganUnitDomainService {
    private final OrganUnitRepository organUnitRepository;

    public void add(OrganUnit organUnit) {
        organUnitRepository.save(organUnit);
    }

}
