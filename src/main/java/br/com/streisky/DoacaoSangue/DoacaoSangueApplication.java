package br.com.streisky.DoacaoSangue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DoacaoSangueApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoacaoSangueApplication.class, args);
    }
}
