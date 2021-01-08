package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * CloverRefund
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")




public class Refund {
  @JsonProperty("charge")
  private String charge = null;

  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("external_reference_id")
  private String externalReferenceId = null;

  @JsonProperty("reason")
  private String reason = null;

  public Refund charge(String charge) {
    this.charge = charge;
    return this;
  }

  /**
   * Get charge
   * @return charge
  **/
  @ApiModelProperty(value = "")


  public String getCharge() {
    return charge;
  }

  public void setCharge(String charge) {
    this.charge = charge;
  }

  public Refund amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Refund externalReferenceId(String externalReferenceId) {
    this.externalReferenceId = externalReferenceId;
    return this;
  }

  /**
   * Get externalReferenceId
   * @return externalReferenceId
  **/
  @ApiModelProperty(value = "")


  public String getExternalReferenceId() {
    return externalReferenceId;
  }

  public void setExternalReferenceId(String externalReferenceId) {
    this.externalReferenceId = externalReferenceId;
  }

  public Refund reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
  **/
  @ApiModelProperty(value = "")


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Refund cloverRefund = (Refund) o;
    return Objects.equals(this.charge, cloverRefund.charge) &&
        Objects.equals(this.amount, cloverRefund.amount) &&
        Objects.equals(this.externalReferenceId, cloverRefund.externalReferenceId) &&
        Objects.equals(this.reason, cloverRefund.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(charge, amount, externalReferenceId, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloverRefund {\n");
    
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    externalReferenceId: ").append(toIndentedString(externalReferenceId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

