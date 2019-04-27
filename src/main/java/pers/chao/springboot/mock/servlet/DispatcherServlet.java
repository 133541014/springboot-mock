package pers.chao.springboot.mock.servlet;

import lombok.extern.slf4j.Slf4j;
import pers.chao.springboot.mock.bean.HandlerMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * spring mvc 核心 servlet
 *
 * @author WangYichao
 * @date 2019/4/27 12:26
 */
@Slf4j
public class DispatcherServlet extends HttpServlet{

    private List<HandlerMapping> handlerMapping = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化handlerMapping

        log.info("DispatcherServlet已经初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispather(req, resp);
    }

    private void doDispather(HttpServletRequest req, HttpServletResponse resp) {

    }
}
