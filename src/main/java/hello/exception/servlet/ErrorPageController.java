package hello.exception.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ErrorPageController {
    
    @RequestMapping("/error-page/404")
    public String error404(HttpServletRequest request, HttpServletResponse response) {
        log.info("Error Page 404");
        return "error-page/404";
    }

    @RequestMapping("/error-page/500")
    public String error500(HttpServletRequest request, HttpServletResponse response) {
        log.info("Error Page 500");
        return "error-page/500";
    }
}
