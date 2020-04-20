package shimizu.identity.domain;

import io.swagger.annotations.Api;
import shimizu.identity.domain.base.User;

import javax.persistence.Entity;

@Entity
@Api()
public class Student extends User {

}
