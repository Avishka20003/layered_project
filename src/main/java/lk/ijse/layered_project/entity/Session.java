package lk.ijse.layered_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Session {
    int session_id;
    String topic;
    String description;
    String date;
    String duration;
    int midwife_id;


    public Session(String topic, String description, String date, String duration, int midwife_id) {
        this.topic = topic;
        this.description = description;
        this.date = date;
        this.duration = duration;
        this.midwife_id = midwife_id;
    }

}

