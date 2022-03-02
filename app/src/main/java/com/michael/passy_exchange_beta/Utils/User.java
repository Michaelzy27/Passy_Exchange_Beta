package com.michael.passy_exchange_beta.Utils;

import androidx.annotation.NonNull;

public class User {

    String username, email, firstName, lastName;

    public User(@NonNull String Username, String Email, String firstName, String lastName){
        this.username = Username;
        this.email = Email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
