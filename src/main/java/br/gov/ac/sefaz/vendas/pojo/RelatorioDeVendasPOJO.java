package br.gov.ac.sefaz.vendas.pojo;

import java.time.LocalDateTime;

public class RelatorioDeVendasPOJO {

    private String name;
    private Double price;
    private LocalDateTime date;

    public RelatorioDeVendasPOJO(String name, Double price, LocalDateTime date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasPOJO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
