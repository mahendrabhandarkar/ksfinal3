package com.ks.ksfinal3.controllers;

import com.ks.ksfinal3.services.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/web/files")
public class FileWebController {

    private final Logger log = LoggerFactory.getLogger(FileWebController.class);

    private final FileService fileService;

    @Autowired
    public FileWebController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/fileupload")
    public String formFileUploadPage(Model model, HttpServletResponse response) {
        //model.addAttribute("model", new )
        log.info("I am at file upload");

        List<String> teamMembers = fileService.getFilesList();
        model.addAttribute("filesvar", teamMembers);
        model.addAttribute("message", "");

        return "pages/formfileupload";
    }

    @GetMapping("/listfiles")
    public String listUploadedFiles(Model model) throws IOException {

        log.info("I am at list files");

        List<String> teamMembers = Arrays.asList("Alice", "Bob", "Charlie");
        model.addAttribute("filesvar", teamMembers);
        model.addAttribute("message", "");
        return "pages/formfileupload";
    }

    @GetMapping("/download/{filename}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> serveFile(@PathVariable String filename) {
    //    log.log(filename);
        InputStream file;
        try {
            file = fileService.downloadFile(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file == null)
            return ResponseEntity.notFound().build();

        // Create response headers for downloading
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename+".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(file));

    }

    @PostMapping("/handleupload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        String message = "";
        log.info("Received file: {0}", file.getOriginalFilename());
        try {
            String fileId = fileService.uploadFile(file);
            message="File uploaded successfully with ID: " + fileId;
        } catch (IOException e) {
            message = "File upload failed: " + e.getMessage();
        }

    //    fileService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:fileupload";
    }
/*
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
 */
}
