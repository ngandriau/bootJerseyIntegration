package hello.resource;

import hello.HelloWorldApp;
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

import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/customers")
public class CustomersResource
{

    private static final Logger log =  LoggerFactory.getLogger(CustomersResource.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Receiver receiver;

    @RequestMapping( method=GET)
    public Set<CustomerM> getCustomers()
    {

        log.debug("getCustomers()");

        final Set<CustomerM> result = new HashSet<CustomerM>();


        for (CustomerD customerD : customerRepository.findAll()) {
            result.add(new CustomerM(customerD.getId(), customerD.getFirstName(), customerD.getLastName()));
        }

        return result;



    }

    @RequestMapping(method = DELETE)
    public void reset()
    {

        customerRepository.deleteAll();

        // save a couple of customers
        customerRepository.save(new CustomerD("Alice", "Smith"));
        customerRepository.save(new CustomerD("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (CustomerD customerD : customerRepository.findAll()) {
            System.out.println(customerD);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerRepository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (CustomerD customerD : customerRepository.findByLastName("Smith")) {
            System.out.println(customerD);
        }

        System.out.println("Sent message on the queue, to indicate that request has been handled");
        rabbitTemplate.convertAndSend(HelloWorldApp.queueName, "Hello from RabbitMQ!");
    }

}