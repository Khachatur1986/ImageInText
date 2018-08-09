package example.am.imageintext;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_message;
    private ImageView iv_smiling, iv_laughing, iv_sad, iv_angry, iv_teasing, iv_inLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        et_message = findViewById(R.id.et_message);
        iv_smiling = findViewById(R.id.iv_smiling);
        iv_laughing = findViewById(R.id.iv_laughing);
        iv_sad = findViewById(R.id.iv_sad);
        iv_angry = findViewById(R.id.iv_angry);
        iv_teasing = findViewById(R.id.iv_teasing);
        iv_inLove = findViewById(R.id.iv_inLove);

        et_message.setOnClickListener(this);
        iv_smiling.setOnClickListener(this);
        iv_laughing.setOnClickListener(this);
        iv_sad.setOnClickListener(this);
        iv_angry.setOnClickListener(this);
        iv_teasing.setOnClickListener(this);
        iv_inLove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_angry:
                addImageBetweenText(((AppCompatImageView) v).getDrawable());
                break;
            case R.id.iv_inLove:
                addImageBetweenText(((AppCompatImageView) v).getDrawable());
                break;
            case R.id.iv_laughing:
                addImageBetweenText(((AppCompatImageView) v).getDrawable());
                break;
            case R.id.iv_sad:
                addImageBetweenText(((AppCompatImageView) v).getDrawable());
                break;
            case R.id.iv_smiling:
                addImageBetweenText(((AppCompatImageView) v).getDrawable());
                break;
            case R.id.iv_teasing:
                addImageBetweenText(((AppCompatImageView) v).getDrawable());
                break;
        }
    }

    private void addImageBetweenText(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 2, drawable.getIntrinsicHeight() / 2);

        int selectionCursor = et_message.getSelectionStart();
        et_message.getText().insert(selectionCursor, ".");
        selectionCursor = et_message.getSelectionStart();

        SpannableStringBuilder builder = new SpannableStringBuilder(et_message.getText());
        builder.setSpan(new ImageSpan(drawable), selectionCursor - ".".length(), selectionCursor, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        et_message.setText(builder);
        et_message.setSelection(selectionCursor);
    }
}
