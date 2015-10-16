package de.marhan.sandbox

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Stepwise

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = [SpringBootSandboxApplication.class])
@WebIntegrationTest
@Stepwise
@IntegrationTest("server.port:0")
class RestIntegrationBase extends Specification {

    @Value('${local.server.port}')
    int port

    String getBasePath() { "api02" }

    URI serviceURI(String path = "") {
        new URI("http://localhost:$port/${basePath}${path}")
    }
}