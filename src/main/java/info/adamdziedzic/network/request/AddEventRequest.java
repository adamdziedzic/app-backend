package info.adamdziedzic.network.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class AddEventRequest {
    private String name;
    private Date startDate;
    private Date endDate;
    private Long menuItemId;
}
