package co.cryptoexchange.model.dto;

public class CoinDTO {

    private String name;
    private String code;
    private Double value;

    public CoinDTO(String name, String code, Double value){
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
