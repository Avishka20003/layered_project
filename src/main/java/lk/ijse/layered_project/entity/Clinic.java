package lk.ijse.layered_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clinic {
    private int clinic_id;
    private String clinic_name;
    private String clinic_location;
    private String description;
    private String contact;
    private String status;


    public Clinic(String clinic_name, String clinic_location, String description, String contact) {
        this.clinic_name = clinic_name;
        this.clinic_location = clinic_location;
        this.description = description;
        this.contact = contact;
    }
}
