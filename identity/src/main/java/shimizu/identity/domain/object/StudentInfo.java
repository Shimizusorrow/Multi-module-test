package shimizu.identity.domain.object;

import lombok.Getter;
import lombok.Setter;
import shimizu.identity.domain.Student;
import shimizu.identity.domain.base.Person;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/20 9:53
 */

@Getter
@Setter
@Entity
public class StudentInfo extends Person {

    @ManyToOne
    private Student student;
}
