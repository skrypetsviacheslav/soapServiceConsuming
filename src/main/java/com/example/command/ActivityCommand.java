package com.example.command;

import com.example.client.ActivityClient;
import com.example.consumingwebservice.wsdl.DeleteActivityResponse;
import com.example.consumingwebservice.wsdl.GetActivityResponse;
import com.example.entity.Activity;
import com.example.mapper.ActivityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
public class ActivityCommand {
    private static final Logger log = LoggerFactory.getLogger(ActivityCommand.class);
    private final ActivityMapper mapper = ActivityMapper.INSTANCE;
    @Autowired
    ActivityClient activityClient;

    @ShellMethod("Get Activity by Id")
    public String get(int id) {

        Optional<GetActivityResponse> getActivityResponse = Optional.ofNullable(activityClient.getActivity(id));

        return getActivityResponse
                .map(GetActivityResponse::getActivity)
                .map(mapper::activityDtoToActivity)
                .map(Activity::toString)
                .orElse("No such activity");
    }

    @ShellMethod("Delete Activity by Id")
    public String delete(int id) {
        DeleteActivityResponse response = activityClient.deleteActivity(id);

        return String.valueOf(response.isDeleted());
    }
}
