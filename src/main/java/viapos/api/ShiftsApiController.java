package viapos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import viapos.model.Shift;
import viapos.model.ShiftType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import viapos.service.ShiftService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@Controller
public class ShiftsApiController implements ShiftsApi {

    private static final Logger log = LoggerFactory.getLogger(ShiftsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ShiftService shiftService;

    @org.springframework.beans.factory.annotation.Autowired
    public ShiftsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ShiftTypes objects to be created" ,required=true )  @Valid @RequestBody List<ShiftType> shiftTypes) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Shifts objects to be created" ,required=true )  @Valid @RequestBody List<Shift> shifts) {
        boolean creation = shiftService.createShifts(shifts);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ShiftTypes objects to be deleted" ,required=true )  @Valid @RequestBody List<ShiftType> shiftTypes) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Shifts objects to be deleted" ,required=true )  @Valid @RequestBody List<Shift> shifts) {
        boolean creation = shiftService.deleteShifts(shifts);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Shift> getShift(@ApiParam(value = "ID of Shift to return",required=true) @PathVariable("shiftId") String shiftId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Shift>(objectMapper.readValue("{  \"date\" : \"date\",  \"shiftTypeId\" : \"shiftTypeId\",  \"name\" : \"name\",  \"id\" : \"id\",  \"assignedTo\" : \"assignedTo\"}", Shift.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Shift>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Shift>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ShiftType> getShiftType(@ApiParam(value = "ID of ShiftType to return",required=true) @PathVariable("shiftTypeId") String shiftTypeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ShiftType>(objectMapper.readValue("{  \"name\" : \"name\",  \"id\" : \"id\",  \"eligibileEmployeeTypeIds\" : [ \"eligibileEmployeeTypeIds\", \"eligibileEmployeeTypeIds\" ]}", ShiftType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ShiftType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ShiftType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ShiftType>> getShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ShiftType>>(objectMapper.readValue("[ {  \"name\" : \"name\",  \"id\" : \"id\",  \"eligibileEmployeeTypeIds\" : [ \"eligibileEmployeeTypeIds\", \"eligibileEmployeeTypeIds\" ]}, {  \"name\" : \"name\",  \"id\" : \"id\",  \"eligibileEmployeeTypeIds\" : [ \"eligibileEmployeeTypeIds\", \"eligibileEmployeeTypeIds\" ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ShiftType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ShiftType>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Shift>> getShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<Shift> shifts = shiftService.getShifts();
        if (shifts != null) {
            return new ResponseEntity<List<Shift>>(shifts, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Shift>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ShiftTypes objects to be updated" ,required=true )  @Valid @RequestBody List<ShiftType> shiftTypes) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Shifts objects to be updated" ,required=true )  @Valid @RequestBody List<Shift> shifts) {
        boolean creation = shiftService.updateShifts(shifts);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
