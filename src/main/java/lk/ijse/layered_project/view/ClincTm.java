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

public class ClincTm {

    public int clinic_id;
    public String clinic_name;
    public String location;
    public String contact;
    public String status;
    public HBox action;

    public ClincTm(int fatherId, String name, String address, String nic, String email, String phoneNumber, HBox actionBox) {
    }
}
