package BADA_PROJECT.SpringApplication;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/o_nas").setViewName("o_nas");
        registry.addViewController("/kontakt").setViewName("kontakt");


        registry.addViewController("/errors/403").setViewName("errors/403");
        registry.addViewController("/errors/404").setViewName("errors/404");
        registry.addViewController("/errors/500").setViewName("errors/500");
        registry.addViewController("/errors/504").setViewName("errors/504");
        registry.addViewController("/errors/other").setViewName("errors/other");
    }

    @Controller
    public class DashboardController {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/admin/main";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/user/main";
            } else {
                return "redirect:/index";
            }
        }

        @RequestMapping(value = {"admin/main"})
        public String showAdminPage(Model model) {
            return "admin/main";
        }


        @RequestMapping(value = {"user/main"})
        public String showUserPage(Model model) {
            return "user/main";
        }
    }
}

