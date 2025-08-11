package lk.ijse.layered_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Doctor {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String specialist;
    private String status;

}
