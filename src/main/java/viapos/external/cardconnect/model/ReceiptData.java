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
 * ReceiptData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-20T23:05:49.165Z")



public class ReceiptData {
  @SerializedName("header")
  private String header = null;

  @SerializedName("footer")
  private String footer = null;

  @SerializedName("dba")
  private String dba = null;

  @SerializedName("address1")
  private String address1 = null;

  @SerializedName("address2")
  private String address2 = null;

  @SerializedName("phone")
  private String phone = null;

  @SerializedName("dateTime")
  private String dateTime = null;

  @SerializedName("nameOnCard")
  private String nameOnCard = null;

  @SerializedName("orderNote")
  private String orderNote = null;

  public ReceiptData header(String header) {
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public ReceiptData footer(String footer) {
    this.footer = footer;
    return this;
  }

   /**
   * Get footer
   * @return footer
  **/
  @ApiModelProperty(value = "")
  public String getFooter() {
    return footer;
  }

  public void setFooter(String footer) {
    this.footer = footer;
  }

  public ReceiptData dba(String dba) {
    this.dba = dba;
    return this;
  }

   /**
   * Get dba
   * @return dba
  **/
  @ApiModelProperty(value = "")
  public String getDba() {
    return dba;
  }

  public void setDba(String dba) {
    this.dba = dba;
  }

  public ReceiptData address1(String address1) {
    this.address1 = address1;
    return this;
  }

   /**
   * Get address1
   * @return address1
  **/
  @ApiModelProperty(value = "")
  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public ReceiptData address2(String address2) {
    this.address2 = address2;
    return this;
  }

   /**
   * Get address2
   * @return address2
  **/
  @ApiModelProperty(value = "")
  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public ReceiptData phone(String phone) {
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

  public ReceiptData dateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

   /**
   * Get dateTime
   * @return dateTime
  **/
  @ApiModelProperty(value = "")
  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public ReceiptData nameOnCard(String nameOnCard) {
    this.nameOnCard = nameOnCard;
    return this;
  }

   /**
   * Get nameOnCard
   * @return nameOnCard
  **/
  @ApiModelProperty(value = "")
  public String getNameOnCard() {
    return nameOnCard;
  }

  public void setNameOnCard(String nameOnCard) {
    this.nameOnCard = nameOnCard;
  }

  public ReceiptData orderNote(String orderNote) {
    this.orderNote = orderNote;
    return this;
  }

   /**
   * Get orderNote
   * @return orderNote
  **/
  @ApiModelProperty(value = "")
  public String getOrderNote() {
    return orderNote;
  }

  public void setOrderNote(String orderNote) {
    this.orderNote = orderNote;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceiptData receiptData = (ReceiptData) o;
    return Objects.equals(this.header, receiptData.header) &&
        Objects.equals(this.footer, receiptData.footer) &&
        Objects.equals(this.dba, receiptData.dba) &&
        Objects.equals(this.address1, receiptData.address1) &&
        Objects.equals(this.address2, receiptData.address2) &&
        Objects.equals(this.phone, receiptData.phone) &&
        Objects.equals(this.dateTime, receiptData.dateTime) &&
        Objects.equals(this.nameOnCard, receiptData.nameOnCard) &&
        Objects.equals(this.orderNote, receiptData.orderNote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, footer, dba, address1, address2, phone, dateTime, nameOnCard, orderNote);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceiptData {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    footer: ").append(toIndentedString(footer)).append("\n");
    sb.append("    dba: ").append(toIndentedString(dba)).append("\n");
    sb.append("    address1: ").append(toIndentedString(address1)).append("\n");
    sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    nameOnCard: ").append(toIndentedString(nameOnCard)).append("\n");
    sb.append("    orderNote: ").append(toIndentedString(orderNote)).append("\n");
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
