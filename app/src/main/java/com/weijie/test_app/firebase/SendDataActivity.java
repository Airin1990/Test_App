package com.weijie.test_app.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.weijie.test_app.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SendDataActivity extends AppCompatActivity {


    private static final String MY_FIREBASE_URL = "https://weijietestapp.firebaseio.com/";
    @Bind(R.id.editText)
    EditText email;
    @Bind(R.id.editText2)
    EditText phone;
    @Bind(R.id.textView5)
    TextView emailget;
    @Bind(R.id.textView6)
    TextView phoneget;

    Firebase mfirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        Firebase.setAndroidContext(this);
        ButterKnife.bind(this);

        mfirebase = new Firebase(MY_FIREBASE_URL);
    }

    public void upload_contact(View view) {
        mfirebase.child("email").setValue(email.getText().toString());
        mfirebase.child("phone").setValue(phone.getText().toString());
    }

    public void retrieve_contact(View view) {
        mfirebase.child("email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                emailget.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mfirebase.child("phone").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                phoneget.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
