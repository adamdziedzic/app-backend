package info.adamdziedzic.network.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class BasicAuthRequest {

    private String username;
    private String password;
}
