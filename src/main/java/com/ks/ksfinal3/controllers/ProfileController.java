package com.ks.ksfinal3.controllers;

import com.ks.ksfinal3.dto.CountriesRequest;
import com.ks.ksfinal3.entity.Countries;
import com.ks.ksfinal3.model.DatatableColumnData;
import com.ks.ksfinal3.repository.CountriesRepo;
import com.ks.ksfinal3.util.IterableUtils;
import com.ks.ksfinal3.util.MyImageObserver;
import net.coobird.thumbnailator.Thumbnails;
import org.aspectj.apache.bcel.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    CountriesRepo countriesRepo;

    @PostMapping("/listc2")
    public PagedModel<CountriesRequest> getCountriesList(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam(defaultValue = "name") String sortBy,
                                                  @RequestParam(defaultValue = "asc") String order) {
        Map<String, String> data = new HashMap<>();
        Sort sort = order.equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Countries> pageCountries = countriesRepo.findAll(pageable);
        logger.info("{}", pageCountries.stream().toList());
        List<CountriesRequest> countryDtos = pageCountries.getContent().stream()
                .map(countries -> new CountriesRequest(countries.getId(), countries.getIso(), countries.getName(), countries.getSortname(), countries.getIso3(), countries.getNumcode(), countries.getPhonecode()))
                .collect(Collectors.toList());
        //                .toList();

        return PagedModel.of(countryDtos,
                new PagedModel.PageMetadata(pageCountries.getSize(), pageCountries.getNumber(), pageCountries.getTotalElements()));
    }

    @PostMapping("/listc")
    public Map<String, Object> getCountriesList(@RequestParam(defaultValue = "0", value = "draw") int draw,
                                                @RequestParam(defaultValue = "10", value = "start") int start,
                                                @RequestParam(defaultValue = "10", value = "length") String length,
                                                @RequestParam(defaultValue = "0", value = "order[0][column]") int orderColumn,
                                                @RequestParam(defaultValue = "asc", value = "order[0][dir]") String orderDir,
                                                @RequestParam(value="search[value]", required = false) String searchValue,
                                                @RequestParam(required = false) Map<String, Object> arrColumns) {

        logger.info("arrColumns:=={}" , arrColumns);
        Map<String, DatatableColumnData> arrColumnsFinal = IterableUtils.datatableCollectData(arrColumns);
        logger.info("arrColumnsFinal:=={}" , arrColumnsFinal);

        String sortField = "name";
        if(orderColumn == 1) {
            sortField = "iso";
        }else if(orderColumn ==2) {
            sortField = "sortname";
        }

        Sort sort = Sort.by(sortField);
        sort = orderDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? sort.ascending() : sort.descending();
        int length1 = (!Objects.equals(length, "All") && !Objects.equals(length, ""))?Integer.parseInt(length):Integer.MAX_VALUE;
        int pageNo = start / length1;
        Page<Countries> countriesPage = null;
        Iterable<Countries> countriesList = null;
        Map<String, Object> response = new HashMap<>();

        if(length1 > 0) {
            Pageable pageable = PageRequest.of(pageNo, length1, sort);
            if(searchValue != null) {
                countriesPage = countriesRepo.findByNameContaining(searchValue, pageable);
            }else {
                countriesPage = countriesRepo.findAll(pageable);
            }
            response.put("draw", draw);
            response.put("recordsTotal", countriesPage.getTotalElements());
            response.put("recordsFiltered", countriesPage.getTotalElements());
            response.put("data", countriesPage.getContent());
        }else{
            if(searchValue != null) {
                countriesList = countriesRepo.findByNameContaining(searchValue, sort);
            }else {
                countriesList = countriesRepo.findAll(sort);
            }
            response.put("draw", draw);
            response.put("recordsTotal", IterableUtils.count(countriesList));
            response.put("recordsFiltered", IterableUtils.count(countriesList));
            response.put("data", countriesList);
        }

        return response;
    }

    @GetMapping("/about")
    public ResponseEntity<Map<String, String>> getAbout(@RequestParam int[] values) {
        Map<String, String> response = new HashMap<>();

        // Manually check if the array is null or empty
        if(values == null || values.length == 0) {
            response.put("values", "Values array must not be null or empty");
            return ResponseEntity.badRequest().body(response);
        }

        // Optionally, check for specific conditions on each element (e.g., values > 0)
        for(int value: values) {
            if(value <= 0) {
                response.put("values", "Each value must be greater than 0");
                return ResponseEntity.badRequest().body(response);
            }
        }
        // If validation passes, handle the request logic
        response.put("message", "Values updated successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/thumb")
    public Object getThumbnail(@RequestParam int[] values) {
        Map<String, String> response = new HashMap<>();
        // Optionally, check for specific conditions on each element (e.g., values > 0)
        for(int value: values) {
            if(value <= 0) {
                response.put("values", "Each value must be greater than 0");
                return ResponseEntity.badRequest().body(response);
            }
        }
        try {
        //     Thumbnails.of(new File("testimage.png")).size(160, 160).toFile(new File("thumbnail.jpg"));
            BufferedImage inputBufferedImage = ImageIO.read(new File("testimage.png") );
            BufferedImage outputBufferedImage;
            outputBufferedImage = resizeImage(inputBufferedImage, 160, 160);
            Image imgData = outputBufferedImage.getScaledInstance(Constants.ATTR_CONSTANT_VALUE, -1, Image.SCALE_SMOOTH);
            MyImageObserver observer = new MyImageObserver();
            observer.imageUpdate(imgData, 0, 0, 0, 160, 160);
            return outputBufferedImage.getGraphics().drawImage(imgData, 0, 0, 160, 160, observer);
        }catch(Exception eo) {
            response.put("values", "Image Exception occurred");
            return ResponseEntity.badRequest().body(eo.getMessage());
        }
    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws  Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(originalImage).size(targetWidth, targetHeight)
                .outputFormat("jpeg")
                .outputQuality(1)
                .toOutputStream(outputStream);
        byte[] data = outputStream.toByteArray();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        return ImageIO.read(inputStream);
    }
}
