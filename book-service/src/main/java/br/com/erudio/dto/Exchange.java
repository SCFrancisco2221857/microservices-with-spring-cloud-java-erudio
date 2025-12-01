package br.com.erudio.dto;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String from;
    private String to;
    private String enviroment;
    private BigDecimal conversionFactor;
    private Double convertedValue;

    public Exchange() {
    }

    public Exchange(Long id, String from, String to, String enviroment, BigDecimal conversionFactor, Double convertedValue) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.enviroment = enviroment;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return Objects.equals(getId(), exchange.getId()) && Objects.equals(getFrom(), exchange.getFrom()) && Objects.equals(getTo(), exchange.getTo()) && Objects.equals(getEnviroment(), exchange.getEnviroment()) && Objects.equals(getConversionFactor(), exchange.getConversionFactor()) && Objects.equals(getConvertedValue(), exchange.getConvertedValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getEnviroment(), getConversionFactor(), getConvertedValue());
    }
}
