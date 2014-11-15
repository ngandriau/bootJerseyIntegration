package hello.repo;

import hello.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ngandriau on 11/14/14.
 */
public interface CustomerRepository extends MongoRepository<Customer, String>
{

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

}
