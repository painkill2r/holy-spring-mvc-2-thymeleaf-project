package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }

    /* 스프링 부트를 사용하면 MessageSource를 자동으로 Bean으로 등로하기 때문에 주석 처리
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        //메시지 설정 파일 이름 설정(여러 개 설정 가능)
        //만약, 국제화 기능을 적용하려면 messages_en.properties, messages_ko.properties와 같이 파일명 마지막에 언어 정보를 설정하면 됨.
        //만약, 찾을 수 있는 국제화 파일이 없으면 messages.properties를 기본으로 사용한다.
        messageSource.setBasenames("messages", "errors"); //메시지 설정 파일 이름 설정(여러 개 설정 가능)
        messageSource.setDefaultEncoding("UTF-8"); //인코딩 정보 지정
        return messageSource;
    }
    */
}
