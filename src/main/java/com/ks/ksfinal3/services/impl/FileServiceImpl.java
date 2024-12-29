package com.ks.ksfinal3.services.impl;

import com.ks.ksfinal3.entity.FileMetaData;
import com.ks.ksfinal3.services.FileService;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.mongodb.gridfs.GridFsResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FileServiceImpl implements FileService{

    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final GridFsTemplate gridFsTemplate;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public FileServiceImpl(GridFsTemplate gridFsTemplate, MongoTemplate mongoTemplate) {
        this.gridFsTemplate = gridFsTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        log.info("Received file: {0}", file.getOriginalFilename());
        ObjectId fileId;
        try {
            InputStream inputStream = file.getInputStream();

            fileId = gridFsTemplate.store(inputStream, file.getOriginalFilename(), file.getContentType());

            // Save file metadata
            FileMetaData metadata = new FileMetaData(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getSize(),
                    fileId.toString()
            );
            mongoTemplate.save(metadata);
            log.info("File uploaded successfully with ID: {0}", fileId);
        } catch (Exception e) {
            log.error("File uploaded failed with below reason: ", e.getMessage());
            throw new RuntimeException(e);
        }
        return fileId.toString();
    }

    public List<String> getFilesList() {
        // Create a query to find all files
        Query query = new Query();
        // Fetch all files from GridFS
        GridFSFindIterable files = gridFsTemplate.find(query);
        List<String> fileIds = new ArrayList<>();
        // Iterate through the files and collect their IDs
        files.forEach(file -> {fileIds.add(file.getObjectId().toString()); log.info("{}", file);});
        log.info("Listed file IDs: {}", fileIds);
        return fileIds;
    }

    public InputStream downloadFile(@RequestParam String filename) throws IOException {
        log.info("Downloading file with filename: {}", filename);

        ObjectId objectId = new ObjectId(filename);

        // Create a query to find the file by its filename
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(filename));
        // Fetch the file from GridFS
        GridFSFile resource = gridFsTemplate.findOne(query);
        GridFsResource resource1 = gridFsTemplate.getResource(resource);

        if (resource == null) {
            log.info("File not found: {}");
            throw new RuntimeException("File not found: " + filename);
        }
        log.info("Successfully retrieved file: {}", resource1.getFilename());
        // Return the InputStream of the file
        return resource1.getInputStream();
    }

}
