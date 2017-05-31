package ir.aligorji.fluentvalidation.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ir.aligorji.fluentvalidation.CommandValidator;
import ir.aligorji.fluentvalidation.example.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final ExamCommand examCommand = new ExamCommand(this);

        mBinding.setCommand(examCommand);


        examCommand.setListener(new CommandValidator.OnChangeValidator()
        {
            @Override
            public void onChangeValidation(boolean isValid)
            {
                Toast.makeText(MainActivity.this, "XXXXX" + isValid + "XXXXXX", Toast.LENGTH_SHORT).show();
            }
        });

        //String.format(getString(R.string.validation_not_empty), "ali");

        //ruleFor(mBinding.txtEmail).onError(mBinding.txtEmail)

        /*new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mBinding.setZ("aligorji");
                mBinding.txtEmailLayout.setError("* Errrrrrrrrrrrrrrror\n* Errrrrrrrrrrrrrrror\n* Errrrrrrrrrrrrrrror\n");
            }
        },10000);*/

        mBinding.txtEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }
            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });

    }

    private OnErrorTarget ruleFor(TextView view)
    {
        return new OnErrorTarget(view);
    }

    public void submit(View view)
    {
        if (mBinding.getCommand().isValid(true))
        {
            Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
        }

    }

    public interface OnError
    {

    }

    public static class OnErrorTarget
    {

        private TextInputLayout inputLayout;
        private TextView view;
        private OnError listener;
        private TextView txt;


        public OnErrorTarget(TextView txt)
        {
            this.txt = txt;
        }

        public Rule onError(TextInputLayout inputLayout)
        {
            this.inputLayout = inputLayout;
            return new Rule(txt);
        }

        public Rule onError(TextView view)
        {
            this.view = view;
            return new Rule(txt);
        }

        public Rule onError(OnError listener)
        {
            this.listener = listener;
            return new Rule(txt);
        }
    }


    public static class Rule
    {

        private final TextView txt;

        public Rule(TextView txt)
        {
            this.txt = txt;
        }

        public Rule notEmpty()
        {
            //if (value == null || value.isEmpty())
            {

            }
            return this;
        }
    }

}
