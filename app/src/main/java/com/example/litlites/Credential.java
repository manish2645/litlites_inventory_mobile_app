package com.example.litlites;

public class Credential {
        private String Code;
        private String Email;
        private String Password;

        Credential(String code, String username, String password){
            this.Code = code;
            this.Email = username;
            this.Password = password;
        }

        public String getCode() {

            return Code;
        }

        public void setCode(String code) {

            Code = code;
        }

        public String getEmail() {

            return Email;
        }

        public void setUsername(String username) {

            Email = username;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }
    }


