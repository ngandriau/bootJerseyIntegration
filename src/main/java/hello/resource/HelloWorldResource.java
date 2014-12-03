package hello.resource;

import hello.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Dummy simple HelloWorld Rest resource
 *
 */
@RestController
@RequestMapping("/hello-world")
public class HelloWorldResource
{

    private static final Logger log =  LoggerFactory.getLogger(HelloWorldResource.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name)
    {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}