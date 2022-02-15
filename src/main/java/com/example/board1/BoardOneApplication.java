package com.example.board1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardOneApplication {

    public static void main(String[] args)  {


        SpringApplication.run(BoardOneApplication.class, args);

        /*Annotation[] declaredAnnotations = JdbcTemplateBoardRepository.class.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }

        Field[] declaredFields = JdbcTemplateBoardRepository.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Annotation[] declaredAnnotations1 = declaredField.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations1) {

                declaredField.setAccessible(true);
                if (true) {
                    declaredField.set(new JdbcTemplate(), new JdbcTemplate());
                }
            }
        }
*/
    }
}