package api.dto.smart_trade;

public class SmartTradeFormDto {

    private String baseSymbol;
    private String quoteSymbol;
    private String exchangeAccountUuid;
    private SmartTradeBaseOrderDto baseOrder;

    public SmartTradeFormDto(String baseSymbol, String quoteSymbol, String exchangeAccountUuid, SmartTradeBaseOrderDto baseOrder) {
        this.baseSymbol = baseSymbol;
        this.quoteSymbol = quoteSymbol;
        this.exchangeAccountUuid = exchangeAccountUuid;
        this.baseOrder = baseOrder;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public String getQuoteSymbol() {
        return quoteSymbol;
    }

    public String getExchangeAccountUuid() {
        return exchangeAccountUuid;
    }

    public SmartTradeBaseOrderDto getBaseOrder() {
        return baseOrder;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public void setQuoteSymbol(String quoteSymbol) {
        this.quoteSymbol = quoteSymbol;
    }

    public void setExchangeAccountUuid(String exchangeAccountUuid) {
        this.exchangeAccountUuid = exchangeAccountUuid;
    }

    public void setBaseOrder(SmartTradeBaseOrderDto baseOrder) {
        this.baseOrder = baseOrder;
    }
}
