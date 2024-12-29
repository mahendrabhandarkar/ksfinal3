package com.ks.ksfinal3.services;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public interface FileService {

  public String uploadFile(MultipartFile file) throws IOException;
  public List<String> getFilesList();
  public InputStream downloadFile(@RequestParam String filename) throws IOException;
}
