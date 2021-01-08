package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CloverCharge
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")




public class ChargeRequest {
  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("capture")
  private Boolean capture = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("ecomind")
  private String ecomind = null;

  @JsonProperty("external_reference_id")
  private String externalReferenceId = null;

  @JsonProperty("receipt_email")
  private String receiptEmail = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("stored_credentials")
  private StoredCredentials storedCredentials = null;

  @JsonProperty("tax_amount")
  private Integer taxAmount = null;

  @JsonProperty("tip_amount")
  private Integer tipAmount = null;

  @JsonProperty("tender")
  private Tender tender = null;

  public ChargeRequest amount(Integer amount) {
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

  public ChargeRequest currency(String currency) {
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

  public ChargeRequest capture(Boolean capture) {
    this.capture = capture;
    return this;
  }

  /**
   * Get capture
   * @return capture
  **/
  @ApiModelProperty(value = "")


  public Boolean isCapture() {
    return capture;
  }

  public void setCapture(Boolean capture) {
    this.capture = capture;
  }

  public ChargeRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ChargeRequest ecomind(String ecomind) {
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

  public ChargeRequest externalReferenceId(String externalReferenceId) {
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

  public ChargeRequest receiptEmail(String receiptEmail) {
    this.receiptEmail = receiptEmail;
    return this;
  }

  /**
   * Get receiptEmail
   * @return receiptEmail
  **/
  @ApiModelProperty(value = "")


  public String getReceiptEmail() {
    return receiptEmail;
  }

  public void setReceiptEmail(String receiptEmail) {
    this.receiptEmail = receiptEmail;
  }

  public ChargeRequest source(String source) {
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

  public ChargeRequest storedCredentials(StoredCredentials storedCredentials) {
    this.storedCredentials = storedCredentials;
    return this;
  }

  /**
   * Get storedCredentials
   * @return storedCredentials
  **/
  @ApiModelProperty(value = "")

  @Valid

  public StoredCredentials getStoredCredentials() {
    return storedCredentials;
  }

  public void setStoredCredentials(StoredCredentials storedCredentials) {
    this.storedCredentials = storedCredentials;
  }

  public ChargeRequest taxAmount(Integer taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

  /**
   * Get taxAmount
   * @return taxAmount
  **/
  @ApiModelProperty(value = "")


  public Integer getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Integer taxAmount) {
    this.taxAmount = taxAmount;
  }

  public ChargeRequest tipAmount(Integer tipAmount) {
    this.tipAmount = tipAmount;
    return this;
  }

  /**
   * Get tipAmount
   * @return tipAmount
  **/
  @ApiModelProperty(value = "")


  public Integer getTipAmount() {
    return tipAmount;
  }

  public void setTipAmount(Integer tipAmount) {
    this.tipAmount = tipAmount;
  }

  public ChargeRequest tender(Tender tender) {
    this.tender = tender;
    return this;
  }

  /**
   * Get tender
   * @return tender
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Tender getTender() {
    return tender;
  }

  public void setTender(Tender tender) {
    this.tender = tender;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargeRequest cloverCharge = (ChargeRequest) o;
    return Objects.equals(this.amount, cloverCharge.amount) &&
        Objects.equals(this.currency, cloverCharge.currency) &&
        Objects.equals(this.capture, cloverCharge.capture) &&
        Objects.equals(this.description, cloverCharge.description) &&
        Objects.equals(this.ecomind, cloverCharge.ecomind) &&
        Objects.equals(this.externalReferenceId, cloverCharge.externalReferenceId) &&
        Objects.equals(this.receiptEmail, cloverCharge.receiptEmail) &&
        Objects.equals(this.source, cloverCharge.source) &&
        Objects.equals(this.storedCredentials, cloverCharge.storedCredentials) &&
        Objects.equals(this.taxAmount, cloverCharge.taxAmount) &&
        Objects.equals(this.tipAmount, cloverCharge.tipAmount) &&
        Objects.equals(this.tender, cloverCharge.tender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, capture, description, ecomind, externalReferenceId, receiptEmail, source, storedCredentials, taxAmount, tipAmount, tender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloverCharge {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    capture: ").append(toIndentedString(capture)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    ecomind: ").append(toIndentedString(ecomind)).append("\n");
    sb.append("    externalReferenceId: ").append(toIndentedString(externalReferenceId)).append("\n");
    sb.append("    receiptEmail: ").append(toIndentedString(receiptEmail)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    storedCredentials: ").append(toIndentedString(storedCredentials)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    tipAmount: ").append(toIndentedString(tipAmount)).append("\n");
    sb.append("    tender: ").append(toIndentedString(tender)).append("\n");
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

