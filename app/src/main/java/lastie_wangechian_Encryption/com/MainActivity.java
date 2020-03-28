package lastie_wangechian_Encryption.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_input;
    private EditText editText_output;
    private Button button_encrypt;
    private Button button_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_input = findViewById(R.id.editText_input);
        editText_output =findViewById(R.id.editText_output);
        button_encrypt = findViewById(R.id.button_encrypt);
        button_clear = findViewById(R.id.button_clear);

        button_encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String user_input = editText_input.getText().toString().trim();
                    if (user_input.isEmpty() ){
                        editText_input.requestFocus();
                        editText_input.setError("enter sample word");
                        return;

                    }else{

                        Encryption encryption = new Encryption(user_input);
                        String output = encryption.getEncryption();
                        editText_output.setText(output);
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error when button order clicked: " +e.getMessage().trim(), Toast.LENGTH_LONG).show();
                }
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText_input.setText(null);
                editText_output.setText(null);

            }
        });

    }
}
