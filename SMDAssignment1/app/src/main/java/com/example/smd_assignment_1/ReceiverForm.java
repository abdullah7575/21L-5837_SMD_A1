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

public class ReceiverForm extends AppCompatActivity {
    TextInputEditText etReceiverEmail, etReceiverFullName, etReceiverContactInfo, etReceiverCountry, etReceiverAddress;
    Button btnNext;
    String senderEmail = "", senderFullName = "", senderContactInfo = "",senderCountry = "", senderAddress = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receiverFullName = etReceiverFullName.getText().toString().trim();
                String receiverCountry = etReceiverCountry.getText().toString().trim();
                String receiverContact = etReceiverContactInfo.getText().toString().trim();
                String receiverAddress = etReceiverAddress.getText().toString().trim();
                //validating fields
                if(!validateField(etReceiverEmail)){
                    return;
                }
                if(!validateField(etReceiverFullName)){
                    return;
                }
                if(!validateField(etReceiverContactInfo)){
                    return;
                }
                if(!validateField(etReceiverCountry)){
                    return;
                }
                if(!validateField(etReceiverAddress)){
                    return;
                }
                Toast.makeText(ReceiverForm.this,"Successfully data entered",Toast.LENGTH_SHORT).show();
                Intent senderIntent = getIntent();
                if(senderIntent!=null){
                    senderFullName = senderIntent.getStringExtra("key_senderFullName");
                    senderContactInfo = senderIntent.getStringExtra("key_senderContactInfo");
                    senderCountry = senderIntent.getStringExtra("key_senderCountry");
                    senderAddress = senderIntent.getStringExtra("key_senderAddress");

                    System.out.println("Sender data after receiving");
                    System.out.println(senderFullName);
                    System.out.println(senderContactInfo);
                    System.out.println(senderCountry);
                    System.out.println(senderAddress);
                }
                Intent i = new Intent(ReceiverForm.this,ReviewForm.class);
                // sender details sending forward
                i.putExtra("key_senderFullName",senderFullName);
                i.putExtra("key_senderContactInfo",senderContactInfo);
                i.putExtra("key_senderCountry",senderCountry);
                i.putExtra("key_senderAddress",senderAddress);

                // receiver details sending
                i.putExtra("key_receiverFullName",receiverFullName);
                i.putExtra("key_receiverContactInfo",receiverContact);
                i.putExtra("key_receiverCountry",receiverCountry);
                i.putExtra("key_receiverAddress",receiverAddress);

                startActivity(i);
                finish();
            }
        });
    }
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
    private void init(){
        etReceiverEmail = findViewById(R.id.etReceiverEmail);
        etReceiverFullName =findViewById(R.id.etReceiverFullName);
        etReceiverCountry =findViewById(R.id.etReceiverCountry);
        etReceiverContactInfo =findViewById(R.id.etReceiverContactInfo);
        etReceiverAddress =findViewById(R.id.etReceiverAddress);
        btnNext =findViewById(R.id.btnNext);
    }
}