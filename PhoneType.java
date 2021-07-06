package Digital.Innovation.one.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME ("Home"),
    MOBILE ("Mobile"),
    COMMMERCIAL ("Commercial");

    private final String description;
}
