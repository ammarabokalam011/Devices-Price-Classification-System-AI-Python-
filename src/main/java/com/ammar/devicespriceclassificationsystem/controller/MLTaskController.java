package com.ammar.devicespriceclassificationsystem.controller;

import com.ammar.devicespriceclassificationsystem.model.Device;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.beanutils.PropertyUtils;
import org.jpmml.evaluator.*;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class MLTaskController {

    private final String filename="test.csv";

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getDevices() {
        List<Device> devices = getAllDevices();
        return ResponseEntity.ok(devices);
//            Gson gson = new Gson();
//            return gson.toJson(devices);
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        List<Device> devices = getAllDevices();
//            Device device =new Device();
//            device.setId(id);
//            devices.get(devices.indexOf(device));
        for (Device device : devices) {
            if(device.getId() == id) {
                return ResponseEntity.ok(device);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/predict/{id}")
    public ResponseEntity<String> predict(@PathVariable Long id) {
        Device device =getDeviceById(id).getBody();
        try {
            File modelFile = ResourceUtils.getFile("classpath:static/decision_tree.pmml");
            Evaluator evaluator = new LoadingModelEvaluatorBuilder()
                    .load(modelFile)
                    .build();

            // Perforing the self-check
            evaluator.verify();

            // Printing input (x1, x2, .., xn) fields
            List<InputField> inputFields = evaluator.getInputFields();
            System.out.println("Input fields: " + inputFields);

            // Printing primary result (y) field(s)
            List<TargetField> targetFields = evaluator.getTargetFields();
            System.out.println("Target field(s): " + targetFields);

            // Printing secondary result (eg. probability(y), decision(y)) fields
            List<OutputField> outputFields = evaluator.getOutputFields();
            System.out.println("Output fields: " + outputFields);

            // Iterating through columnar data (eg. a CSV file, an SQL result set)
            while(true){
                // Reading a record from the data source
                Map<String, ?> arguments = PropertyUtils.describe(device);
                if(arguments == null){
                    break;
                }

                // Evaluating the model
                Map<String, ?> results = evaluator.evaluate(arguments);

                // Decoupling results from the JPMML-Evaluator runtime environment
                results = EvaluatorUtil.decodeAll(results);

                // Writing a record to the data sink
                return ResponseEntity.ok(results.get("predicted_price_range").toString());
            }

        } catch (IOException | ParserConfigurationException | SAXException | JAXBException | InvocationTargetException |
                 IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.notFound().build();
    }

//    @PostMapping("/devices")
//    public ResponseEntity<Device>  create(@RequestBody Device device) {
//        Device createdDevice = deviceService.createDevice(device);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdDevice);
//    }

    private List<Device> getAllDevices(){
        List<Device> devices = List.of();
        try {
            File testCsv = ResourceUtils.getFile("classpath:static/test.csv");
            devices = new CsvToBeanBuilder(new FileReader(testCsv))
                    .withType(Device.class)
                    .build()
                    .parse();
            return devices;
        } catch (FileNotFoundException e) {
            ResponseEntity.internalServerError();
        }
        return devices;
    }
}
