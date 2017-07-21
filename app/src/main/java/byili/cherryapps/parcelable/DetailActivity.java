package byili.cherryapps.parcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();


    TextView tv_id, tv_name, tv_grade;
    ImageView imageView;

    Student student = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle data =getIntent().getExtras();
        if (data != null) {
            student = data.getParcelable("student");
            Log.e(TAG, "data student :::" + student.toString());
            getData();
        }
    }

    public void getData(){
        tv_id           = (TextView) findViewById(R.id.textView);
        tv_name         = (TextView) findViewById(R.id.textView2);
        tv_grade        = (TextView) findViewById(R.id.textView3);
        imageView       = (ImageView) findViewById(R.id.imageView);

        tv_id.setText(getString(R.string.tv_id)+" "+String.valueOf(student.getId()));
        tv_name.setText(getString(R.string.tv_name)+" "+student.getName());
        tv_grade.setText(getString(R.string.tv_grade)+" "+student.getGrade());

        changeImage();
    }

    public void changeImage(){
        if (String.valueOf(student.getId()).length()>1) {
            if (Utilities.validatePar((int)student.getId())) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.avatar_man));
            } else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.avatar_woman));
            }
        }
    }
}
