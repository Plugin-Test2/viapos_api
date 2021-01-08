package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CloverStoredCredentials
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")




public class StoredCredentials {
  @JsonProperty("sequence")
  private String sequence = null;

  @JsonProperty("is_scheduled")
  private Boolean isScheduled = null;

  @JsonProperty("cardbrand_original_amount")
  private String cardbrandOriginalAmount = null;

  @JsonProperty("initiator")
  private String initiator = null;

  @JsonProperty("installment_info")
  private InstallmentInfo installmentInfo = null;

  public StoredCredentials sequence(String sequence) {
    this.sequence = sequence;
    return this;
  }

  /**
   * Get sequence
   * @return sequence
  **/
  @ApiModelProperty(value = "")


  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }

  public StoredCredentials isScheduled(Boolean isScheduled) {
    this.isScheduled = isScheduled;
    return this;
  }

  /**
   * Get isScheduled
   * @return isScheduled
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsScheduled() {
    return isScheduled;
  }

  public void setIsScheduled(Boolean isScheduled) {
    this.isScheduled = isScheduled;
  }

  public StoredCredentials cardbrandOriginalAmount(String cardbrandOriginalAmount) {
    this.cardbrandOriginalAmount = cardbrandOriginalAmount;
    return this;
  }

  /**
   * Get cardbrandOriginalAmount
   * @return cardbrandOriginalAmount
  **/
  @ApiModelProperty(value = "")


  public String getCardbrandOriginalAmount() {
    return cardbrandOriginalAmount;
  }

  public void setCardbrandOriginalAmount(String cardbrandOriginalAmount) {
    this.cardbrandOriginalAmount = cardbrandOriginalAmount;
  }

  public StoredCredentials initiator(String initiator) {
    this.initiator = initiator;
    return this;
  }

  /**
   * Get initiator
   * @return initiator
  **/
  @ApiModelProperty(value = "")


  public String getInitiator() {
    return initiator;
  }

  public void setInitiator(String initiator) {
    this.initiator = initiator;
  }

  public StoredCredentials installmentInfo(InstallmentInfo installmentInfo) {
    this.installmentInfo = installmentInfo;
    return this;
  }

  /**
   * Get installmentInfo
   * @return installmentInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public InstallmentInfo getInstallmentInfo() {
    return installmentInfo;
  }

  public void setInstallmentInfo(InstallmentInfo installmentInfo) {
    this.installmentInfo = installmentInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoredCredentials cloverStoredCredentials = (StoredCredentials) o;
    return Objects.equals(this.sequence, cloverStoredCredentials.sequence) &&
        Objects.equals(this.isScheduled, cloverStoredCredentials.isScheduled) &&
        Objects.equals(this.cardbrandOriginalAmount, cloverStoredCredentials.cardbrandOriginalAmount) &&
        Objects.equals(this.initiator, cloverStoredCredentials.initiator) &&
        Objects.equals(this.installmentInfo, cloverStoredCredentials.installmentInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequence, isScheduled, cardbrandOriginalAmount, initiator, installmentInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloverStoredCredentials {\n");
    
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
    sb.append("    isScheduled: ").append(toIndentedString(isScheduled)).append("\n");
    sb.append("    cardbrandOriginalAmount: ").append(toIndentedString(cardbrandOriginalAmount)).append("\n");
    sb.append("    initiator: ").append(toIndentedString(initiator)).append("\n");
    sb.append("    installmentInfo: ").append(toIndentedString(installmentInfo)).append("\n");
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

