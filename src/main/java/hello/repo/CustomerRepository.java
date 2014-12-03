package hello.repo;

import hello.domain.CustomerD;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ngandriau on 11/14/14.
 */
public interface CustomerRepository extends MongoRepository<CustomerD, String>
{

    public CustomerD findByFirstName(String firstName);

    public List<CustomerD> findByLastName(String lastName);

}
