package ru.shiftcft.annotation;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.shiftcft.extension.BasketGeneratorExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith(BasketGeneratorExtension.class)
public @interface BasketGenerate {
    String intBasket();
    String floatBasket();
    String stringBasket();
}
