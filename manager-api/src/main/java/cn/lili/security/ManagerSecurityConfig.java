package cn.lili.security;

import cn.lili.cache.Cache;
import cn.lili.common.properties.IgnoredUrlsProperties;
import cn.lili.common.security.CustomAccessDeniedHandler;
import cn.lili.modules.permission.service.MenuService;
import cn.lili.modules.system.token.ManagerTokenGenerate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * spring Security 核心配置类 Manager安全配置中心
 *
 * @author Chopper
 * @since 2020/11/14 16:20
 */
@Slf4j
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class ManagerSecurityConfig {

    private final MenuService menuService;

    private final IgnoredUrlsProperties ignoredUrlsProperties;

    private final CustomAccessDeniedHandler accessDeniedHandler;

    private final Cache<Object> cache;

    private final CorsConfigurationSource corsConfigurationSource;

    private final ManagerTokenGenerate managerTokenGenerate;

    @Bean
    public ManagerAuthenticationFilter managerAuthenticationFilter() {
        return new ManagerAuthenticationFilter(menuService, managerTokenGenerate, cache);
    }

    @Bean
    public SecurityFilterChain managerSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> {
                    if (ignoredUrlsProperties.getUrls() != null) {
                        for (String url : ignoredUrlsProperties.getUrls()) {
                            authorize.requestMatchers(url).permitAll();
                        }
                    }
                    authorize.anyRequest().authenticated();
                })
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler));

        http.addFilterBefore(managerAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
