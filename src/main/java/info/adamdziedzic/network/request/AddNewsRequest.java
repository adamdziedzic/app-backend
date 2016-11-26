package info.adamdziedzic.network.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddNewsRequest {
    private String title;
    private String content;
    private Long menuItemId;
}
