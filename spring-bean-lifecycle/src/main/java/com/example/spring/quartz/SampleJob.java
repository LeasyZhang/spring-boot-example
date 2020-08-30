package com.example.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {

    private final SampleServiceBean sampleServiceBean;

    @Autowired
    public SampleJob(SampleServiceBean sampleServiceBean) {
        this.sampleServiceBean = sampleServiceBean;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        sampleServiceBean.hello();
    }
}
