package br.com.zupedu.proposal.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers(HttpMethod.GET, "/proposals/**").hasAuthority("SCOPE_proposal-scope")
                        .antMatchers(HttpMethod.GET, "/cards/**").hasAuthority("SCOPE_proposal-scope")
                        .antMatchers(HttpMethod.POST, "/cards/**").hasAuthority("SCOPE_proposal-scope")
                        .antMatchers(HttpMethod.POST, "/proposals/**").hasAuthority("SCOPE_proposal-scope")
                        .anyRequest().authenticated()
        ).csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
