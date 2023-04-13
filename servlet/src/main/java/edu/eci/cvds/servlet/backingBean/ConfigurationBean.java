package edu.eci.cvds.servlet.backingBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CONFIGURATION")
public class ConfigurationBean {
    @Id
    @Column(name = "PROPIEDAD")
    private String id;
    @Column(name = "VALOR")
    private String valor;

    public ConfigurationBean(String id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public ConfigurationBean() {

    }
    public void setId(String propiedad) {
        this.id = propiedad;
    }

    public String getId() {
        return id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ConfigutationB{" +
                "propiedad='" + id + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigurationBean that = (ConfigurationBean) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }
}
