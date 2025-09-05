package my.code.entity;

import lombok.Value;

@Value(staticConstructor = "of")
public class User {
    Integer id;
    String name;
    String password;
}
