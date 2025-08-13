package lk.ijse.layered_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Family {
    private  int family_id;
    private int mother_id;
    private int father_id;
    private int midwife_if;
    private String contact;
    private String regDate;

    public Family(int nextId, int fatherId, int i, String phoneNumber, String s) {
        this.mother_id = nextId;
        this.father_id = fatherId;
        this.midwife_if = i;
        this.contact = phoneNumber;
        this.regDate = s;
    }
}
