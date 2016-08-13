package info.adamdziedzic.network.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddGroupRequest extends BasicAuthRequest {
    private long groupId;
}
