package iiitv.com.placement.myplacement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    // private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText ed1;
    private EditText ed2;
    private Button btn1;
    String email;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        btn1 = (Button) findViewById(R.id.btn1);
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startsignup();
            }
        });


        // ...
    }


    private void startsignup() {
        email = ed1.getText().toString();
        password = ed2.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {

                                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    //String key = task.getResult().getUser().getUid();
                                    //addDetailsToDB(key);

                                }
                            }


                        }

                );
    }

    }

