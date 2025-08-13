package lk.ijse.layered_project.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private int id;
    private int mother_id;
    private String name;

    public Test(String name, int mother_id) {
        this.name = name;
        this.mother_id = mother_id;

    }
}
