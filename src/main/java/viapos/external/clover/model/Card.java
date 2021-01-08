package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Card
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-19T17:31:11.057Z")




public class Card   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("cvc_check")
  private String cvcCheck = null;

  @JsonProperty("exp_month")
  private String expMonth = null;

  @JsonProperty("exp_year")
  private String expYear = null;

  @JsonProperty("first6")
  private String first6 = null;

  @JsonProperty("last4")
  private String last4 = null;

  public Card id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Card brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  **/
  @ApiModelProperty(value = "")


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Card cvcCheck(String cvcCheck) {
    this.cvcCheck = cvcCheck;
    return this;
  }

  /**
   * Get cvcCheck
   * @return cvcCheck
  **/
  @ApiModelProperty(value = "")


  public String getCvcCheck() {
    return cvcCheck;
  }

  public void setCvcCheck(String cvcCheck) {
    this.cvcCheck = cvcCheck;
  }

  public Card expMonth(String expMonth) {
    this.expMonth = expMonth;
    return this;
  }

  /**
   * Get expMonth
   * @return expMonth
  **/
  @ApiModelProperty(value = "")


  public String getExpMonth() {
    return expMonth;
  }

  public void setExpMonth(String expMonth) {
    this.expMonth = expMonth;
  }

  public Card expYear(String expYear) {
    this.expYear = expYear;
    return this;
  }

  /**
   * Get expYear
   * @return expYear
  **/
  @ApiModelProperty(value = "")


  public String getExpYear() {
    return expYear;
  }

  public void setExpYear(String expYear) {
    this.expYear = expYear;
  }

  public Card first6(String first6) {
    this.first6 = first6;
    return this;
  }

  /**
   * Get first6
   * @return first6
  **/
  @ApiModelProperty(value = "")


  public String getFirst6() {
    return first6;
  }

  public void setFirst6(String first6) {
    this.first6 = first6;
  }

  public Card last4(String last4) {
    this.last4 = last4;
    return this;
  }

  /**
   * Get last4
   * @return last4
  **/
  @ApiModelProperty(value = "")


  public String getLast4() {
    return last4;
  }

  public void setLast4(String last4) {
    this.last4 = last4;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.id, card.id) &&
        Objects.equals(this.brand, card.brand) &&
        Objects.equals(this.cvcCheck, card.cvcCheck) &&
        Objects.equals(this.expMonth, card.expMonth) &&
        Objects.equals(this.expYear, card.expYear) &&
        Objects.equals(this.first6, card.first6) &&
        Objects.equals(this.last4, card.last4);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, cvcCheck, expMonth, expYear, first6, last4);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    cvcCheck: ").append(toIndentedString(cvcCheck)).append("\n");
    sb.append("    expMonth: ").append(toIndentedString(expMonth)).append("\n");
    sb.append("    expYear: ").append(toIndentedString(expYear)).append("\n");
    sb.append("    first6: ").append(toIndentedString(first6)).append("\n");
    sb.append("    last4: ").append(toIndentedString(last4)).append("\n");
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

