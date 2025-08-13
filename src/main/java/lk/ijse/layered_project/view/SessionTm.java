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

public class SessionTm {
    public int session_id;
    public String topic;
    public String description;
    public String date;
    public String duration;
    private HBox action;

}
