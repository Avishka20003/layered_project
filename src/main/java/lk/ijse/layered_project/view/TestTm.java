package lk.ijse.layered_project.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestTm {
    private int id;
    private String name;
    private int description;

    public TestTm(String name, int description) {
        this.name = name;
        this.description = description;
    }
}