package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CloverCustomerCreation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")




public class CustomerCreation {
  @JsonProperty("ecomind")
  private String ecomind = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("shipping")
  private Shipping shipping = null;

  public CustomerCreation ecomind(String ecomind) {
    this.ecomind = ecomind;
    return this;
  }

  /**
   * Get ecomind
   * @return ecomind
  **/
  @ApiModelProperty(value = "")


  public String getEcomind() {
    return ecomind;
  }

  public void setEcomind(String ecomind) {
    this.ecomind = ecomind;
  }

  public CustomerCreation email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerCreation firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CustomerCreation lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CustomerCreation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerCreation source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public CustomerCreation phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public CustomerCreation shipping(Shipping shipping) {
    this.shipping = shipping;
    return this;
  }

  /**
   * Get shipping
   * @return shipping
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Shipping getShipping() {
    return shipping;
  }

  public void setShipping(Shipping shipping) {
    this.shipping = shipping;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerCreation cloverCustomerCreation = (CustomerCreation) o;
    return Objects.equals(this.ecomind, cloverCustomerCreation.ecomind) &&
        Objects.equals(this.email, cloverCustomerCreation.email) &&
        Objects.equals(this.firstName, cloverCustomerCreation.firstName) &&
        Objects.equals(this.lastName, cloverCustomerCreation.lastName) &&
        Objects.equals(this.name, cloverCustomerCreation.name) &&
        Objects.equals(this.source, cloverCustomerCreation.source) &&
        Objects.equals(this.phone, cloverCustomerCreation.phone) &&
        Objects.equals(this.shipping, cloverCustomerCreation.shipping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ecomind, email, firstName, lastName, name, source, phone, shipping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloverCustomerCreation {\n");
    
    sb.append("    ecomind: ").append(toIndentedString(ecomind)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    shipping: ").append(toIndentedString(shipping)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

