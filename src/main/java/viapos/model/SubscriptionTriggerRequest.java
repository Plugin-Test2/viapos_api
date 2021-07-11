package viapos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubscriptionTriggerRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-06T00:25:47.690Z")


public class SubscriptionTriggerRequest   {
    @JsonProperty("occurence")
    private String occurence = null;

    public SubscriptionTriggerRequest occurence(String occurence) {
        this.occurence = occurence;
        return this;
    }

    /**
     * Get occurence
     * @return occurence
     **/
    @ApiModelProperty(value = "")


    public String getOccurence() {
        return occurence;
    }

    public void setOccurence(String occurence) {
        this.occurence = occurence;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriptionTriggerRequest subscriptionTriggerRequest = (SubscriptionTriggerRequest) o;
        return Objects.equals(this.occurence, subscriptionTriggerRequest.occurence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(occurence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubscriptionTriggerRequest {\n");

        sb.append("    occurence: ").append(toIndentedString(occurence)).append("\n");
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

