package viapos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import viapos.model.Employee;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import viapos.model.EmployeeType;
import viapos.service.EmployeeService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@CrossOrigin
@Controller
public class EmployeesApiController implements EmployeesApi {

    private static final Logger log = LoggerFactory.getLogger(EmployeesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private EmployeeService employeeService;

    @org.springframework.beans.factory.annotation.Autowired
    public EmployeesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be created" ,required=true )  @Valid @RequestBody List<Employee> employees) {
        boolean creation = employeeService.createEmployees(employees);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be deleted" ,required=true )  @Valid @RequestBody List<Employee> employee) {
        boolean deletion = employeeService.deleteEmployees(employee);
        if (deletion) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Employee> getEmployee(@ApiParam(value = "ID of Employee to return",required=true) @PathVariable("employeeId") String employeeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Employee>(objectMapper.readValue("{  \"name\" : \"name\",  \"typeId\" : \"typeId\",  \"id\" : \"id\",  \"availability\" : \"availability\"}", Employee.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Employee>> getEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<Employee> employees = employeeService.getEmployees();
        if (employees != null) {
            return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be updated" ,required=true )  @Valid @RequestBody List<Employee> employees) {
        boolean creation = employeeService.updateEmployees(employees);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> createEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employee Type objects to be created" ,required=true )  @Valid @RequestBody List<EmployeeType> employeeTypes) {
        boolean creation = employeeService.createEmployeeTypes(employeeTypes);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employee Type objects to be deleted" ,required=true )  @Valid @RequestBody List<EmployeeType> employeeType) {
        boolean creation = employeeService.deleteEmployeeTypes(employeeType);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Employee> getEmployeeType(@ApiParam(value = "ID of Employee to return",required=true) @PathVariable("employeeId") String employeeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Employee>(objectMapper.readValue("{  \"name\" : \"name\",  \"typeId\" : \"typeId\",  \"id\" : \"id\",  \"availability\" : \"availability\"}", Employee.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<EmployeeType>> getEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<EmployeeType> employees = employeeService.getEmployeeTypes();
        if (employees != null) {
            return new ResponseEntity<List<EmployeeType>>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<EmployeeType>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be updated" ,required=true )  @Valid @RequestBody List<EmployeeType> employeeTypes) {
        boolean creation = employeeService.updateEmployeeTypes(employeeTypes);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteEmployee(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ID of Event to return",required=true) @PathVariable("employeeId") String employeeId) {
        boolean creation = employeeService.deleteEmployee(employeeId);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteEmployeeType(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ID of Event to return",required=true) @PathVariable("employeeTypeId") String employeeTypeId) {
        boolean creation = employeeService.deleteEmployeeType(employeeTypeId);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
