package viapos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentPlan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-06T23:36:52.493Z")




public class PaymentPlan   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("occurrence")
  private String occurrence = null;

  @JsonProperty("startDate")
  private String startDate = null;

  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("completed")
  private Boolean completed = null;

  @JsonProperty("name")
  private String name = null;

  public PaymentPlan id(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public PaymentPlan occurrence(String occurrence) {
    this.occurrence = occurrence;
    return this;
  }

  /**
   * Get occurrence
   * @return occurrence
  **/
  @ApiModelProperty(value = "")


  public String getOccurrence() {
    return occurrence;
  }

  public void setOccurrence(String occurrence) {
    this.occurrence = occurrence;
  }

  public PaymentPlan startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public PaymentPlan amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public PaymentPlan currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public PaymentPlan status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get limit
   * @return limit
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  /**
   * Get frozen
   * @return frozen
  **/
  @ApiModelProperty(value = "")


  public PaymentPlan completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * Get completed
   * @return completed
  **/
  @ApiModelProperty(value = "")


  public Boolean isCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentPlan paymentPlan = (PaymentPlan) o;
    return Objects.equals(this.id, paymentPlan.id) &&
        Objects.equals(this.occurrence, paymentPlan.occurrence) &&
        Objects.equals(this.startDate, paymentPlan.startDate) &&
        Objects.equals(this.amount, paymentPlan.amount) &&
        Objects.equals(this.currency, paymentPlan.currency) &&
        Objects.equals(this.status, paymentPlan.status) &&
        Objects.equals(this.completed, paymentPlan.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, occurrence, startDate, amount, currency, status, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentPlan {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    occurrence: ").append(toIndentedString(occurrence)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    limit: ").append(toIndentedString(status)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
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

