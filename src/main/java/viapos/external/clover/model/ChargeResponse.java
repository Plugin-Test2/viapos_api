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
 * ChargeResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-14T02:13:56.788Z")




public class ChargeResponse   {
  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("tax_amount")
  private Integer taxAmount = null;

  @JsonProperty("tip_amount")
  private Integer tipAmount = null;

  @JsonProperty("amount_refunded")
  private Integer amountRefunded = null;

  @JsonProperty("billing_details")
  private BillingDetails billingDetails = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("line1")
  private String line1 = null;

  @JsonProperty("line2")
  private String line2 = null;

  @JsonProperty("postal_code")
  private String postalCode = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("captured")
  private Boolean captured = null;

  @JsonProperty("created")
  private Long created = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("external_reference_id")
  private String externalReferenceId = null;

  @JsonProperty("auth_code")
  private String authCode = null;

  @JsonProperty("ref_num")
  private String refNum = null;

  @JsonProperty("failure_code")
  private String failureCode = null;

  @JsonProperty("failure_message")
  private String failureMessage = null;

  @JsonProperty("warning_message")
  private String warningMessage = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("livemode")
  private Boolean livemode = null;

  @JsonProperty("paid")
  private Boolean paid = null;

  @JsonProperty("payment_method")
  private String paymentMethod = null;

  @JsonProperty("receipt_email")
  private String receiptEmail = null;

  @JsonProperty("receipt_number")
  private String receiptNumber = null;

  @JsonProperty("receipt_url")
  private String receiptUrl = null;

  @JsonProperty("refunded")
  private Boolean refunded = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("carrier")
  private String carrier = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("tracking_number")
  private String trackingNumber = null;

  @JsonProperty("source")
  private Card source = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("stored_credentials")
  private StoredCredentials storedCredentials = null;

  @JsonProperty("soft_descriptor")
  private SoftDescriptor softDescriptor = null;

  public ChargeResponse amount(Integer amount) {
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

  public ChargeResponse taxAmount(Integer taxAmount) {
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

  public ChargeResponse tipAmount(Integer tipAmount) {
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

  public ChargeResponse amountRefunded(Integer amountRefunded) {
    this.amountRefunded = amountRefunded;
    return this;
  }

  /**
   * Get amountRefunded
   * @return amountRefunded
  **/
  @ApiModelProperty(value = "")


  public Integer getAmountRefunded() {
    return amountRefunded;
  }

  public void setAmountRefunded(Integer amountRefunded) {
    this.amountRefunded = amountRefunded;
  }

  public ChargeResponse billingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Get billingDetails
   * @return billingDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillingDetails getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
  }

  public ChargeResponse city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ChargeResponse country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ChargeResponse line1(String line1) {
    this.line1 = line1;
    return this;
  }

  /**
   * Get line1
   * @return line1
  **/
  @ApiModelProperty(value = "")


  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public ChargeResponse line2(String line2) {
    this.line2 = line2;
    return this;
  }

  /**
   * Get line2
   * @return line2
  **/
  @ApiModelProperty(value = "")


  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public ChargeResponse postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  **/
  @ApiModelProperty(value = "")


  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public ChargeResponse state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ChargeResponse captured(Boolean captured) {
    this.captured = captured;
    return this;
  }

  /**
   * Get captured
   * @return captured
  **/
  @ApiModelProperty(value = "")


  public Boolean isCaptured() {
    return captured;
  }

  public void setCaptured(Boolean captured) {
    this.captured = captured;
  }

  public ChargeResponse created(Long created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")


  public Long getCreated() {
    return created;
  }

  public void setCreated(Long created) {
    this.created = created;
  }

  public ChargeResponse currency(String currency) {
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

  public ChargeResponse description(String description) {
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

  public ChargeResponse externalReferenceId(String externalReferenceId) {
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

  public ChargeResponse authCode(String authCode) {
    this.authCode = authCode;
    return this;
  }

  /**
   * Get authCode
   * @return authCode
  **/
  @ApiModelProperty(value = "")


  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public ChargeResponse refNum(String refNum) {
    this.refNum = refNum;
    return this;
  }

  /**
   * Get refNum
   * @return refNum
  **/
  @ApiModelProperty(value = "")


  public String getRefNum() {
    return refNum;
  }

  public void setRefNum(String refNum) {
    this.refNum = refNum;
  }

  public ChargeResponse failureCode(String failureCode) {
    this.failureCode = failureCode;
    return this;
  }

  /**
   * Get failureCode
   * @return failureCode
  **/
  @ApiModelProperty(value = "")


  public String getFailureCode() {
    return failureCode;
  }

  public void setFailureCode(String failureCode) {
    this.failureCode = failureCode;
  }

  public ChargeResponse failureMessage(String failureMessage) {
    this.failureMessage = failureMessage;
    return this;
  }

  /**
   * Get failureMessage
   * @return failureMessage
  **/
  @ApiModelProperty(value = "")


  public String getFailureMessage() {
    return failureMessage;
  }

  public void setFailureMessage(String failureMessage) {
    this.failureMessage = failureMessage;
  }

  public ChargeResponse warningMessage(String warningMessage) {
    this.warningMessage = warningMessage;
    return this;
  }

  /**
   * Get warningMessage
   * @return warningMessage
  **/
  @ApiModelProperty(value = "")


  public String getWarningMessage() {
    return warningMessage;
  }

  public void setWarningMessage(String warningMessage) {
    this.warningMessage = warningMessage;
  }

  public ChargeResponse id(String id) {
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

  public ChargeResponse livemode(Boolean livemode) {
    this.livemode = livemode;
    return this;
  }

  /**
   * Get livemode
   * @return livemode
  **/
  @ApiModelProperty(value = "")


  public Boolean isLivemode() {
    return livemode;
  }

  public void setLivemode(Boolean livemode) {
    this.livemode = livemode;
  }

  public ChargeResponse paid(Boolean paid) {
    this.paid = paid;
    return this;
  }

  /**
   * Get paid
   * @return paid
  **/
  @ApiModelProperty(value = "")


  public Boolean isPaid() {
    return paid;
  }

  public void setPaid(Boolean paid) {
    this.paid = paid;
  }

  public ChargeResponse paymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")


  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public ChargeResponse receiptEmail(String receiptEmail) {
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

  public ChargeResponse receiptNumber(String receiptNumber) {
    this.receiptNumber = receiptNumber;
    return this;
  }

  /**
   * Get receiptNumber
   * @return receiptNumber
  **/
  @ApiModelProperty(value = "")


  public String getReceiptNumber() {
    return receiptNumber;
  }

  public void setReceiptNumber(String receiptNumber) {
    this.receiptNumber = receiptNumber;
  }

  public ChargeResponse receiptUrl(String receiptUrl) {
    this.receiptUrl = receiptUrl;
    return this;
  }

  /**
   * Get receiptUrl
   * @return receiptUrl
  **/
  @ApiModelProperty(value = "")


  public String getReceiptUrl() {
    return receiptUrl;
  }

  public void setReceiptUrl(String receiptUrl) {
    this.receiptUrl = receiptUrl;
  }

  public ChargeResponse refunded(Boolean refunded) {
    this.refunded = refunded;
    return this;
  }

  /**
   * Get refunded
   * @return refunded
  **/
  @ApiModelProperty(value = "")


  public Boolean isRefunded() {
    return refunded;
  }

  public void setRefunded(Boolean refunded) {
    this.refunded = refunded;
  }

  public ChargeResponse address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public ChargeResponse carrier(String carrier) {
    this.carrier = carrier;
    return this;
  }

  /**
   * Get carrier
   * @return carrier
  **/
  @ApiModelProperty(value = "")


  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public ChargeResponse name(String name) {
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

  public ChargeResponse phone(String phone) {
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

  public ChargeResponse trackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
    return this;
  }

  /**
   * Get trackingNumber
   * @return trackingNumber
  **/
  @ApiModelProperty(value = "")


  public String getTrackingNumber() {
    return trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public ChargeResponse source(Card source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")


  public Card getSource() {
    return source;
  }

  public void setSource(Card source) {
    this.source = source;
  }

  public ChargeResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ChargeResponse storedCredentials(StoredCredentials storedCredentials) {
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

  public ChargeResponse softDescriptor(SoftDescriptor softDescriptor) {
    this.softDescriptor = softDescriptor;
    return this;
  }

  /**
   * Get softDescriptor
   * @return softDescriptor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SoftDescriptor getSoftDescriptor() {
    return softDescriptor;
  }

  public void setSoftDescriptor(SoftDescriptor softDescriptor) {
    this.softDescriptor = softDescriptor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargeResponse chargeResponse = (ChargeResponse) o;
    return Objects.equals(this.amount, chargeResponse.amount) &&
        Objects.equals(this.taxAmount, chargeResponse.taxAmount) &&
        Objects.equals(this.tipAmount, chargeResponse.tipAmount) &&
        Objects.equals(this.amountRefunded, chargeResponse.amountRefunded) &&
        Objects.equals(this.billingDetails, chargeResponse.billingDetails) &&
        Objects.equals(this.city, chargeResponse.city) &&
        Objects.equals(this.country, chargeResponse.country) &&
        Objects.equals(this.line1, chargeResponse.line1) &&
        Objects.equals(this.line2, chargeResponse.line2) &&
        Objects.equals(this.postalCode, chargeResponse.postalCode) &&
        Objects.equals(this.state, chargeResponse.state) &&
        Objects.equals(this.captured, chargeResponse.captured) &&
        Objects.equals(this.created, chargeResponse.created) &&
        Objects.equals(this.currency, chargeResponse.currency) &&
        Objects.equals(this.description, chargeResponse.description) &&
        Objects.equals(this.externalReferenceId, chargeResponse.externalReferenceId) &&
        Objects.equals(this.authCode, chargeResponse.authCode) &&
        Objects.equals(this.refNum, chargeResponse.refNum) &&
        Objects.equals(this.failureCode, chargeResponse.failureCode) &&
        Objects.equals(this.failureMessage, chargeResponse.failureMessage) &&
        Objects.equals(this.warningMessage, chargeResponse.warningMessage) &&
        Objects.equals(this.id, chargeResponse.id) &&
        Objects.equals(this.livemode, chargeResponse.livemode) &&
        Objects.equals(this.paid, chargeResponse.paid) &&
        Objects.equals(this.paymentMethod, chargeResponse.paymentMethod) &&
        Objects.equals(this.receiptEmail, chargeResponse.receiptEmail) &&
        Objects.equals(this.receiptNumber, chargeResponse.receiptNumber) &&
        Objects.equals(this.receiptUrl, chargeResponse.receiptUrl) &&
        Objects.equals(this.refunded, chargeResponse.refunded) &&
        Objects.equals(this.address, chargeResponse.address) &&
        Objects.equals(this.carrier, chargeResponse.carrier) &&
        Objects.equals(this.name, chargeResponse.name) &&
        Objects.equals(this.phone, chargeResponse.phone) &&
        Objects.equals(this.trackingNumber, chargeResponse.trackingNumber) &&
        Objects.equals(this.source, chargeResponse.source) &&
        Objects.equals(this.status, chargeResponse.status) &&
        Objects.equals(this.storedCredentials, chargeResponse.storedCredentials) &&
        Objects.equals(this.softDescriptor, chargeResponse.softDescriptor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, taxAmount, tipAmount, amountRefunded, billingDetails, city, country, line1, line2, postalCode, state, captured, created, currency, description, externalReferenceId, authCode, refNum, failureCode, failureMessage, warningMessage, id, livemode, paid, paymentMethod, receiptEmail, receiptNumber, receiptUrl, refunded, address, carrier, name, phone, trackingNumber, source, status, storedCredentials, softDescriptor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChargeResponse {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    tipAmount: ").append(toIndentedString(tipAmount)).append("\n");
    sb.append("    amountRefunded: ").append(toIndentedString(amountRefunded)).append("\n");
    sb.append("    billingDetails: ").append(toIndentedString(billingDetails)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    captured: ").append(toIndentedString(captured)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    externalReferenceId: ").append(toIndentedString(externalReferenceId)).append("\n");
    sb.append("    authCode: ").append(toIndentedString(authCode)).append("\n");
    sb.append("    refNum: ").append(toIndentedString(refNum)).append("\n");
    sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
    sb.append("    failureMessage: ").append(toIndentedString(failureMessage)).append("\n");
    sb.append("    warningMessage: ").append(toIndentedString(warningMessage)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    livemode: ").append(toIndentedString(livemode)).append("\n");
    sb.append("    paid: ").append(toIndentedString(paid)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    receiptEmail: ").append(toIndentedString(receiptEmail)).append("\n");
    sb.append("    receiptNumber: ").append(toIndentedString(receiptNumber)).append("\n");
    sb.append("    receiptUrl: ").append(toIndentedString(receiptUrl)).append("\n");
    sb.append("    refunded: ").append(toIndentedString(refunded)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    trackingNumber: ").append(toIndentedString(trackingNumber)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    storedCredentials: ").append(toIndentedString(storedCredentials)).append("\n");
    sb.append("    softDescriptor: ").append(toIndentedString(softDescriptor)).append("\n");
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

