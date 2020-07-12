package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")//访问的路径--localhost:8080
    @ResponseBody //标志地下的home这个method是返回的返回体
    String home(){
        return "Hello World";
    }
    public static void main(String[] args) throws Exception{
        SpringApplication.run(SampleController.class,args);
    }

}
