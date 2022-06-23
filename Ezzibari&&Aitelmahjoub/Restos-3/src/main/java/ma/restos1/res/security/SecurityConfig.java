package ma.restos1.res.security;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        PasswordEncoder pe = passwordEncoder();
        String mdp = pe.encode("123");
        System.out.println(mdp);
        auth.inMemoryAuthentication().withUser("user@gmail.com").password(mdp).roles("USER");
        auth.inMemoryAuthentication().withUser("Admin@gmail.com").password(mdp).roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{

        http.formLogin();
        http.authorizeRequests().antMatchers("/Nos_Tables").hasRole("USER");
        http.authorizeRequests().antMatchers("/ContactUs").hasRole("USER");
        http.authorizeRequests().antMatchers("/Tables").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/Edit_table").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/Liste_Messasge").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/InfoMessage").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/Inscription").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Liste_table_admin").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/Liste_Utilisateur").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/delete").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/Tables").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/Menu").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Accueil").hasAnyRole("USER","ADMIN");
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**","/fonts/**");
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
