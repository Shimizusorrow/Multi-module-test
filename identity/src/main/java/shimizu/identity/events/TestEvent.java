package shimizu.identity.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import shimizu.identity.domain.Student;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/27 8:42
 */
@Data
@AllArgsConstructor
public class TestEvent {
    private Student student;
}
