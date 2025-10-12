package api.dto.smart_trade;

import java.util.List;

public class SmartTradeCancelDto {

    private List<String> smartTradeUuids;

    public SmartTradeCancelDto(List<String> smartTradeUuids) {
        this.smartTradeUuids = smartTradeUuids;
    }

    public List<String> getSmartTradeUuids() {
        return smartTradeUuids;
    }

    public void setSmartTradeUuids(List<String> smartTradeUuids) {
        this.smartTradeUuids = smartTradeUuids;
    }
}
