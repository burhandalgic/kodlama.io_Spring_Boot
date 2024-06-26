package kodlama.io.rentACar;
import kodlama.io.rentACar.core.exception.BusinessException;
import kodlama.io.rentACar.core.exception.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@SpringBootApplication
@RestControllerAdvice
@PropertySource("classpath:application.properties")
public class RentACarApplication implements CommandLineRunner {
    @Value("${name}")
    String name;
    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
        return problemDetails;
    }
    @Bean // bir nesne oluşturup ioc ye ekle , ihtiyacım olduğunda kullanayım
    //çünkü modelMapper classını oluşturanlar service anotasyonunu eklememiş
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String...args) throws Exception {
        System.out.println(name);

    }
}
