package com.example.smd_assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ReviewForm extends AppCompatActivity {
    TextView tvSenderEmail, tvSenderFullName, tvSenderContactInfo, tvSenderCountry,tvSenderAddress;
    TextView tvReceiverEmail, tvReceiverFullName, tvReceiverContactInfo, tvReceiverCountry,tvReceiverAddress;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent prevIntent = getIntent();
        if(prevIntent!=null){
            tvSenderFullName.setText(prevIntent.getStringExtra("key_senderFullName"));
            tvSenderContactInfo.setText(prevIntent.getStringExtra("key_senderContactInfo"));
            tvSenderCountry.setText(prevIntent.getStringExtra("key_senderCountry"));
            tvSenderAddress.setText(prevIntent.getStringExtra("key_senderAddress"));

            System.out.println("Sender data after receiving in Review Form");
            System.out.println(prevIntent.getStringExtra("key_senderFullName"));
            System.out.println(prevIntent.getStringExtra("key_senderContactInfo"));
            System.out.println(prevIntent.getStringExtra("key_senderCountry"));
            System.out.println(prevIntent.getStringExtra("key_senderAddress"));

            tvReceiverFullName.setText(prevIntent.getStringExtra("key_receiverFullName"));
            tvReceiverContactInfo.setText(prevIntent.getStringExtra("key_receiverContactInfo"));
            tvReceiverCountry.setText(prevIntent.getStringExtra("key_receiverCountry"));
            tvReceiverAddress.setText(prevIntent.getStringExtra("key_receiverAddress"));
        }
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReviewForm.this,SenderForm.class);
                startActivity(i);
                finish();

            }
        });

    }
    private void init(){
        tvSenderFullName = findViewById(R.id.tvSenderFullName);
        tvSenderAddress = findViewById(R.id.tvSenderAddress);
        tvSenderContactInfo = findViewById(R.id.tvSenderContactInfo);
        tvSenderCountry = findViewById(R.id.tvSenderCountry);

        tvReceiverFullName = findViewById(R.id.tvReceiverFullName);
        tvReceiverAddress = findViewById(R.id.tvReceiverAddress);
        tvReceiverContactInfo = findViewById(R.id.tvReceiverContactInfo);
        tvReceiverCountry = findViewById(R.id.tvReceiverCountry);

        fabAdd = findViewById(R.id.fabAdd);
    }

}