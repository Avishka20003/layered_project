package lk.ijse.layered_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChildDto {
    private int child_id;
    private String mother_id;
    private String father_id;
    private String name;
    private String address;
    private String birth_place;
    private String gender;
    private String dob;
    private float birth_height;
    private float birth_weight;
    private String note;
    private String blood_type;

    public ChildDto(String name,String address,String birth_place,String gender,String dob,
                    float birth_height,float birth_weight,String note,String blood_type){
        this.name=name;
        this.address=address;
        this.birth_place=birth_place;
        this.gender=gender;
        this.dob=dob;
        this.birth_height=birth_height;
        this.birth_weight=birth_weight;
        this.note=note;
        this.blood_type=blood_type;
    }


    public ChildDto(int childId, String name, String address, String birthPlace, String gender, String dob, float birtHeight, float birtWeight, String note, String bloodType) {
        this.child_id = childId;
        this.name = name;
        this.address = address;
        this.birth_place = birthPlace;
        this.gender = gender;
        this.dob = dob;
        this.birth_height = birtHeight;
        this.birth_weight = birtWeight;
        this.note = note;
        this.blood_type = bloodType;

    }
}
