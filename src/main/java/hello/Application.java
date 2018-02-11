package hello;

import hello.data.HashtagsHits;
import hello.data.StatisticsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
 /*   final static String queueName = "spring-boot";
   @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("172.17.0.2");
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }*/

   /* @Bean
    public CommandLineRunner demo(StatisticsRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new HashtagsHits("Jack"));
            repository.save(new HashtagsHits("Chloe"));
            repository.save(new HashtagsHits("Kim"));
            repository.save(new HashtagsHits("David"));
            repository.save(new HashtagsHits("Michelle"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (HashtagsHits hits : repository.findAll()) {
                log.info(hits.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            HashtagsHits customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (HashtagsHits david : repository.findByHashTag("David")) {
                log.info(david.toString());
            }
            log.info("");
        };
    }*/

   @Bean(name="onlineClients")
   @Scope(scopeName = "singleton")
   public ConcurrentMap<String, ResponseBodyEmitter> onlineClients(){
       return new ConcurrentHashMap<String, ResponseBodyEmitter>();
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}