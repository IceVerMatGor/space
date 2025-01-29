package by.gorbov.space.lab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Human {
    private String name;
    private int age;
    private int height;
    private int weight;
    private Date birthday;
}
