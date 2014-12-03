package hello.resource;

import hello.domain.CustomerD;
import hello.messaging.Receiver;
import hello.model.CustomerM;
import hello.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/customer")
public class CustomerResource
{

    private static final Logger log =  LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Receiver receiver;




    @RequestMapping(value="/{id}", method=GET)
    public CustomerM getCustomer(@PathVariable String id)
    {

        log.debug("getCustomer({})", id);

        final CustomerD customerD = customerRepository.findOne(id);
        final CustomerM customerM = new CustomerM(id, customerD.getFirstName(), customerD.getLastName());
        return customerM;



    }

    @RequestMapping( method=POST)
    public CustomerM createCustomer(final CustomerM newCustomerM )
    {

        log.debug("createCustomer()");

        final CustomerD customerD = new CustomerD(newCustomerM.getFirstName(), newCustomerM.getLastName());
        customerRepository.save(customerD);

        newCustomerM.setId(customerD.getId());

        return newCustomerM;

    }

}