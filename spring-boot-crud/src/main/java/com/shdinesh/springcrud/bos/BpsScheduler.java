package com.shdinesh.springcrud.bos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BpsScheduler {
   /* @Value("${bps.in.folder}")
    private String bpsInFolder;

    @Value("${bps.staging.folder}")
    private String bpsStagingFolder;

    @Autowired
    private BpsProcessor bpsProcessor;

    @Autowired
    private FilesService filesService;

    public void readBpsFiles() throws IOException {
        log.info("Bps Scheduler started");

        filesService.moveAllFilesToDirectory(bpsInFolder, bpsStagingFolder);
        List<File> bpsFiles = filesService.getAllFilesInDir(bpsStagingFolder);

        if (CollectionUtils.isEmpty(bpsFiles)) {
            log.info("No new files for bilateral pricing");
            return;
        }

        bpsProcessor.processFiles(bpsFiles);
        log.info("Bps Scheduler complete reading all files");

    }*/
}
