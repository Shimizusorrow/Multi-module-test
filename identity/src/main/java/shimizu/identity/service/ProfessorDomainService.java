package shimizu.identity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shimizu.identity.domain.Professor;
import shimizu.identity.repository.ProfessorRepository;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/20 11:59
 */
@Service
@AllArgsConstructor
public class ProfessorDomainService {
    private final ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
}
