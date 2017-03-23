package iiitv.com.placement.myplacement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
   email=(EditText) findViewById(R.id.email);
        confirm=(Button) findViewById(R.id.confirm);

       final FirebaseAuth auth = FirebaseAuth.getInstance();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=email.getText().toString();
                if(str.isEmpty())
                {
                    Toast.makeText(ResetPasswordActivity.this,"enter the valid email",Toast.LENGTH_LONG).show();
                  finish();
                }
                else{
                    auth.sendPasswordResetEmail(str).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful())
                           {
                               Toast.makeText(ResetPasswordActivity.this,"sent succesfully",Toast.LENGTH_LONG).show();
                           }
                            else{

                               Toast.makeText(ResetPasswordActivity.this,"failed to update",Toast.LENGTH_LONG).show();
                           }
                        }
                    });
                }
            }
        });
        }
    }

