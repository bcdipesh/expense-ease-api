package app.vercel.dipeshbc.expenseeaseapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
        info = @Info(
                title = "Expense Ease REST API Documentation",
                description = "This is the backend REST API documentation for Expense Ease Application",
                version = "0.0.1-SNAPSHOT",
                contact = @Contact(
                        name = "Dipesh B C",
                        email = "bcdipeshwork@gmail.com",
                        url = "https://dipeshbc.vercel.app"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ExpenseEaseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseEaseApiApplication.class, args);
    }

}
