package vip.xjdai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;

class DemoApplicationTests {

	@Test
	void contextLoads() {
        byte[]     secreKeyBytes = DatatypeConverter.parseBase64Binary("SECa");
        System.out.println(Arrays.toString(secreKeyBytes));
    }

}
