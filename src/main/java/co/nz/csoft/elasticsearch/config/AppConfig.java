package co.nz.csoft.elasticsearch.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	@Bean
	public RestTemplate restTemplate() {
	    HttpClient httpClient = HttpClientBuilder.create()
	            .addInterceptorFirst(new RequestAcceptEncoding())
	            .addInterceptorFirst(new ResponseContentEncoding())
	            .build();

	    HttpComponentsClientHttpRequestFactory factory =
	            new HttpComponentsClientHttpRequestFactory(httpClient);

	    return new RestTemplate(factory);
	}
}
