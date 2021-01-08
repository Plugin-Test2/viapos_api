/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package viapos.external.cardconnect.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Profile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-20T23:05:49.165Z")



public class Profile {
  @SerializedName("profileid")
  private String profileid = null;

  @SerializedName("acctid")
  private String acctid = null;

  @SerializedName("respstat")
  private String respstat = null;

  @SerializedName("token")
  private String token = null;

  @SerializedName("accttype")
  private String accttype = null;

  @SerializedName("expiry")
  private String expiry = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("address")
  private String address = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("region")
  private String region = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("phone")
  private String phone = null;

  @SerializedName("postal")
  private String postal = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("company")
  private String company = null;

  @SerializedName("defaultacct")
  private String defaultacct = null;

  @SerializedName("gsacard")
  private String gsacard = null;

  @SerializedName("auoptout")
  private String auoptout = null;

  public Profile profileid(String profileid) {
    this.profileid = profileid;
    return this;
  }

   /**
   * Get profileid
   * @return profileid
  **/
  @ApiModelProperty(value = "")
  public String getProfileid() {
    return profileid;
  }

  public void setProfileid(String profileid) {
    this.profileid = profileid;
  }

  public Profile acctid(String acctid) {
    this.acctid = acctid;
    return this;
  }

   /**
   * Get acctid
   * @return acctid
  **/
  @ApiModelProperty(value = "")
  public String getAcctid() {
    return acctid;
  }

  public void setAcctid(String acctid) {
    this.acctid = acctid;
  }

  public Profile respstat(String respstat) {
    this.respstat = respstat;
    return this;
  }

   /**
   * Get respstat
   * @return respstat
  **/
  @ApiModelProperty(value = "")
  public String getRespstat() {
    return respstat;
  }

  public void setRespstat(String respstat) {
    this.respstat = respstat;
  }

  public Profile token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(value = "")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Profile accttype(String accttype) {
    this.accttype = accttype;
    return this;
  }

   /**
   * Get accttype
   * @return accttype
  **/
  @ApiModelProperty(value = "")
  public String getAccttype() {
    return accttype;
  }

  public void setAccttype(String accttype) {
    this.accttype = accttype;
  }

  public Profile expiry(String expiry) {
    this.expiry = expiry;
    return this;
  }

   /**
   * Get expiry
   * @return expiry
  **/
  @ApiModelProperty(value = "")
  public String getExpiry() {
    return expiry;
  }

  public void setExpiry(String expiry) {
    this.expiry = expiry;
  }

  public Profile name(String name) {
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

  public Profile address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Profile city(String city) {
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

  public Profile region(String region) {
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

  public Profile country(String country) {
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

  public Profile phone(String phone) {
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

  public Profile postal(String postal) {
    this.postal = postal;
    return this;
  }

   /**
   * Get postal
   * @return postal
  **/
  @ApiModelProperty(value = "")
  public String getPostal() {
    return postal;
  }

  public void setPostal(String postal) {
    this.postal = postal;
  }

  public Profile email(String email) {
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

  public Profile company(String company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(value = "")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Profile defaultacct(String defaultacct) {
    this.defaultacct = defaultacct;
    return this;
  }

   /**
   * Get defaultacct
   * @return defaultacct
  **/
  @ApiModelProperty(value = "")
  public String getDefaultacct() {
    return defaultacct;
  }

  public void setDefaultacct(String defaultacct) {
    this.defaultacct = defaultacct;
  }

  public Profile gsacard(String gsacard) {
    this.gsacard = gsacard;
    return this;
  }

   /**
   * Get gsacard
   * @return gsacard
  **/
  @ApiModelProperty(value = "")
  public String getGsacard() {
    return gsacard;
  }

  public void setGsacard(String gsacard) {
    this.gsacard = gsacard;
  }

  public Profile auoptout(String auoptout) {
    this.auoptout = auoptout;
    return this;
  }

   /**
   * Get auoptout
   * @return auoptout
  **/
  @ApiModelProperty(value = "")
  public String getAuoptout() {
    return auoptout;
  }

  public void setAuoptout(String auoptout) {
    this.auoptout = auoptout;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(this.profileid, profile.profileid) &&
        Objects.equals(this.acctid, profile.acctid) &&
        Objects.equals(this.respstat, profile.respstat) &&
        Objects.equals(this.token, profile.token) &&
        Objects.equals(this.accttype, profile.accttype) &&
        Objects.equals(this.expiry, profile.expiry) &&
        Objects.equals(this.name, profile.name) &&
        Objects.equals(this.address, profile.address) &&
        Objects.equals(this.city, profile.city) &&
        Objects.equals(this.region, profile.region) &&
        Objects.equals(this.country, profile.country) &&
        Objects.equals(this.phone, profile.phone) &&
        Objects.equals(this.postal, profile.postal) &&
        Objects.equals(this.email, profile.email) &&
        Objects.equals(this.company, profile.company) &&
        Objects.equals(this.defaultacct, profile.defaultacct) &&
        Objects.equals(this.gsacard, profile.gsacard) &&
        Objects.equals(this.auoptout, profile.auoptout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profileid, acctid, respstat, token, accttype, expiry, name, address, city, region, country, phone, postal, email, company, defaultacct, gsacard, auoptout);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profile {\n");
    
    sb.append("    profileid: ").append(toIndentedString(profileid)).append("\n");
    sb.append("    acctid: ").append(toIndentedString(acctid)).append("\n");
    sb.append("    respstat: ").append(toIndentedString(respstat)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    accttype: ").append(toIndentedString(accttype)).append("\n");
    sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    postal: ").append(toIndentedString(postal)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    defaultacct: ").append(toIndentedString(defaultacct)).append("\n");
    sb.append("    gsacard: ").append(toIndentedString(gsacard)).append("\n");
    sb.append("    auoptout: ").append(toIndentedString(auoptout)).append("\n");
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

