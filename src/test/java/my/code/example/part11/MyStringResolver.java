package my.code.example.part11;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

// 1. Створюємо наш власний ParameterResolver
class MyStringResolver implements ParameterResolver {

    // JUnit запитає: "Чи підтримуєш ти цей параметр?"
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        // Перевіряємо, чи параметр є типом String
        return parameterContext.getParameter().getType() == String.class;
    }

    // Якщо supportsParameter() повертає true, викликається цей метод
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        // Повертаємо об'єкт, який буде впроваджено
        return "Впроваджено!";
    }
}
