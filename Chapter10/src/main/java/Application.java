import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
这是Springboot的启动文件
 */
@SpringBootApplication
@ComponentScan("com.course")//扫描目录是com.course这个文件夹下文件
public class Application {

    public static void main(String[] args){SpringApplication.run(Application.class,args);
    }
}
