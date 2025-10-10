package enums;

public enum PropertyEnum {

    PAGES_LANGUAGE("pages.language"),
    TESTS_LANGUAGE("Skyrexio.tests.language"),
    EMAIL("Skyrexio.email"),
    PASSWORD("Skyrexio.password"),
    BASE_URL("Skyrexio.url"),

    LOGIN_ERROR_MSG("login.error_msg"),
    LOGIN_TITLE("login.title"),

    HOME_STATISTICS("home.statistics"),

    TERMINAL_CONFIRM("terminal.confirm"),
    TERMINAL_ACTIVE("terminal.active"),
    TERMINAL_ERROR_MSG("terminal.error_msg");

    private final String value;

    PropertyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
