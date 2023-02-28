package com.ups.app.admin.service.dto.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ResponseAuthDto {


    @JsonProperty("updated_at")
    public String updated_at;
    @JsonProperty("created_at")
    public String created_at;
    @JsonProperty("identities")
    public List<Identities> identities;
    @JsonProperty("user_metadata")
    public User_metadata user_metadata;
    @JsonProperty("app_metadata")
    public App_metadata app_metadata;
    @JsonProperty("confirmation_sent_at")
    public String confirmation_sent_at;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("email")
    public String email;
    @JsonProperty("role")
    public String role;
    @JsonProperty("aud")
    public String aud;
    @JsonProperty("id")
    public String id;

    public static class Identities {
        @JsonProperty("updated_at")
        public String updated_at;
        @JsonProperty("created_at")
        public String created_at;
        @JsonProperty("last_sign_in_at")
        public String last_sign_in_at;
        @JsonProperty("provider")
        public String provider;
        @JsonProperty("identity_data")
        public Identity_data identity_data;
        @JsonProperty("user_id")
        public String user_id;
        @JsonProperty("id")
        public String id;
    }

    public static class Identity_data {
        @JsonProperty("sub")
        public String sub;
        @JsonProperty("email")
        public String email;
    }

    public static class User_metadata {
    }

    public static class App_metadata {
        @JsonProperty("providers")
        public List<String> providers;
        @JsonProperty("provider")
        public String provider;
    }
}
