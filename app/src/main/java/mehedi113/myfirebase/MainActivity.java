package mehedi113.myfirebase;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailId, passwordId;
    TextView textView;

    FirebaseAuth auth;
    FirebaseUser user;

    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailId = findViewById(R.id.emailID);
        passwordId = findViewById(R.id.passwordID);
        textView = findViewById(R.id.textTV);


        auth = FirebaseAuth.getInstance();

//        fm = getFragmentManager();
//        ft = fm.beginTransaction();

        // FragmentSignUp fragmentSignUp = new FragmentSignUp();

        // ft.add(R.id.fragmantContainer,fragmentSignUp);
        // ft.commit();


    }

    public void logInUser(View view) {

        String email = emailId.getText().toString();
        String pass = passwordId.getText().toString();

        Task<AuthResult> resultTask = auth.signInWithEmailAndPassword(email, pass);

        resultTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    user = auth.getCurrentUser();

                    textView.setText("log in as " + user.getEmail());

                }
            }
        });

        resultTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                textView.setText(e.getMessage());
            }
        });
    }

    public void SignUpUser(View view) {


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        FragmentSignUp fragmentSignUp = new FragmentSignUp();

        ft.replace(R.id.fragmentContainer, fragmentSignUp);
        ft.commit();


    }
}
