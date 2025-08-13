package lk.ijse.layered_project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MotherDto {
    private int mother_id;
    private String name;
    private String address;
    private String nic;
    private String dob;
    private String occupation;
    private String email;
    private String phone_number;
    private int weight;
    private int height;
    private String allergies;
    private String medical_history;
    private String note;
    private String blood_type;
    private int father_id;

    public MotherDto(int mother_id, String name, String address, String nic,
                     String dob, String occupation,
                     String email,
                     String phone_number,
                     int weight,
                     int height,
                     String allergies,
                     String medical_history,
                     String note,
                     String blood_type) {


        this.mother_id = mother_id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.occupation = occupation;
        this.email = email;
        this.phone_number = phone_number;
        this.weight = weight;
        this.height = height;
        this.allergies = allergies;
        this.medical_history = medical_history;
        this.note = note;
        this.blood_type = blood_type;


    }

    public MotherDto(String name, String address, String nic, String dob, String occupation,
                     String email, String phone_number, int weight, int height, String allergies, String medical_history, String note, String blood_type) {

        this.name = name;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.occupation = occupation;
        this.email = email;
        this.phone_number = phone_number;
        this.weight = weight;
        this.height = height;
        this.allergies = allergies;
        this.medical_history = medical_history;
        this.note = note;
        this.blood_type = blood_type;
    }
}
