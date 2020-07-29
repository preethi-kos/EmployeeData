package com.example.endpoint;

import com.example.Entity.EmployeeEntity;
import com.example.Entity.LoginInfoEntity;
import com.example.Repository.EmployeeRepository;
import com.example.Repository.LogonRepository;
import com.example.Service.EmpLogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Component
@RestController
public class EmplEndpoint {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LoginInfoEntity loginEntity;

    @Autowired
    private EmpLogonService empLogonService;

    public EmplEndpoint() {

        empLogonService.addLogonData();
    }

    @PostMapping(value = "/employees", consumes = "application/json")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employeeDAO) {

        if (Objects.nonNull(employeeDAO)) {
            employeeRepository.save(employeeDAO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee insertion failed");
        }
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<String> checkCredentials(@RequestBody LoginInfoEntity loginInfoEntity) {

        if (Objects.nonNull(loginInfoEntity.getUserName()) && Objects.nonNull(loginInfoEntity.getPassword())) {


            if (loginEntity.isValidUserNamePwd(loginInfoEntity.getUserName(), loginInfoEntity.getPassword())) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Credentials Matched!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid UserName/Password");
            }

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials Provided");
        }
    }

    @PostMapping(value = "/employees/{gender}/{minAge}/{maxAge}")
    public void addAgeDetails(@PathVariable String gender,@PathVariable Integer minAge,@PathVariable Integer maxAge) {


    }
}
