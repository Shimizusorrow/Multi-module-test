package shimizu.identity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shimizu.identity.repository.UserRepository;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/11 16:02
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
