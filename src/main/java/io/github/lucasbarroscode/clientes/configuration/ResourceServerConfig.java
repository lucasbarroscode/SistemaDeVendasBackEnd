package io.github.lucasbarroscode.clientes.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//.antMatchers("/api/clientes/**").hasRole("USER")
		http.authorizeRequests()
			.antMatchers("/api/usuarios").permitAll()
			//.antMatchers("/api/usuarios/**").permitAll()
			.antMatchers("/api/clientes/**", "/api/servicos-prestados/**").authenticated()
			.anyRequest().denyAll();
	
	}

}
