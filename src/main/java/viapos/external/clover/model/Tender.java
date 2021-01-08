package viapos.external.clover.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * CloverTender
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")




public class Tender {
  @JsonProperty("label_key")
  private String labelKey = null;

  @JsonProperty("label")
  private String label = null;

  @JsonProperty("id")
  private String id = null;

  public Tender labelKey(String labelKey) {
    this.labelKey = labelKey;
    return this;
  }

  /**
   * Get labelKey
   * @return labelKey
  **/
  @ApiModelProperty(value = "")


  public String getLabelKey() {
    return labelKey;
  }

  public void setLabelKey(String labelKey) {
    this.labelKey = labelKey;
  }

  public Tender label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(value = "")


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Tender id(String id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tender cloverTender = (Tender) o;
    return Objects.equals(this.labelKey, cloverTender.labelKey) &&
        Objects.equals(this.label, cloverTender.label) &&
        Objects.equals(this.id, cloverTender.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(labelKey, label, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloverTender {\n");
    
    sb.append("    labelKey: ").append(toIndentedString(labelKey)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

