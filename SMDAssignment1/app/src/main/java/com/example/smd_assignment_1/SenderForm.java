package com.example.smd_assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SenderForm extends AppCompatActivity {

    TextInputEditText etSenderEmail, etSenderFullName, etSenderContactInfo, etSenderCountry, etSenderAddress;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        // adding action listener to next btn
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = etSenderFullName.getText().toString().trim();
                String country = etSenderCountry.getText().toString().trim();
                String contact = etSenderContactInfo.getText().toString().trim();
                String address = etSenderAddress.getText().toString().trim();
                //validating fields
                if(!validateField(etSenderEmail)){
                    return;
                }
                if(!validateField(etSenderFullName)){
                    return;
                }
                if(!validateField(etSenderContactInfo)){
                    return;
                }
                if(!validateField(etSenderCountry)){
                    return;
                }
                if(!validateField(etSenderAddress)){
                    return;
                }
                // toast for better user experience
                Toast.makeText(SenderForm.this,"Successfully data entered",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SenderForm.this,ReceiverForm.class);
                i.putExtra("key_senderFullName",fullName);
                i.putExtra("key_senderContactInfo",contact);
                i.putExtra("key_senderCountry",country);
                i.putExtra("key_senderAddress",address);

                startActivity(i);
                finish();
            }
        });
    }
    // method for validating form fields
    private boolean validateField(TextInputEditText etField){
        if(etField.getText().toString().isEmpty()){
            etField.setError("This field is required");
            return false;
        }
        else{
            etField.setError(null);
            return true;
        }
    }
    // method to get views
    private void init(){
        etSenderEmail = findViewById(R.id.etSenderEmail);
        etSenderFullName =findViewById(R.id.etSenderFullName);
        etSenderCountry =findViewById(R.id.etSenderCountry);
        etSenderContactInfo =findViewById(R.id.etSenderContact);
        etSenderAddress =findViewById(R.id.etSenderAddress);
        btnNext =findViewById(R.id.btnNext);
    }
}
