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

public class FatherTm {
    public int id;
    public String name;
    public String address;
    public String nic;
    public String email;
    public String phone_number;
    public HBox Action;
}
