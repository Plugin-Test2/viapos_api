package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * CloverInstallmentInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")




public class InstallmentInfo {
  @JsonProperty("bill_pay_indicator")
  private String billPayIndicator = null;

  @JsonProperty("invoice_number")
  private String invoiceNumber = null;

  @JsonProperty("description")
  private String description = null;

  public InstallmentInfo billPayIndicator(String billPayIndicator) {
    this.billPayIndicator = billPayIndicator;
    return this;
  }

  /**
   * Get billPayIndicator
   * @return billPayIndicator
  **/
  @ApiModelProperty(value = "")


  public String getBillPayIndicator() {
    return billPayIndicator;
  }

  public void setBillPayIndicator(String billPayIndicator) {
    this.billPayIndicator = billPayIndicator;
  }

  public InstallmentInfo invoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;
  }

  /**
   * Get invoiceNumber
   * @return invoiceNumber
  **/
  @ApiModelProperty(value = "")


  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public InstallmentInfo description(String description) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallmentInfo cloverInstallmentInfo = (InstallmentInfo) o;
    return Objects.equals(this.billPayIndicator, cloverInstallmentInfo.billPayIndicator) &&
        Objects.equals(this.invoiceNumber, cloverInstallmentInfo.invoiceNumber) &&
        Objects.equals(this.description, cloverInstallmentInfo.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billPayIndicator, invoiceNumber, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloverInstallmentInfo {\n");
    
    sb.append("    billPayIndicator: ").append(toIndentedString(billPayIndicator)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

