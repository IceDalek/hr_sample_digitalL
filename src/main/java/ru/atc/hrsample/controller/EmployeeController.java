package ru.atc.hrsample.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.misc.EmployeeAndJobContainer;
import ru.atc.hrsample.service.api.EmployeeService;
import ru.atc.hrsample.service.api.JobService;

@Slf4j
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final JobService jobService;
    @GetMapping("{employee_id}")
    public EmployeeAllInfoDTO getEmployeeById(@PathVariable Integer employee_id){
        return employeeService.getEmployeeInfoById(employee_id);
    }
    @PostMapping("/job")
    public JobDTO addNewJob(@RequestBody JobDTO jobDTO){
        return jobService.addNewJob(jobDTO);
    }
    @PostMapping()
    public EmployeeDTO addNewEmployee(@RequestBody EmployeeAndJobContainer container) {
        EmployeeDTO employeeDTO = container.employeeDTO;
        JobDTO jobDTO = container.jobDTO;
        if(employeeDTO.getJobId()==null && jobDTO!=null){
            return employeeService.addNewEmployee(employeeDTO, jobDTO);
        }
        return employeeService.addNewEmployee(employeeDTO);
    }


}
