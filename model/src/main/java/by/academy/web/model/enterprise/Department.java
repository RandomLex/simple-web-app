package by.academy.web.model.enterprise;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Department extends AbstractEntity {
    private String name;
    private List<City> cities = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
}
