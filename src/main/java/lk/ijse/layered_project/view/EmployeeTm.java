package lk.ijse.layered_project.view;

import javafx.scene.layout.HBox;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTm {
    private int employeeId;
    private String name;
    private String contactNumber;
    private String address;
    private String role;
    private String specialist;
    private String status;
    private HBox action;
}
