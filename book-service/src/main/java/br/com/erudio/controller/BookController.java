package br.com.erudio.controller;

import br.com.erudio.dto.Exchange;
import br.com.erudio.enviroment.InstanceInformationService;
import br.com.erudio.model.Book;
import br.com.erudio.proxy.ExchangeProxy;
import br.com.erudio.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

@Tag(name = "Book Endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ExchangeProxy exchangeProxy;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value="/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ){
        String port= informationService.retrieveServerPort();
        String host= informationService.retrieveInstanceInfo();
        var Book = bookRepository.findById(id).orElseThrow();

        logger.info("Calculating exchange for {} to {}", "USD", currency);


        Exchange exchange = exchangeProxy.getExchange(Book.getPrice(),"USD", currency);

        Book.setCurrency(currency);
        Book.setEnvironment(" BOOK HOST" + host + " PORT" + port + " VERSION: kube-v1 EXCHANGE HOST" + exchange.getEnviroment());

        Book.setPrice(exchange.getConvertedValue());
        return Book;
    }

}
