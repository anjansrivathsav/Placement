package iiitv.com.placement.myplacement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    //private static final  TAG ="" ;
    private EditText pass1;
    private  EditText pass2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    pass1=(EditText) findViewById(R.id.pass1);
    pass2=(EditText) findViewById(R.id.pass2);
        btn=(Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npass=pass1.getText().toString();
                String cpass=pass2.getText().toString();
                if(npass.equals(cpass))
                {
                    updatepassword(cpass);
                }
            }
        });

    }

    private void updatepassword(String s) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       String newpassword=s;
        user.updatePassword(newpassword).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    //Log.d(TAG, "User password updated.");
                    Toast.makeText(ChangePasswordActivity.this,
                            "Password Updated",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ChangePasswordActivity.this,
                            "Password NOT Updated",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
