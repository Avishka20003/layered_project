package lk.ijse.layered_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Father {

    private int father_id;
    private String name;
    private String address;
    private String nic;
    private String dob;
    private String occupation;
    private String email;
    private String phone_number;
    private String blood_type;


  public Father(String name, String address, String nic, String dob, String occupation, String email, String phone_number, String blood_type) {
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.occupation = occupation;
        this.email = email;
        this.phone_number = phone_number;
        this.blood_type = blood_type;

    }

}
