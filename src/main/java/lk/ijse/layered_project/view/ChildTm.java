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
public class ChildTm {
    public int child_id;
    public String child_name;
    public String address;
    public String gender;
    public String dob;
    public HBox Action;

}
