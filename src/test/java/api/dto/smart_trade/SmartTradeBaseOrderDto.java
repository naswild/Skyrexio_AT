package api.dto.smart_trade;

public class SmartTradeBaseOrderDto {

    private String side;
    private String type;
    private Integer limitPrice;
    private Float unitsBase;

    public SmartTradeBaseOrderDto(String side, String type, Integer limitPrice, Float unitsBase) {
        this.side = side;
        this.type = type;
        this.limitPrice = limitPrice;
        this.unitsBase = unitsBase;
    }

    public String getSide() {
        return side;
    }

    public String getType() {
        return type;
    }

    public Integer getLimitPrice() {
        return limitPrice;
    }

    public Float getUnitsBase() {
        return unitsBase;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLimitPrice(Integer limitPrice) {
        this.limitPrice = limitPrice;
    }

    public void setUnitsBase(Float unitsBase) {
        this.unitsBase = unitsBase;
    }
}