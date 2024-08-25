package ru.shiftcft.extension;

import org.junit.jupiter.api.extension.*;
import ru.shiftcft.data.Basket;

public class BasketGeneratorExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return false;
    }

    @Override
    public Basket resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Basket basket = new Basket();

        return null;
    }
}
