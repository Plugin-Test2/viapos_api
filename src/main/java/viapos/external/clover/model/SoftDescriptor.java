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
 * SoftDescriptor
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-14T02:13:56.788Z")




public class SoftDescriptor   {
  @JsonProperty("dba_name")
  private String dbaName = null;

  @JsonProperty("street")
  private String street = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("region")
  private String region = null;

  @JsonProperty("postal_code")
  private String postalCode = null;

  @JsonProperty("country_code")
  private String countryCode = null;

  @JsonProperty("merchant_contact_info")
  private String merchantContactInfo = null;

  public SoftDescriptor dbaName(String dbaName) {
    this.dbaName = dbaName;
    return this;
  }

  /**
   * Get dbaName
   * @return dbaName
  **/
  @ApiModelProperty(value = "")


  public String getDbaName() {
    return dbaName;
  }

  public void setDbaName(String dbaName) {
    this.dbaName = dbaName;
  }

  public SoftDescriptor street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get street
   * @return street
  **/
  @ApiModelProperty(value = "")


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public SoftDescriptor city(String city) {
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

  public SoftDescriptor region(String region) {
    this.region = region;
    return this;
  }

  /**
   * Get region
   * @return region
  **/
  @ApiModelProperty(value = "")


  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public SoftDescriptor postalCode(String postalCode) {
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

  public SoftDescriptor countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
  **/
  @ApiModelProperty(value = "")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public SoftDescriptor merchantContactInfo(String merchantContactInfo) {
    this.merchantContactInfo = merchantContactInfo;
    return this;
  }

  /**
   * Get merchantContactInfo
   * @return merchantContactInfo
  **/
  @ApiModelProperty(value = "")


  public String getMerchantContactInfo() {
    return merchantContactInfo;
  }

  public void setMerchantContactInfo(String merchantContactInfo) {
    this.merchantContactInfo = merchantContactInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoftDescriptor softDescriptor = (SoftDescriptor) o;
    return Objects.equals(this.dbaName, softDescriptor.dbaName) &&
        Objects.equals(this.street, softDescriptor.street) &&
        Objects.equals(this.city, softDescriptor.city) &&
        Objects.equals(this.region, softDescriptor.region) &&
        Objects.equals(this.postalCode, softDescriptor.postalCode) &&
        Objects.equals(this.countryCode, softDescriptor.countryCode) &&
        Objects.equals(this.merchantContactInfo, softDescriptor.merchantContactInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dbaName, street, city, region, postalCode, countryCode, merchantContactInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoftDescriptor {\n");
    
    sb.append("    dbaName: ").append(toIndentedString(dbaName)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    merchantContactInfo: ").append(toIndentedString(merchantContactInfo)).append("\n");
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

