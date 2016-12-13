package fi.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf().ignoringAntMatchers("/h2-console").disable()
        .authorizeRequests().antMatchers("/**/favicon.ico") .permitAll()
        .and().authorizeRequests().antMatchers("/webjars/**").permitAll()
        .and().authorizeRequests().antMatchers("/static/css").permitAll()
        .and().authorizeRequests().antMatchers("/static/js").permitAll()
        .and().formLogin().loginPage("/login").permitAll()
        .and().authorizeRequests().antMatchers("/user/**").authenticated()
        .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
        .and().exceptionHandling().accessDeniedPage("/access_denied");    	
        }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
           .antMatchers("/resources/**"); 
    }
    
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("kala").password("kalan").roles("USER")
				.and().withUser("kissa").password("kissan").roles("ADMIN","USER");
    	}
    


   
}