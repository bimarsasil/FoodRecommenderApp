package com.example.ifoodrecommender.data;

import androidx.annotation.NonNull;

import com.example.ifoodrecommender.data.model.LoggedInUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that handles user authentication.
 */
public class LoginFBDSource {
    private static LoggedInUser loggedInUser =new LoggedInUser();
    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }
    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        LoginFBDSource.loggedInUser = loggedInUser;
    }
    public Boolean login(String username, String password) {
        try {
            LoggedInUser user= LoginFBDSource.getLoggedInUser();
           if (getLoggedInUser().get_uname().equals(username) && getLoggedInUser().getPassword().equals(password))
           {
               return true;
           }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    // register a test user
    public void register() {
        // create  user
        getLoggedInUser().set_name("Bimarsa");
        getLoggedInUser().set_uname("bimarsa@email.com");
        getLoggedInUser().setPassword("1111111");
        // ini Db connection
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // create a map entry
        Map<String, Object> appuser = new HashMap<>();
        appuser.put("name", "Bimarsa");
        appuser.put("email", "bimarsa@email.com");
        appuser.put("password", "1111111");

// Add the user to
        db.collection("users")
                .add(appuser)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error adding document", e);
                    }
                });
    }
    public void logout() {
        // TODO: call when user loggedout
    }
}
