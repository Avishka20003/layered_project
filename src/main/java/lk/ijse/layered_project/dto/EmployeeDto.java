package lk.ijse.layered_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private int employeeId;
    private String name;
    private String contactNumber;
    private String address;
    private String role;
    private String specialist;
    private String status;
    private String password;


    public EmployeeDto(String name, String contactNumber, String address, String role,
                       String specialist, String status, String password) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.role = role;
        this.specialist = specialist;
        this.status = status;
        this.password = password;
    }
}
