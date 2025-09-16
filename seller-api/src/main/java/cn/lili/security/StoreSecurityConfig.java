package cn.lili.security;

import cn.lili.cache.Cache;
import cn.lili.common.properties.IgnoredUrlsProperties;
import cn.lili.common.security.CustomAccessDeniedHandler;
import cn.lili.modules.member.service.ClerkService;
import cn.lili.modules.member.service.StoreMenuRoleService;
import cn.lili.modules.member.token.StoreTokenGenerate;
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
 * spring Security 核心配置类 Store安全配置中心
 *
 * @author Chopper
 * @since 2020/11/14 16:20
 */
@Slf4j
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class StoreSecurityConfig {

    private final IgnoredUrlsProperties ignoredUrlsProperties;

    private final CustomAccessDeniedHandler accessDeniedHandler;

    private final Cache<Object> cache;

    private final StoreTokenGenerate storeTokenGenerate;

    private final StoreMenuRoleService storeMenuRoleService;

    private final ClerkService clerkService;

    private final CorsConfigurationSource corsConfigurationSource;


    @Bean
    public StoreAuthenticationFilter storeAuthenticationFilter() {
        return new StoreAuthenticationFilter(storeTokenGenerate, storeMenuRoleService, clerkService, cache);
    }

    @Bean
    public SecurityFilterChain storeSecurityFilterChain(HttpSecurity http) throws Exception {

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
                .logout(logout -> logout.permitAll())
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler));

        http.addFilterBefore(storeAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
