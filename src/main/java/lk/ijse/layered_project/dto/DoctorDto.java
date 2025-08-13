package lk.ijse.layered_project.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorDto {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String specialist;
    private String status;

}
