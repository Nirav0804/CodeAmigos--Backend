package com.spring.codeamigosbackend.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.*;

@Data
public class HackathonDTO {
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    private String logo;

    @NotBlank(message = "Organization is required")
    private String organization;

    @NotBlank(message = "Theme is required")
    private String theme;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Mode is required")
    private String mode;

    @NotBlank(message = "About section is required")
    @Size(min = 20, message = "About section must be at least 20 characters")
    private String about;

    @NotBlank(message = "Participation type is required")
    private String participationType;

    private TeamSize teamSize;

    List<String> techStacks ;

    @NotNull(message = "Registration dates are required")
    private RegistrationDates registrationDates;

    @NotNull(message = "Hackathon dates are required")
    private HackathonDates hackathonDates;

    private String createdBy;
    private String createdById;
    private int currentTeamSize;

    @Data
    public static class TeamSize {
        @Min(value = 1, message = "Minimum team size must be at least 1")
        private int min;

        @Min(value = 1, message = "Maximum team size must be at least 1")
        private int max;
    }

    @Data
    public static class RegistrationDates {
        @NotNull(message = "Registration Start date is required")
        @Future(message = "Registration Start date must be in the future")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime start;

        @NotNull(message = "Registration End date is required")
        @Future(message = "Registration End date must be in the future")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime end;
    }

    @Data
    public static class HackathonDates{
        @NotNull(message = "Hackathon Start date is required")
        @Future(message = "Hackathon Start date must be in the future")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime start;

        @NotNull(message = "Hackathon End date is required")
        @Future(message = "Hackathon End date must be in the future")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime end;
    }

    private List<String> requestsToJoin = new ArrayList<>();
    private List<String> acceptedUsers = new ArrayList<>();
    private List<String> rejectedUsers = new ArrayList<>();
}
