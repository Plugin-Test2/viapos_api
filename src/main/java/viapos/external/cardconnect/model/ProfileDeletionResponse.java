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
 * ProfileDeletionResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-20T23:05:49.165Z")



public class ProfileDeletionResponse {
  @SerializedName("resptext")
  private String resptext = null;

  @SerializedName("respcode")
  private String respcode = null;

  @SerializedName("respproc")
  private String respproc = null;

  @SerializedName("respstat")
  private String respstat = null;

  public ProfileDeletionResponse resptext(String resptext) {
    this.resptext = resptext;
    return this;
  }

   /**
   * Get resptext
   * @return resptext
  **/
  @ApiModelProperty(value = "")
  public String getResptext() {
    return resptext;
  }

  public void setResptext(String resptext) {
    this.resptext = resptext;
  }

  public ProfileDeletionResponse respcode(String respcode) {
    this.respcode = respcode;
    return this;
  }

   /**
   * Get respcode
   * @return respcode
  **/
  @ApiModelProperty(value = "")
  public String getRespcode() {
    return respcode;
  }

  public void setRespcode(String respcode) {
    this.respcode = respcode;
  }

  public ProfileDeletionResponse respproc(String respproc) {
    this.respproc = respproc;
    return this;
  }

   /**
   * Get respproc
   * @return respproc
  **/
  @ApiModelProperty(value = "")
  public String getRespproc() {
    return respproc;
  }

  public void setRespproc(String respproc) {
    this.respproc = respproc;
  }

  public ProfileDeletionResponse respstat(String respstat) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfileDeletionResponse profileDeletionResponse = (ProfileDeletionResponse) o;
    return Objects.equals(this.resptext, profileDeletionResponse.resptext) &&
        Objects.equals(this.respcode, profileDeletionResponse.respcode) &&
        Objects.equals(this.respproc, profileDeletionResponse.respproc) &&
        Objects.equals(this.respstat, profileDeletionResponse.respstat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resptext, respcode, respproc, respstat);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfileDeletionResponse {\n");
    
    sb.append("    resptext: ").append(toIndentedString(resptext)).append("\n");
    sb.append("    respcode: ").append(toIndentedString(respcode)).append("\n");
    sb.append("    respproc: ").append(toIndentedString(respproc)).append("\n");
    sb.append("    respstat: ").append(toIndentedString(respstat)).append("\n");
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

