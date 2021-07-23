package ma.jad.customer.Model;

import lombok.Data;

@Data
public class CustomerResponseDto {
    private Long id;
    private String name;
    private String email;

    public CustomerResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerResponseDto() {
    }

    @Override
    public String toString() {
        return "CustomerResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
