package de.marhan.sandbox

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Stepwise

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = [SpringBootSandboxApplication.class])
@WebIntegrationTest
@Stepwise
class RestIntegrationBase extends Specification {

    @Value('${local.server.port}')
    int port

    String getBasePath() { "api" }

    URI serviceURI(String path = "") {
        new URI("http://localhost:$port/${basePath}${path}")
    }
}