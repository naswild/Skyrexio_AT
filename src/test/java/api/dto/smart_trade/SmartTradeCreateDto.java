package api.dto.smart_trade;

public class SmartTradeCreateDto {

    private SmartTradeFormDto form;

    public SmartTradeCreateDto(SmartTradeFormDto form) {
        this.form = form;
    }

    public SmartTradeFormDto getForm() {
        return form;
    }

    public void setForm(SmartTradeFormDto form) {
        this.form = form;
    }
}
