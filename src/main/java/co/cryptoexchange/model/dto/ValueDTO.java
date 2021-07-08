package co.cryptoexchange.model.dto;

public class ValueDTO {

    private Double value;

    public ValueDTO(){

    }

    public ValueDTO(Double v){
        value = v;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
