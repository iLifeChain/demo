package com.ilifediary.blockchain.demo.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by chenyu.jcy on 2018/01/27.
 *
 * @author 至德
 * @date 2018/01/27
 */
@Slf4j
public class LifeDiaryFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.debug("filter");
        filterChain.doFilter(request, response);
    }
}
