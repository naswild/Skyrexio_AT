package enums;

public enum PropertyEnum {

    EMAIL("Skyrexio.email"),
    PASSWORD("Skyrexio.password"),
    BASE_URL("Skyrexio.url");

    private final String value;

    PropertyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
