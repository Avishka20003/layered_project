package lk.ijse.layered_project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private int id;
    private int mother_id;
    private String name;

    public TestDto(String name, int mother_id) {
        this.name = name;
        this.mother_id = mother_id;

    }
}
