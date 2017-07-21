package byili.cherryapps.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button img_button;
    EditText edt_name, edt_grade;
    String str_name, str_grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name            = (EditText) findViewById(R.id.edt_name);
        edt_grade           = (EditText) findViewById(R.id.edt_grade);

        img_button = (Button) findViewById(R.id.btn_continue);
        img_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_continue:
                str_name        = edt_name.getText().toString();
                str_grade       = edt_grade.getText().toString();
                long id = (long) (Math.random()*100) + 1;
                if (Utilities.validateEmpty(str_name, str_grade)){
                    Intent intent = new Intent(this, DetailActivity.class);
                    intent.putExtra("student", new Student(id,str_name,str_grade));
                    this.startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Check you data!", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
