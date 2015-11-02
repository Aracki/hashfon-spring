package com.ro.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by ivan on 29.10.15..
 */
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private enum Roles {
        STUDENT("STUDENT"), KOMPANIJA("KOMPANIJA");

        private final String text;

        private Roles(final String text) {
            this.text = text;
        }

        public String toString() {
            return text;
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/s_pocetna", "/s_pocetna/**").hasRole(Roles.STUDENT.toString())
                .antMatchers("/s_kompanija_profil", "/s_kompanija_profil/**").hasRole(Roles.STUDENT.toString())
                .antMatchers("/s_student_profil", "/s_student_profil/**").hasRole(Roles.STUDENT.toString())

                .antMatchers("/k_pocetna", "/k_pocetna/**").hasRole(Roles.KOMPANIJA.toString())
                .antMatchers("/k_kompanija_profil", "/k_kompanija_profil/**").hasRole(Roles.KOMPANIJA.toString())
                .antMatchers("/k_student_profil", "/k_student_profil/**").hasRole(Roles.KOMPANIJA.toString())

                .and()
                .formLogin()
                .loginPage("/login_page")
                .failureUrl("/login?error")
                .usernameParameter("ra")
                .passwordParameter("ra")
                .loginProcessingUrl("/login")

                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/error/**");
//    }
}
