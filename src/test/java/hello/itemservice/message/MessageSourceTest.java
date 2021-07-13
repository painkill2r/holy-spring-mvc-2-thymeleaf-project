package hello.itemservice.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    /**
     * 단순한 메시지 테스트
     * Locale 정보가 없으면 Basename에서 설정한 기본 이름 메시지 파일을 조회함.
     * (messages를 지정했으므로 messages.properties 파일에서 데이터를 조회)
     */
    @Test
    void helloMessage() {
        String result = messageSource.getMessage("hello", null, null);

        assertThat(result).isEqualTo("안녕");
    }

    /**
     * 메시지를 찾을 수 없을 때 예외 발생 테스트
     */
    @Test
    void notFoundMessageCode() {
        //메시지 코드가 없는 경우 NoSuchMessageException 예외 발생
        assertThatThrownBy(() -> messageSource.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    /**
     * 메시지를 찾을 수 없을 때 기본 메시지 설정 테스트
     */
    @Test
    void notFoundMessageCodeDefaultMessage() {
        //메시지 코드가 없는 경우 NoSuchMessageException 예외 발생
        String result = messageSource.getMessage("no_code", null, "기본 메시지", null);

        assertThat(result).isEqualTo("기본 메시지");
    }

    /**
     * Argument를 사용한 메시지 테스트
     */
    @Test
    void argumentMessage() {
        String result = messageSource.getMessage("hello.name", new Object[]{"Spring"}, null); //Object 배열로 전달

        assertThat(result).isEqualTo("안녕 Spring");
    }

    /**
     * 국제화 메시지 테스트 - 1(기본 메시지 동작 확인)
     */
    @Test
    void defaultLang() {
        assertThat(messageSource.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(messageSource.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕"); //KOREA에 대한 국제화 설저이 없으므로 기본 메시지가 동작
    }

    /**
     * 국제화 메시지 테스트 - 2(영문 메시지 동작 확인)
     */
    @Test
    void enLang() {
        assertThat(messageSource.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
}
