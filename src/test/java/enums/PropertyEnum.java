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
    HOME_SPOT_TAB("home.spot_tab"),
    HOME_FUTURES_TAB("home.futures_tab"),
    HOME_BUY_TAB("home.buy_tab"),
    HOME_SELL_TAB("home.sell_tab"),
    HOME_ALL_TAB("home.all_tab"),
    HOME_BOTS_TAB("home.bots_tab"),
    HOME_MANUAL_TAB("home.manual_tab"),

    TERMINAL_LIMIT("terminal.limit"),
    TERMINAL_MARKET("terminal.market"),
    TERMINAL_CONDITIONAL("terminal.conditional"),
    TERMINAL_CONFIRM("terminal.confirm"),
    TERMINAL_ACTIVE("terminal.active"),
    TERMINAL_ERROR_MSG("terminal.error_msg"),
    TERMINAL_CANCEL_TRADE("terminal.cancel_trade"),
    TERMINAL_CANCELLATION_TITLE("terminal.cancellation_title"),
    TERMINAL_CANCELLATION_TEXT("terminal.cancellation_text");

    private final String value;

    PropertyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
